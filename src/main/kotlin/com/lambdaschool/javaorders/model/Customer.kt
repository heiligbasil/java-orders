package com.lambdaschool.javaorders.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import java.util.ArrayList



@Entity
@Table(name = "customer")
class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val customercode: Long = 0

    @Column(nullable = false)
    var customername: String? = null

    var customercity: String? = null
    var workingarea: String? = null
    var customercountry: String? = null
    var grade: String? = null
    var openingamount: Double = 0.toDouble()
    var receiveamount: Double = 0.toDouble()
    var paymentamount: Double = 0.toDouble()
    var outstandingamount: Double = 0.toDouble()
    var phone: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agentcode", nullable = false)
    @JsonIgnore
    var agentcode: Agent? = null

    @OneToMany(mappedBy = "customer", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonIgnore
    val orders = ArrayList<Order>()

    constructor()

    constructor(customername: String?, customercity: String?, workingarea: String?, customercountry: String?, grade: String?, openingamount: Double, receiveamount: Double, paymentamount: Double, outstandingamount: Double, phone: String?, agentcode: Agent?)
    {
        this.customername = customername
        this.customercity = customercity
        this.workingarea = workingarea
        this.customercountry = customercountry
        this.grade = grade
        this.openingamount = openingamount
        this.receiveamount = receiveamount
        this.paymentamount = paymentamount
        this.outstandingamount = outstandingamount
        this.phone = phone
        this.agentcode = agentcode
    }
}