package de.iits.elo.ranking

import de.iits.elo.user.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
class RankingApi(val userRepository: UserRepository) {

    @GetMapping("/ranking")
    fun ranking(@RequestParam top: Int?): ResponseEntity<List<Ranking>> {
        if(null == top) throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Top parameter required to get top players")
        return ResponseEntity.ok(
            userRepository.findTopUsers(top)
                .mapIndexed { index, user -> Ranking(index + 1, user.elo ?: 0, user) }
        )
    }
}
