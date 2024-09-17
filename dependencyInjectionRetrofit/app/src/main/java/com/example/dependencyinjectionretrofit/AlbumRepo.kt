package com.example.dependencyinjectionretrofit

import javax.inject.Inject

class AlbumRepo @Inject constructor(val apiService: ApiService) {
    suspend fun getAlbumList():List<Album>{
        return apiService.getAlbumList()
    }
}