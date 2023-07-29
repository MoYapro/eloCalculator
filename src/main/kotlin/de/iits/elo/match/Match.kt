package de.iits.elo.match

import java.util.*

data class Match(
    val id: UUID = UUID.randomUUID(),
    val whitePlayer: UUID,
    val blackPlayer: UUID,
    val outcome: Outcome,
    val playedOn: String,
)
