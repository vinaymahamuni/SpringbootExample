package com.example.demo.autowiringexample

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ValidateCustomerService(
    @Autowired val validators: List<CustomerValidator>
) {

    fun validateCustomer(customer: Customer): Boolean {
        validators.forEach { it.validate(customer) }
        print("Validation complete")
        return true
    }

}

