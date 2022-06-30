package com.example.connect.AppViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.connect.apprepository.AppRepository

import com.example.connect.model.MenAsstes
import com.example.connect.model.Products

import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AppViewModel
@Inject constructor(private  val repo:AppRepository):ViewModel() {
//  private  val _response: MutableLiveData<List<Products>> = MutableLiveData<List<Products>>()
//    val response: LiveData<List<Products>>
//        get() = _response
    var _state = MutableStateFlow(emptyList<Products>())
    val state: StateFlow<List<Products>>
        get() = _state

    init {
       // getAllResponse()
        getdataRes()
    }

    private fun getdataRes() {
        viewModelScope.launch {
            val pro = repo.getData()
            _state.value = pro.body()!!
        }
    }
//
//    private fun getAllResponse() {
//        viewModelScope.launch {
//            repo.getData().let { response->
//                if(response.isSuccessful){
//                    _response.postValue(response.body())
//                    Log.i("Tag",response.body().toString())
//                }
//                else{
//                    Log.i("Tag","Failed")
//                }
//            }
//
//        }
//    }
}