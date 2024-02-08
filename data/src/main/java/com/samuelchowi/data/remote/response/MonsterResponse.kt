package com.samuelchowi.data.remote.response

import com.squareup.moshi.Json

class MonsterResponse(
    @Json(name = "id") var id: Int? = null,
    @Json(name = "name") var name: String? = null,
    @Json(name = "type") var type: String? = null,
    @Json(name = "species") var species: String? = null,
    @Json(name = "description") var description: String? = null,
    @Json(name = "elements") var elements: ArrayList<String> = arrayListOf(),
    @Json(name = "ailments") var ailments: ArrayList<String> = arrayListOf(),
    @Json(name = "locations") var locations: ArrayList<String> = arrayListOf(),
    @Json(name = "resistances") var resistances: ArrayList<String> = arrayListOf(),
    @Json(name = "weaknesses") var weaknesses: ArrayList<Weaknesses> = arrayListOf(),
    @Json(name = "rewards") var rewards: ArrayList<Rewards> = arrayListOf()
)