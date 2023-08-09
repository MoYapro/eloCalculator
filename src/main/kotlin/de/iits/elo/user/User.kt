package de.iits.elo.user

import de.iits.elo.AbstractKotlinPersistable
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class User(
        val username: String,
        val displayName: String,
        val email: String,
): AbstractKotlinPersistable()
