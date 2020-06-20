package com.example.demo.autowiringexample.validators

import com.example.demo.autowiringexample.Customer
import com.example.demo.autowiringexample.CustomerValidator
import org.springframework.stereotype.Component

@Component
class NameValidator : CustomerValidator {
    override fun validate(customer: Customer): Boolean {
        if (customer.fullName.isEmpty()) {
            throw Exception("Name is empty")
        }
        return true
    }
}