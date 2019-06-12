package com.lambdaschool.javaorders.service

import com.lambdaschool.javaorders.model.Customer
import java.util.ArrayList

interface CustomerService
{
    fun findAll(): MutableList<Customer>

    fun findCustomerByName(customername: String): Customer

    fun delete(customercode: Long)

    fun update(customer: Customer, id: Long): Customer

    fun save(customer: Customer): Customer
}
