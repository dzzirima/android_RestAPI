package com.example.fansettechinician.service

import com.example.fansettechinician.service.DataModel.Destination

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DestinationService {
    @GET("users/")
    fun getDestinations() :Call<List<Destination>>

    @POST("users/")
    fun addDestination(@Body newDestination: Destination):Call<Destination>


}