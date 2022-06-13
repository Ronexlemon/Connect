package com.example.connect.AppViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.connect.apprepository.AppRepository
import com.example.connect.model.MenAsstes

import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AppViewModel
@Inject constructor(private  val repo:AppRepository):ViewModel() {
  private  val _response: MutableLiveData<MenAsstes> = MutableLiveData<MenAsstes>()
    val response: LiveData<MenAsstes>
        get() = _response

    init {
        getAllResponse()
    }

    private fun getAllResponse() {
        viewModelScope.launch {
            repo.getData().let { response->
                if(response.isSuccessful){
                    _response.postValue(response.body())
                }
            }

        }
    }
}