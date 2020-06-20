package com.example.demo.autowiringexample


interface CustomerValidator {
    fun validate(customer: Customer): Boolean
}