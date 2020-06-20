package com.example.demo.beanconfigexample

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan("com.example.demo.beanconfigexample")
class HelloConfig {

    @Bean
    fun getHello(): Hello {
        return Hello("Vinay")
    }
}