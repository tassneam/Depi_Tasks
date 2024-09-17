package com.example.dependencyinjectionretrofit

import retrofit2.http.GET

interface ApiService {
    @GET("albums")
    suspend fun getAlbumList(): List<Album>
}