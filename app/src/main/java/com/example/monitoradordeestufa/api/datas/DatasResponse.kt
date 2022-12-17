package com.example.monitoradordeestufa.api.datas


import com.google.gson.annotations.SerializedName

data class DatasResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("sensor_ldr")
    val sensorLdr: Int,
    @SerializedName("sensor_temp")
    val sensorTemp: Int
)