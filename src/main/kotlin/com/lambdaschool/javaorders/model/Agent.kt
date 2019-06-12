package com.lambdaschool.javaorders.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import java.util.ArrayList

@Entity
@Table(name = "agent")
class Agent
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val agentcode: Long = 0

    var agentname: String? = null
    var workingarea: String? = null
    var commission:Double=0.toDouble()
    var phone: String? = null
    var country: String? = null

    @OneToMany(mappedBy = "agent", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonIgnore
    val customers: List<Customer> = listOf<Customer>()

    @OneToMany(mappedBy = "agent", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonIgnore
    val orders = ArrayList<Order>()

    constructor()

    constructor(agentname: String?, workingarea: String?, commission: Double, phone: String?, country: String?)
    {
        this.agentname = agentname
        this.workingarea = workingarea
        this.commission = commission
        this.phone = phone
        this.country = country
    }
}