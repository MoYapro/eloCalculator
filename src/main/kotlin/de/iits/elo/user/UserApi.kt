package de.iits.elo.user

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
class UserApi {

    @GetMapping("/users")
    fun getAllUsers(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(listOf(
                User("Peter", "peter@iits-consulting.de"),
                User("Paul", "paul@iits-consulting.de"),
                User("Marry", "marry@iits-consulting.de"),
        ))
    }


}
