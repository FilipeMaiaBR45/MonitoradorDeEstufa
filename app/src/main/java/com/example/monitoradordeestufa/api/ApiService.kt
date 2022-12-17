package com.example.monitoradordeestufa.api


import com.example.monitoradordeestufa.api.datas.DatasResponse
import retrofit2.http.GET

interface ApiService {
    @GET("datas/1")
    fun getData() : retrofit2.Call<DatasResponse>
}