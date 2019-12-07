package io.pivotal.shinyay.controller

import com.azure.data.cosmos.CosmosClient
import com.azure.data.cosmos.CosmosContainer
import com.azure.data.cosmos.FeedOptions
import io.pivotal.shinyay.entity.Employee
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import javax.annotation.PostConstruct

@RestController
class EmployeeController(@Value("\${}") val cosmosDbUrl: String,
                         @Value("\${}") val cosmosDbKey: String,
                         @Value("\${}") val cosmosDbDatabase: String) {

    lateinit var cosmosContainer: CosmosContainer

    @PostConstruct
    fun init() {
        cosmosContainer = CosmosClient.builder()
                .endpoint(cosmosDbUrl)
                .key(cosmosDbKey)
                .build()
                .getDatabase(cosmosDbDatabase)
                .getContainer("Employee")
    }

    @GetMapping("/employees")
    fun getEmployees(): Flux<Unit> {
        val options: FeedOptions = FeedOptions()
        options.enableCrossPartitionQuery(true)
        return cosmosContainer.queryItems("SELECT TOP 20 * FROM Employee e", options)
                .map {
                    val results = mutableListOf<Employee>()
                    it.results().forEach {
                        val employee: Employee = Employee(it.getString("first_name"), it.getString("last_name"))
                        results.add(employee)
                    }
                }
    }

}