package com.twiekie.avantika_aplicativo_jmr.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.twiekie.avantika_aplicativo_jmr.domain.GetTotalsUseCase
import com.twiekie.avantika_aplicativo_jmr.domain.GetUProdUseCase
import com.twiekie.avantika_aplicativo_jmr.domain.GetUseCaseinventario
import com.twiekie.avantika_aplicativo_jmr.model.Inventariomodel
import com.twiekie.avantika_aplicativo_jmr.model.Productos
import com.twiekie.avantika_aplicativo_jmr.model.Totales
import com.twiekie.avantika_aplicativo_jmr.view.fragments.Inventario
import kotlinx.coroutines.launch

class ProductosViewMdel:ViewModel() {

    val inventarioo=MutableLiveData<List<Inventariomodel>?>()
    val totals=MutableLiveData<List<Totales>?>()
    val prodModel= MutableLiveData<List<Productos>?>()
    val isLoading=MutableLiveData<Boolean>()
    var getproducts=GetUProdUseCase()

    var gettotals=GetTotalsUseCase();

    var getinventario=GetUseCaseinventario();

    //var cantidad=MutableLiveData<Int>()
    //val _cantidad :LiveData<Int> = cantidad

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result=getproducts()
            if(!result.isNullOrEmpty()){
                prodModel.postValue(result)
            }
        }
    }
    fun total() {
        viewModelScope.launch {
            val result=gettotals()
            if(!result.isNullOrEmpty()){
                totals.postValue(result)

            }

        }
    }
    fun inventariod(){
        viewModelScope.launch {
            val result=getinventario()
            if(!result.isNullOrEmpty()){
                inventarioo.postValue(result)
            }

        }
    }
}