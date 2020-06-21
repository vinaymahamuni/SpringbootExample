package com.example.demo.autowiringexample.validators

import com.example.demo.autowiringexample.Customer
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NameValidatorTest {

    @Test
    fun `return true name is not empty`() {
        val customer = Customer("Vinay", "", "", "")
        NameValidator().validate(customer) shouldBe true
    }

    @Test
    fun `throw exception if name is empty`() {
        val customer = Customer("", "", "", "")
        assertThrows<Exception> { NameValidator().validate(customer) }
            .message shouldBe "Name is empty"
    }

}