package com.example.mytestapplication

import java.util.*
import java.lang.Object as Object1

class Dollar(amount:Int) : Money() {

    fun times(multiplier:Int): Dollar {
        return Dollar(amount*multiplier)
    }

}

//TODO
//$5 + 10 CHF = $10 if rate is 2:1
//$5 * 2 = $10 //check
//Make "amount" private
//Dollar side effects? //check
//Money rounding?