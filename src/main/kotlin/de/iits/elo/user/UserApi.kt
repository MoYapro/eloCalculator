package de.iits.elo.user

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController()
class UserApi {

    @GetMapping("/users")
    fun getAllUsers(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(listOf(
                User(displayName = "Peter", email = "peter@iits-consulting.de", username = ""),
                User(displayName = "Paul", email = "paul@iits-consulting.de", username = ""),
                User(displayName = "Marry", email = "marry@iits-consulting.de", username = ""),
        ))
    }

    @PostMapping("/users", consumes = ["application/json"])
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity.ok(User(displayName = "I am new", email = "new@iits-consulting.de", username = "i_am_new"))
    }


}
