package com.example.mytestapplication

class Dollar(amount:Int=0) {

    var amount: Int = amount

    fun times(multiplier:Int): Dollar{
//        amount *= multiplier
        return Dollar(amount*multiplier)
    }
}

//TODO
//$5 + 10 CHF = $10 if rate is 2:1
//$5 * 2 = $10 //check
//Make "amount" private
//Dollar side effects? //check
//Money rounding?