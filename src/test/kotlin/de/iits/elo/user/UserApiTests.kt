package de.iits.elo.user

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.map
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class UserApiTests {
    @LocalServerPort
    private var port: Int = -1

    val objectMapper = jacksonObjectMapper()

    @Test
    fun getAllUsers() {
        val (_, _, result) = "http://localhost:$port/users".httpGet().responseString()
        result
                .map { objectMapper.readValue<List<User>>(it) }
                .get() shouldBe listOf(
                User("Peter", "peter@iits-consulting.de"),
                User("Paul", "paul@iits-consulting.de"),
                User("Marry", "marry@iits-consulting.de"),
        )

    }

}
