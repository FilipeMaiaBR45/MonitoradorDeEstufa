package com.example.monitoradordeestufa.api

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class ApiRepository @Inject constructor(private val apiService: ApiService) {
    fun getData() = apiService.getData()
}