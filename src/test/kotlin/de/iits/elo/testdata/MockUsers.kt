package de.iits.elo.testdata

import de.iits.elo.user.User
import java.util.*

val mockuser1 =
    User(
        id = UUID.fromString("1111111-1167-4d37-beb7-9020d2060ef9"),
        username = "Peter",
        displayName = "Der Peter",
        email = "peter@elo.com"
    )

val mockuser2 =
    User(
        id = UUID.fromString("2222222-1167-4d37-beb7-9020d2060ef9"),
        username = "Maraike",
        displayName = "Die Maraike",
        email = "maraike@elo.com"
    )

