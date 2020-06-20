package com.example.demo.autowiringexample.validators

import com.example.demo.autowiringexample.Customer
import com.example.demo.autowiringexample.CustomerValidator
import org.springframework.stereotype.Component

@Component
class PanValidator : CustomerValidator {
    override fun validate(customer: Customer): Boolean {
        if (customer.pan.length != 10) {
            throw Exception("pan invalid. length should be exact 10")
        }
        return true
    }
}