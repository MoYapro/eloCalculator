package de.iits.elo.db

import de.iits.elo.testdata.mockuser1
import de.iits.elo.user.User
import de.iits.elo.user.UserRepository
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DbSetupTest {

    @Autowired
    private lateinit var userRepository: UserRepository


    @Test
    fun canCreateReadEntity() {
        val user = mockuser1
        userRepository.save(user)
        val userFromDb: Optional<User> = userRepository.findById(user.id)
        userFromDb.get() shouldBe user
    }
}
