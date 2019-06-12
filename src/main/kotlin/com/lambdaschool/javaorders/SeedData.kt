package com.lambdaschool.javaorders

import com.lambdaschool.javaorders.model.Agent
import com.lambdaschool.javaorders.model.Customer
import com.lambdaschool.javaorders.model.Order
import com.lambdaschool.javaorders.repos.AgentRepository
import com.lambdaschool.javaorders.repos.CustomerRepository
import com.lambdaschool.javaorders.repos.OrderRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Transactional
@Component
class SeedData(private val custrepos: CustomerRepository, private val agentrepos: AgentRepository, private val ordersrepos: OrderRepository) : CommandLineRunner
{
    @Throws(Exception::class)
    override fun run(vararg args: String)
    {
        val a01 = Agent("Ramasundar", "Bangalore", 0.15, "077-25814763", "")
        val a02 = Agent("Alex ", "London", 0.13, "075-12458969", "")
        val a03 = Agent("Alford", "New York", 0.12, "044-25874365", "")
        val a04 = Agent("Ravi Kumar", "Bangalore", 0.15, "077-45625874", "")
        val a05 = Agent("Santakumar", "Chennai", 0.14, "007-22388644", "")
        val a06 = Agent("Lucida", "San Jose", 0.12, "044-52981425", "")
        val a07 = Agent("Anderson", "Brisban", 0.13, "045-21447739", "")
        val a08 = Agent("Subbarao", "Bangalore", 0.14, "077-12346674", "")
        val a09 = Agent("Mukesh", "Mumbai", 0.11, "029-12358964", "")
        val a10 = Agent("McDen", "London", 0.15, "078-22255588", "")
        val a11 = Agent("Ivan", "Torento", 0.15, "008-22544166", "")
        val a12 = Agent("Benjamin", "Hampshair", 0.11, "008-22536178", "")

        val c01 = Customer("Holmes", "London", "London", "UK", "2", 6000.00, 5000.00, 7000.00, 4000.00, "BBBBBBB", a03)
        val c02 = Customer("Micheal", "New York", "New York", "USA", "2", 3000.00, 5000.00, 2000.00, 6000.00, "CCCCCCC", a08)
        val c03 = Customer("Albert", "New York", "New York", "USA", "3", 5000.00, 7000.00, 6000.00, 6000.00, "BBBBSBB", a08)
        val c04 = Customer("Ravindran", "Bangalore", "Bangalore", "India", "2", 5000.00, 7000.00, 4000.00, 8000.00, "AVAVAVA", a11)
        val c05 = Customer("Cook", "London", "London", "UK", "2", 4000.00, 9000.00, 7000.00, 6000.00, "FSDDSDF", a06)
        val c06 = Customer("Stuart", "London", "London", "UK", "1", 6000.00, 8000.00, 3000.00, 11000.00, "GFSGERS", a03)
        val c07 = Customer("Bolt", "New York", "New York", "USA", "3", 5000.00, 7000.00, 9000.00, 3000.00, "DDNRDRH", a08)
        val c08 = Customer("Fleming", "Brisban", "Brisban", "Australia", "2", 7000.00, 7000.00, 9000.00, 5000.00, "NHBGVFC", a05)
        val c09 = Customer("Jacks", "Brisban", "Brisban", "Australia", "1", 7000.00, 7000.00, 7000.00, 7000.00, "WERTGDF", a05)
        val c10 = Customer("Yearannaidu", "Chennai", "Chennai", "India", "1", 8000.00, 7000.00, 7000.00, 8000.00, "ZZZZBFV", a10)
        val c11 = Customer("Sasikant", "Mumbai", "Mumbai", "India", "1", 7000.00, 11000.00, 7000.00, 11000.00, "147-25896312", a02)
        val c12 = Customer("Ramanathan", "Chennai", "Chennai", "India", "1", 7000.00, 11000.00, 9000.00, 9000.00, "GHRDWSD", a10)
        val c13 = Customer("Avinash", "Mumbai", "Mumbai", "India", "2", 7000.00, 11000.00, 9000.00, 9000.00, "113-12345678", a02)
        val c14 = Customer("Winston", "Brisban", "Brisban", "Australia", "1", 5000.00, 8000.00, 7000.00, 6000.00, "AAAAAAA", a05)
        val c15 = Customer("Karl", "London", "London", "UK", "0", 4000.00, 6000.00, 7000.00, 3000.00, "AAAABAA", a06)
        val c16 = Customer("Shilton", "Torento", "Torento", "Canada", "1", 10000.00, 7000.00, 6000.00, 11000.00, "DDDDDDD", a04)
        val c17 = Customer("Charles", "Hampshair", "Hampshair", "UK", "3", 6000.00, 4000.00, 5000.00, 5000.00, "MMMMMMM", a09)
        val c18 = Customer("Srinivas", "Bangalore", "Bangalore", "India", "2", 8000.00, 4000.00, 3000.00, 9000.00, "AAAAAAB", a07)
        val c19 = Customer("Steven", "San Jose", "San Jose", "USA", "1", 5000.00, 7000.00, 9000.00, 3000.00, "KRFYGJK", a12)
        val c20 = Customer("Karolina", "Torento", "Torento", "Canada", "1", 7000.00, 7000.00, 9000.00, 5000.00, "HJKORED", a04)
        val c21 = Customer("Martin", "Torento", "Torento", "Canada", "2", 8000.00, 7000.00, 7000.00, 8000.00, "MJYURFD", a04)
        val c22 = Customer("Ramesh", "Mumbai", "Mumbai", "India", "3", 8000.00, 7000.00, 3000.00, 12000.00, "Phone No", a02)
        val c23 = Customer("Rangarappa", "Bangalore", "Bangalore", "India", "2", 8000.00, 11000.00, 7000.00, 12000.00, "AAAATGF", a01)
        val c24 = Customer("Venkatpati", "Bangalore", "Bangalore", "India", "2", 8000.00, 11000.00, 7000.00, 12000.00, "JRTVFDD", a07)
        val c25 = Customer("Sundariya", "Chennai", "Chennai", "India", "3", 7000.00, 11000.00, 7000.00, 11000.00, "PPHGRTS", a10)

        val o01 = Order(1000.00, 600.00, c13, a03, "SOD")
        val o02 = Order(3000.00, 500.00, c19, a10, "SOD")
        val o03 = Order(4500.00, 900.00, c07, a10, "SOD")
        val o04 = Order(2000.00, 400.00, c16, a07, "SOD")
        val o05 = Order(4000.00, 600.00, c22, a02, "SOD")
        val o06 = Order(2000.00, 300.00, c12, a12, "SOD")
        val o07 = Order(3500.00, 2000.00, c02, a08, "SOD")
        val o08 = Order(2500.00, 400.00, c03, a04, "SOD")
        val o09 = Order(500.00, 100.00, c23, a06, "SOD")
        val o10 = Order(4000.00, 700.00, c07, a10, "SOD")
        val o11 = Order(1500.00, 600.00, c08, a04, "SOD")
        val o12 = Order(2500.00, 400.00, c25, a11, "SOD")

        agentrepos.save(a01)
        agentrepos.save(a02)
        agentrepos.save(a03)
        agentrepos.save(a04)
        agentrepos.save(a05)
        agentrepos.save(a06)
        agentrepos.save(a07)
        agentrepos.save(a08)
        agentrepos.save(a09)
        agentrepos.save(a10)
        agentrepos.save(a11)
        agentrepos.save(a12)

        custrepos.save(c01)
        custrepos.save(c02)
        custrepos.save(c03)
        custrepos.save(c04)
        custrepos.save(c05)
        custrepos.save(c06)
        custrepos.save(c07)
        custrepos.save(c08)
        custrepos.save(c09)
        custrepos.save(c10)
        custrepos.save(c11)
        custrepos.save(c12)
        custrepos.save(c13)
        custrepos.save(c14)
        custrepos.save(c15)
        custrepos.save(c16)
        custrepos.save(c17)
        custrepos.save(c18)
        custrepos.save(c19)
        custrepos.save(c20)
        custrepos.save(c21)
        custrepos.save(c22)
        custrepos.save(c23)
        custrepos.save(c24)
        custrepos.save(c25)

        ordersrepos.save(o01)
        ordersrepos.save(o02)
        ordersrepos.save(o03)
        ordersrepos.save(o04)
        ordersrepos.save(o05)
        ordersrepos.save(o06)
        ordersrepos.save(o07)
        ordersrepos.save(o08)
        ordersrepos.save(o09)
        ordersrepos.save(o10)
        ordersrepos.save(o11)
        ordersrepos.save(o12)
    }
}
