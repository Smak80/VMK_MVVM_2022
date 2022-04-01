package ru.smak.vmk_mvvm

class Factorial {

    fun calc(n: Int): Double = if (n <= 1) 1.0 else n * calc(n-1)

}