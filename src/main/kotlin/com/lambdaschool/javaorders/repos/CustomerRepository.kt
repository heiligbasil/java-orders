package com.lambdaschool.javaorders.repos

import com.lambdaschool.javaorders.model.Customer
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Long> {
    fun findByCustomername(customername:String)
}