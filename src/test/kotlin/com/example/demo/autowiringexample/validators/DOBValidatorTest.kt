package com.example.demo.autowiringexample.validators

import com.example.demo.autowiringexample.Customer
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DOBValidatorTest {

    @Test
    fun `return true date of birth is not empty`() {
        val customer = Customer("", "2018-02-13", "", "")
        DOBValidator().validate(customer) shouldBe true
    }

    @Test
    fun `throw exception if date of birth is empty`() {
        val customer = Customer("", "", "", "")
        assertThrows<Exception> { DOBValidator().validate(customer) }
            .message shouldBe "Date Of Birth is invalid"
    }

}