package com.myapp.arthurgenthial.network

import com.myapp.arthurgenthial.model.ForecastList
import com.myapp.arthurgenthial.model.ForecastResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "http://api.openweathermap.org/data/2.5/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface TempApiService {
    @GET("/forecast?cnt=10&units=metric")
    fun getTemp(): Call<List<ForecastResult>>
}

object TempApi {
    val retrofitService : TempApiService by lazy {
        retrofit.create(TempApiService::class.java) }
}

class ApiService {

}