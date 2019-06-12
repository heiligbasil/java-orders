package com.lambdaschool.javaorders.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import javax.persistence.JoinColumn
import javax.persistence.FetchType


@Entity
@Table(name = "orders")
class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val ordernum: Long = 0

    var orderamount: Double = 0.toDouble()
    var advanceamount: Double = 0.toDouble()

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customercode", nullable = false)
    @JsonIgnore
    var customer: Customer? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agentcode", nullable = false)
    @JsonIgnore
    var agent: Agent? = null

    var orderdescription: String? = null

    constructor() {}

    constructor(orderamount: Double, advanceamount: Double, customer: Customer?, agent: Agent?, orderdescription: String?)
    {
        this.orderamount = orderamount
        this.advanceamount = advanceamount
        this.customer = customer
        this.agent = agent
        this.orderdescription = orderdescription
    }
}