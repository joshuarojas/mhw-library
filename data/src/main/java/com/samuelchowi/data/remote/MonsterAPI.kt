package com.samuelchowi.data.remote

import com.samuelchowi.data.remote.response.MonsterResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MonsterAPI {

    @GET("/monsters")
    fun getAll(): Flow<List<MonsterResponse>>

    @GET("/monsters?q={\"name\":{\"\$like\":\"%{filter}%\"}}")
    fun getByName(@Path("filter") filter: String): Flow<Response<List<MonsterResponse>>>

    @GET("/monsters?q={\"type\":{\"\$like\":\"%{filter}%\"}}")
    fun getByType(@Path("filter") filter: String): Flow<Response<List<MonsterResponse>>>

    @GET("/monsters?q={\"weaknesses.element\":{\"\$like\":\"%{filter}%\"}}")
    fun getByWeakness(@Path("filter") filter: String): Flow<Response<List<MonsterResponse>>>

    @GET("/monsters?q={\"elements\":{\"\$like\":\"%{filter}%\"}}")
    fun getByElement(@Path("filter") filter: String): Flow<Response<List<MonsterResponse>>>

    @GET("/monsters?q={\"ailments\":{\"\$like\":\"%{filter}%\"}}")
    fun getByAilment(@Path("filter") filter: String): Flow<Response<List<MonsterResponse>>>
}