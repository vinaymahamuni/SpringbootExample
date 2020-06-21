package com.example.demo.autowiringexample.validators

import com.example.demo.autowiringexample.Customer
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PanValidatorTest {

    @Test
    fun `return true if pan length is 10 characters`() {
        val customer = Customer("", "", "ABCDM1234C", "")
        PanValidator().validate(customer) shouldBe true
    }

    @Test
    fun `throw exception if pan length is 9`() {
        val customer = Customer("", "", "abcdm2345", "")
        assertThrows<Exception> { PanValidator().validate(customer) }
            .message shouldBe "pan invalid. length should be exact 10"
    }

}