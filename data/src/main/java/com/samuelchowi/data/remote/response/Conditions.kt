package com.samuelchowi.data.remote.response

import com.squareup.moshi.Json

class Conditions(
    @Json(name = "type") var type: String? = null,
    @Json(name = "subtype") var subtype: String? = null,
    @Json(name = "rank") var rank: String? = null,
    @Json(name = "quantity") var quantity: Int? = null,
    @Json(name = "chance") var chance: Int? = null
)
