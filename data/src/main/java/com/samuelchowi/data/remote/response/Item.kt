package com.samuelchowi.data.remote.response

import com.squareup.moshi.Json

class Item(
    @Json(name = "id") var id: Int? = null,
    @Json(name = "name") var name: String? = null,
    @Json(name = "description") var description: String? = null,
    @Json(name = "rarity") var rarity: Int? = null,
    @Json(name = "carryLimit") var carryLimit: Int? = null,
    @Json(name = "value") var value: Int? = null
)