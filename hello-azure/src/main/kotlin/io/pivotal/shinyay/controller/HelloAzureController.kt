package io.pivotal.shinyay.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloAzureController {

    @GetMapping("/hello")
    fun hello() = "Hello, Azure Spring Cloud"
}