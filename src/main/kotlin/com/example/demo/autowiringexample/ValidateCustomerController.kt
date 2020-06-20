package com.example.demo.autowiringexample

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class ValidateCustomerController(
    @Autowired val validators: List<CustomerValidator>
) {

    @PostMapping("/validate")
    fun validateCustomer(@RequestBody customer: Customer): String {

        validators.forEach { it.validate(customer) }
        print("Validation complete")
        return "customer data validation complete"
    }

}
