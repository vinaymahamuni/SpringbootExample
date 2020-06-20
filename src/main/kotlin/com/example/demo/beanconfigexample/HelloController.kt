package com.example.demo.beanconfigexample

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("hello")
class HelloController(
    @Autowired val hello: Hello
) {

    @GetMapping()
    fun hello(): Hello {
        return hello
    }

}
