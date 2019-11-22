package io.pivotal.shinyay.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloAzureController(@Value("\${application.message:Non Configuration by Spring Cloud Config}") var message: String) {

    @GetMapping("/hello")
    fun hello() = message
}