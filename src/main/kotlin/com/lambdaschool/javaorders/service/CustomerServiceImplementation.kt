package com.lambdaschool.javaorders.service


import com.lambdaschool.javaorders.model.Customer
import com.lambdaschool.javaorders.model.Order
import com.lambdaschool.javaorders.repos.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service(value = "customerService")
class CustomerServiceImplementation : CustomerService
{
    @Autowired
    lateinit var custrepos: CustomerRepository

    override fun findAll(): MutableList<Customer>
    {
        val outCustomers = mutableListOf<Customer>()
        custrepos.findAll().toCollection(outCustomers)
        return outCustomers
    }

    override fun findCustomerByName(customername: String): Customer
    {
        custrepos.findAll().forEach {
            if (it.customername == customername)
            {
                return@findCustomerByName it
            }
        }

        throw EntityNotFoundException("Customer $customername not found!")
    }

    @Transactional
    override fun save(customer: Customer): Customer
    {
        val newCustomer = Customer(
                customer.customername,
                customer.customercity,
                customer.workingarea,
                customer.customercountry,
                customer.grade,
                customer.openingamount,
                customer.receiveamount,
                customer.paymentamount,
                customer.outstandingamount,
                customer.phone,
                customer.agentcode
        )

        return custrepos.save(newCustomer)
    }

    override fun update(customer: Customer, id: Long): Customer
    {
        val currentCustomer = custrepos.findById(id).orElseThrow { EntityNotFoundException(id.toString()) }

        currentCustomer.customername = customer.customername
        currentCustomer.customercity = customer.customercity
        currentCustomer.workingarea = customer.workingarea
        currentCustomer.customercountry = customer.customercountry
        currentCustomer.grade = customer.grade
        currentCustomer.paymentamount = customer.paymentamount
        currentCustomer.openingamount = customer.openingamount
        currentCustomer.receiveamount = customer.receiveamount
        currentCustomer.outstandingamount = customer.outstandingamount
        customer.phone.let { currentCustomer.phone = customer.phone }
        customer.agentcode.let { currentCustomer.agentcode = customer.agentcode }

        for (order: Order in customer.orders)
        {
            currentCustomer.orders.add(order)
        }

        return custrepos.save(currentCustomer)
    }

    override fun delete(customercode: Long)
    {
        val currentCustomer = custrepos.findById(customercode)
                .orElseThrow { EntityNotFoundException(customercode.toString()) }

        custrepos.deleteById(customercode)
    }
}

