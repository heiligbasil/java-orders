package com.lambdaschool.javaorders.repos

import com.lambdaschool.javaorders.model.Order
import org.springframework.data.repository.CrudRepository

interface OrderRepository : CrudRepository<Order, Long>