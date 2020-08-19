package com.example.clima

class Main (temp:Double,feels_like:Double,temp_min:Double,temp_max:Double) {
    var temp = 0.00
    var feels_like = 0.00
    var temp_min = 0.00
    var temp_max = 0.00
    init {
        this.temp = temp
        this.feels_like = feels_like
        this.temp_min = temp_min
        this.temp_max = temp_max
    }

    fun temp_centigrados(): Double {
        var grados = this.temp- 273.15
        return grados
    }

    fun feels_like_centigrados():Double{
        var grados = this.feels_like -273.15
        return grados
    }

    fun temp_min_centigrados():Double{
        var grados = this.temp_min -273.15
        return grados
    }

    fun temp_max_centigrados():Double{
        var grados = this.temp_max -273.15
        return grados
    }
}