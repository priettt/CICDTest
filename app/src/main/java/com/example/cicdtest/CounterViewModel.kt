package com.example.cicdtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val count = MutableLiveData(0)

    fun getCount(): LiveData<Int> {
        return count
    }

    fun onButtonPressed() {
        count.value = count.value?.plus(1)
    }
}
