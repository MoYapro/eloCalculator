package de.iits.elo.testdata

import de.iits.elo.user.User
import java.util.*

val mockuser1 =
        User(
                id = UUID.fromString("11111111-58cc-4372-a567-0e02b2c3d479"),
                username = "Peter",
                displayName = "Der Peter",
                email = "peter@elo.com"
        )

val mockuser2 =
        User(
                id = UUID.fromString("22222222-58cc-4372-a567-0e02b2c3d479"),
                username = "Maraike",
                displayName = "Die Maraike",
                email = "maraike@elo.com"
        )

