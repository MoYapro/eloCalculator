package de.iits.elo.testdata

import de.iits.elo.user.User
import java.util.*

val mockuser1 =
        User(
                id = UUID.fromString("11111111-58cc-4372-a567-0e02b2c3d479"),
                username = "peterUser",
                displayName = "Peter",
                email = "peter@iits-consulting.de",
                elo = 1
        )

val mockuser2 =
        User(
                id = UUID.fromString("22222222-58cc-4372-a567-0e02b2c3d479"),
                username = "paulUser",
                displayName = "Paul",
                email = "paul@iits-consulting.de",
                elo = 2
        )

val mockuser3 =
        User(
                id = UUID.fromString("33333333-58cc-4372-a567-0e02b2c3d479"),
                username = "marryUser",
                displayName = "Marry",
                email = "marry@iits-consulting.de",
                elo = 3
        )

