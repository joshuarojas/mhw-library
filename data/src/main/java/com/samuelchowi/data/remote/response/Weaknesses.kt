package com.samuelchowi.data.remote.response

import com.squareup.moshi.Json

class Weaknesses(
    @Json(name = "element") var element: String? = null,
    @Json(name = "stars") var stars: Int? = null,
    @Json(name = "condition") var condition: String? = null
)