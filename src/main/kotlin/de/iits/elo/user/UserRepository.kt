package de.iits.elo.user

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository : CrudRepository<User, UUID> {
    fun findUserByUsername(username: String): User?
    @Query("select u from User u order by u.elo DESC")
    fun findTopUsers(top: Int): List<User>
}
