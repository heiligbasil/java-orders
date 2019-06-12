package com.lambdaschool.javaorders.controller

import com.lambdaschool.javaorders.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customer")
class CustomerController
{
    @Autowired
    lateinit var customerService: CustomerService

    @GetMapping(value = ["/order"], produces = ["application/json"])
    fun listAllOrders(): ResponseEntity<*>
    {
        val listOfCusts = customerService.findAll()
        return ResponseEntity(listOfCusts, HttpStatus.OK)
    }

    @GetMapping(value = ["/name/{customername}"], produces = ["application/json"])
    fun getOrderByName(@PathVariable customername: String): ResponseEntity<*>
    {
        val listOfOrds = customerService.findCustomerByName(customername)
        return ResponseEntity(listOfOrds, HttpStatus.OK)
    }
}