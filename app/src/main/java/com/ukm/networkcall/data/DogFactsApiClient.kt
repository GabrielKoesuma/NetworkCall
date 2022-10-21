package com.ukm.networkcall.data


import com.ukm.networkcall.models.DogFactsData
import retrofit2.Call
import retrofit2.http.GET

interface DogFactsApiClient {
    @GET("/api/facts?number=17")
    fun getFacts() : Call<DogFactsData>
}