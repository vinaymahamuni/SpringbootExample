package com.example.demo.autowiringexample.validators

import com.example.demo.autowiringexample.Customer
import com.example.demo.autowiringexample.CustomerValidator
import org.springframework.stereotype.Component

@Component
class DOBValidator : CustomerValidator {
    override fun validate(customer: Customer): Boolean {
        if (customer.dateOfBirth.isEmpty()) {
            throw Exception("Date Of Birth is invalid")
        }
        return true
    }
}