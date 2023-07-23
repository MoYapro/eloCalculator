package de.iits.elo.user

import java.util.UUID

data class User(
        val id: UUID = UUID.randomUUID(),
        val username: String,
        val displayName: String,
        val email: String,
)
