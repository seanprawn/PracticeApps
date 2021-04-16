package com.example.mytestapplication

class Franc (amount:Int) : Money() {

    fun times(multiplier:Int): Franc{
        return Franc(amount*multiplier)
    }

//    fun equalTo(any: Any): Boolean {
//        var money = any as Money
//        return amount == money.amount
//    }
}