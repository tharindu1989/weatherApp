package com.test.weatherapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

/**
 * Created By Tharindu on 7/12/2019
 *
 */
open class BaseViewModel : AndroidViewModel {

    constructor(application: Application) : super(application)

    var error: MutableLiveData<String> = MutableLiveData()

    protected fun onError(errorStr: String) {
        error.value = errorStr
    }

}