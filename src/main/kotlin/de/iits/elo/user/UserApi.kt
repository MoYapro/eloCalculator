package de.iits.elo.user

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController()
class UserApi {

    @GetMapping("/users", produces = ["application/json"])
    fun getAllUsers(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(
            listOf(
                User(displayName = "Peter", email = "peter@iits-consulting.de", username = ""),
                User(displayName = "Paul", email = "paul@iits-consulting.de", username = ""),
                User(displayName = "Marry", email = "marry@iits-consulting.de", username = ""),
            )
        )
    }

    @GetMapping("/users/{username}", produces = ["application/json"])
    fun getUserByUsername(@PathVariable username: String): ResponseEntity<User> {
        return ResponseEntity.ok(
            User(displayName = "I am Peter", email = "peter@iits-consulting.de", username = "peter")
        )
    }

    @GetMapping("/users/{username}/elo", produces = ["application/json"])
    fun getUserElo(@PathVariable username: String): ResponseEntity<Int> {
        return ResponseEntity.ok(1001)
    }

    @PutMapping("/users/{username}", consumes = ["application/json"], produces = ["application/json"])
    fun updateUser(@PathVariable username: String, @RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity.ok(user)
    }

    @PostMapping("/users", consumes = ["application/json"], produces = ["application/json"])
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity.ok(
            User(
                displayName = "I am new",
                email = "new@iits-consulting.de",
                username = "i_am_new"
            )
        )
    }


}
