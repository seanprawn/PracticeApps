package com.example.mytestapplication

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun testMultiplication()
    {
        val five = Dollar(5)
//        var product: Dollar = five.times(2)
        assertEquals(Dollar(10).amount, five.times(2).amount)
        assertEquals(Dollar(15).amount, five.times(3).amount)
//        product = five.times(3)
//        assertEquals(15, product)
    }

    @Test
    fun testFrancMultiplication()
    {
        val five = Franc(5)
//        var product: Dollar = five.times(2)
        assertEquals(Franc(10).amount, five.times(2).amount)
        assertEquals(Franc(15).amount, five.times(3).amount)
//        product = five.times(3)
//        assertEquals(15, product)
    }
    @Test
    fun testEquality()
    {
//        assertTrue(Dollar(5).equalTo(Dollar(5)))
        assertFalse(Dollar(5).equalTo(Dollar(6)))
//        assertTrue(Franc(5).equalTo(Franc(5)))
//        assertFalse(Franc(5).equalTo(Franc(6)))
//        assertFalse(Franc(5).equalTo(Dollar(5)))
    }
}
//TODO
//We need to be able to add amounts in two different currencies and convert the result given a set of exchange rates.
//We need to be able to multiply an amount (price per share) by a number (number of shares) and receive an amount.