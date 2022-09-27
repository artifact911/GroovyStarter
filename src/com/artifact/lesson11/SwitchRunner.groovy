package com.artifact.lesson11

import com.artifact.lesson10.Person

/**
 * Работает, т.к. переопределен метод isCase и мы можем переопределить его где угодно. Переопределим в Person
 */

class SwitchRunner {

    static void main(String[] args) {
        int x = 9

        switch (x) {
            case String.class:      // class писать не обязательно провреяется типа instanceOf
                println 0
                break
            case 5:                 // equals или ==. в груви по ссылке проверяется ===
                println 1
                break
            case new Person(29): // вызов person.isCase(x)
                println 5
                break
            case [1, 3, 5, 9]:      // если наш x попадет в любое из этих чисел, то true. list.isCase(x)
                println 4
                break
            case ~/\d+/:            // выполняется pattern.matcher(x.toString).matches - соответствие x этому паттерну
                println 2
                break
            case { it % 5 == 0 }:
                println 3
                break
            default:
                println "None"
                break
        }

        if (x in [1, 3, 6, 9]) {
            println x
        }
    }
}
