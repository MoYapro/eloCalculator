package de.iits.elo.ranking

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.map
import de.iits.elo.testdata.mockuser3
import de.iits.elo.user.UserRepository
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpHeaders

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RankingApiTest {

    @LocalServerPort
    private var port: Int = -1

    @Autowired
    private lateinit var userRepository: UserRepository

    private val objectMapper = jacksonObjectMapper()

    @Test
    fun top10Ranking() {
        val expectedRanking = Ranking(
            rank = 1, elo = 3, player = mockuser3
        )
        val (_, _, result) = "http://localhost:$port/ranking?top=10".httpGet()
            .header(HttpHeaders.ACCEPT to "application/json")
            .responseString()

        result
            .map { objectMapper.readValue<List<Ranking>>(it) }
            .get()[0] shouldBeEqualToComparingFields expectedRanking
    }

}
