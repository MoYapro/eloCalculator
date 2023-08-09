package de.iits.elo.match

import de.iits.elo.AbstractKotlinPersistable
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "match")
class Match(
        val whitePlayer: UUID,
        val blackPlayer: UUID,
        val outcome: Outcome,
        val playedOn: String,
) : AbstractKotlinPersistable()
