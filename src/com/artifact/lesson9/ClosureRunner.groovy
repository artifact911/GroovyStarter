package com.artifact.lesson9

import java.util.function.Function
import java.util.stream.Stream

class ClosureRunner {

    static void main(String[] args) {

        Function<Integer, Integer> func = value -> value + value

//        def result = func.apply(5)
//        println result

        // Closure похож на лямбда-выражение но тут справа лябда
//        Closure closure = value -> value + value

        // а теперь справа не лямбда и что бы мы там не написали return последняя строчка
        Closure closure = { value ->
            println value
            value + value }

        // можно задать дефолтные параметры, если ничего в метод не передали
//        Closure closure = { value = 78 ->
//            println value
//            value + value }

        // более того, мы один параметр можем вовсе не указывать и его имя заменить на зарезервированное it
//        Closure closure = {
//            println it
//            it + it }

        // если мы хотим Closure без параметров то ставим просто ->
//        Closure closure = {->}


//        def result = closure.call(5)
        // упростили
        def result = closure(5)
        println result

        Stream.of(1, 2, 3, 4)
//        .map(func)
        .map(closure)
//        .map(String::valueOf)
        // можем сослаться на метод и он вернет Closure
        .map(String.&valueOf)
        .forEach(System.out::println)

        int x = 11
//        check(x > 0, { println x**2 })

        // тк Closure передается последним параметром, мы перед ней можем закрыть скобку с передаваемыми параметрами
        // и это сделано для того, что б мы могли перенести фигурную скобку на другую строку и теперь это похоже
        // на if где после check(условие) {что делаем}
        check(x > 0) {
            println x**2
        }
    }

    static def check(boolean condition, Closure closure) {
        if(condition) {
            closure()
        }
    }
}
