package de.iits.elo.match

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class MatchApi {
    @GetMapping("/matches")
    fun getAllMatches(): ResponseEntity<List<Match>> {
        return ResponseEntity.ok(
            listOf(
                Match(
                    blackPlayer = UUID.randomUUID(),
                    whitePlayer = UUID.randomUUID(),
                    outcome = Outcome.DRAW,
                    playedOn = "2023-07-21T17:56:50Z"
                )
            )
        )
    }

    @PostMapping("/matches")
    fun postMatch(@RequestBody newMatch: Match): ResponseEntity<Match> {
        return ResponseEntity.ok(newMatch)
    }
}
