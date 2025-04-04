package com.compose.concept.data.remote

import com.compose.concept.data.local.entity.UserEntity
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<UserEntity>

}