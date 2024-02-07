package com.samuelchowi.data.remote.response

import com.squareup.moshi.Json

class Rewards(
    @Json(name = "id") var id: Int? = null,
    @Json(name = "item") var item: Item? = Item(),
    @Json(name = "conditions") var conditions: ArrayList<Conditions> = arrayListOf()
)