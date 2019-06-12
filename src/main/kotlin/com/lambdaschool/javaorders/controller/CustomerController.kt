package com.lambdaschool.javaorders.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customer")
class CustomerController
{
    @Autowired
    private val orderService: OrderService? = null

    @GetMapping(value = ["/order"], produces = ["application/json"])
    fun listAllOrders(): ResponseEntity<*>
    {
        val listOfCusts = orderService!!.findAll()
        return ResponseEntity(listOfCusts, HttpStatus.OK)
    }

    @GetMapping(value = ["/name/{customername}"], produces = ["application/json"])
    fun getOrderByName(@PathVariable customername: String?): ResponseEntity<*>
    {
        val listOfOrds = orderService!!.findAllByCustomername(customername)
        return ResponseEntity(listOfOrds, HttpStatus.OK)
    }
}