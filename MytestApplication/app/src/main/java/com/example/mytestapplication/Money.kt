package com.example.mytestapplication

open class Money (amount:Int=0){
    var amount: Int = amount

    fun equalTo(any: Any): Boolean {
        var money = any as Money
        return amount == money.amount
    }
}