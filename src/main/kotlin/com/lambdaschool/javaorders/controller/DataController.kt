package com.lambdaschool.javaorders.controller

import com.lambdaschool.javaorders.model.Customer
import com.lambdaschool.javaorders.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("/data")
class DataController
{
    @Autowired
    private val customerService: CustomerService? = null

    @DeleteMapping(value = ["/customer/delete/{customercode}"], consumes = ["application/json"])
    fun deleteCustomerById(@PathVariable customercode: Long): ResponseEntity<*>
    {
        customerService!!.delete(customercode)

        return ResponseEntity<Any>(HttpStatus.OK)
    }

    @PutMapping(value = ["/customer/update/{customercode}"])
    fun updateCustomerById(@RequestBody updateCustomer: Customer, @PathVariable customercode: Long): ResponseEntity<*>
    {
        customerService!!.update(updateCustomer, customercode)

        return ResponseEntity<Any>(HttpStatus.OK)
    }

    @PostMapping(value = ["/customer/new"], consumes = ["application/json"], produces = ["application/json"])
    fun addNewCustomer(@Valid @RequestBody newCustomer: Customer): ResponseEntity<*>
    {
        var customerCopy: Customer = newCustomer
        customerCopy = customerService!!.save(customerCopy)

        // set the location header for the newly created resource
        val responseHeaders = HttpHeaders()
        val newCustomerURI: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{customercode}").buildAndExpand(customerCopy.customercode).toUri()

        responseHeaders.location = newCustomerURI

        return ResponseEntity<Any>(null, responseHeaders, HttpStatus.CREATED)
    }
}