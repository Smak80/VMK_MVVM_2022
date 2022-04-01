package ru.smak.vmk_mvvm.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.smak.vmk_mvvm.Factorial

class MainViewModel : ViewModel() {

    private var _n: Int = 0
    private val factorial = Factorial()

    var res: MutableLiveData<Double> = MutableLiveData()

    var n: String
        get() = _n.toString()
        set(value) {
            _n = value.toIntOrNull() ?: 0
            res.postValue(factorial.calc(_n))
        }

}