package com.example.monitoradordeestufa.dataFragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.monitoradordeestufa.api.ApiRepository
import com.example.monitoradordeestufa.api.datas.DatasResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(private val apiRepository: ApiRepository ) : ViewModel() {

    private val _datas : MutableLiveData<DatasResponse> = MutableLiveData()
    val datas : LiveData<DatasResponse> =_datas

    fun getData(){
        viewModelScope.launch(Dispatchers.IO) {
            val response : Call<DatasResponse> = apiRepository.getData()
            response.enqueue(object : Callback<DatasResponse>{
                override fun onResponse(
                    call: Call<DatasResponse>,
                    response: Response<DatasResponse>
                ) {
                    if (response.code() == 200){
                        Log.i("responseee", "${response.body()}")
                        _datas.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<DatasResponse>, t: Throwable) {
                     Log.i("error", "$call, $t")
                }

            })
        }

    }

   suspend fun refresh(){
        getData()
        delay(10000)
    }


}