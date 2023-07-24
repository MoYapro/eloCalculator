package de.iits.elo.user

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.map
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpHeaders

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class UserApiTests {
    @LocalServerPort
    private var port: Int = -1

    val objectMapper = jacksonObjectMapper()

    @Test
    fun getAllUsers() {
        val (_, _, result) = "http://localhost:$port/users".httpGet()
            .header(HttpHeaders.ACCEPT to "application/json")
            .responseString()
        val userDisplayNames = result
            .map { objectMapper.readValue<List<User>>(it) }
            .get()
            .map(User::displayName)
        userDisplayNames shouldBe listOf("Peter", "Paul", "Marry")
    }

    @Test
    fun createUser() {
        val newUser = User(displayName = "I am new", email = "new@iits-consulting.de", username = "i_am_new")
        val (_, _, result) = "http://localhost:$port/users".httpPost(
        )
            .header(HttpHeaders.CONTENT_TYPE to "application/json")
            .jsonBody(objectMapper.writeValueAsString(newUser))
            .responseString()

        val createdUser: User = objectMapper.readValue(result.get())
        createdUser.username shouldBe newUser.username
        createdUser.email shouldBe newUser.email
        createdUser.displayName shouldBe newUser.displayName
        createdUser.id shouldNotBe newUser.id
    }

    @Test
    fun getUserByUsername() {
        val expectedUser = User(displayName = "I am Peter", email = "peter@iits-consulting.de", username = "peter")

        val (_, _, result) = "http://localhost:$port/users/${expectedUser.username}".httpGet()
            .header(HttpHeaders.ACCEPT to "application/json")
            .responseString()

        val foundUser: User = objectMapper.readValue(result.get())
        foundUser.username shouldBe expectedUser.username
        foundUser.email shouldBe expectedUser.email
        foundUser.displayName shouldBe expectedUser.displayName
        foundUser.id shouldNotBe expectedUser.id
    }

    @Test
    fun updateUser() {
        val expectedUser = User(displayName = "I am Peter", email = "peter@iits-consulting.de", username = "peter")

        val (_, _, result) = "http://localhost:$port/users/${expectedUser.username}".httpPut()
            .header(HttpHeaders.ACCEPT to "application/json")
            .header(HttpHeaders.CONTENT_TYPE to "application/json")
            .body(objectMapper.writeValueAsString(expectedUser))
            .responseString()

        val updatedUser: User = objectMapper.readValue(result.get())
        updatedUser shouldBe expectedUser
    }

}
