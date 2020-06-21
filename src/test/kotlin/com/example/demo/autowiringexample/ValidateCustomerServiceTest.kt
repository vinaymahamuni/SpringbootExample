package com.example.demo.autowiringexample

import com.example.demo.autowiringexample.validators.DOBValidator
import com.example.demo.autowiringexample.validators.NameValidator
import com.example.demo.autowiringexample.validators.PanValidator
import io.kotlintest.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class ValidateCustomerServiceTest(
) {
    val panValidator = mockk<PanValidator>()
    val DOBValidator = mockk<DOBValidator>()
    val nameValidator = mockk<NameValidator>()

    @Test
    fun `validate customer`() {

        val customer = Customer(
            "Vinay",
            "01/01/1990",
            "ABCDM1234D",
            "G0000000"
        )
        every { panValidator.validate(any()) } returns true
        every { DOBValidator.validate(any()) } returns true
        every { nameValidator.validate(any()) } returns true

        val expected = ValidateCustomerService(listOf(panValidator)).validateCustomer(customer)

        expected shouldBe true
    }

    @Test
    fun `throws exception if any validation fails`() {

        val customer = Customer(
            "Vinay",
            "01/01/1990",
            "ABCDM1234D",
            "G0000000"
        )
        every { panValidator.validate(any()) } throws Exception("pan is invalid")
        every { DOBValidator.validate(any()) } returns true
        every { nameValidator.validate(any()) } returns true


        assertThrows<Exception> { ValidateCustomerService(listOf(panValidator)).validateCustomer(customer) }
            .message shouldBe "pan is invalid"
    }
}