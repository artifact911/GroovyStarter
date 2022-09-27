package com.artifact.lesson12


class LoopsRunner {

    static void main(String[] args) {
        def list = [1, 2, 3, 4]

        // i меньше размера листа
//        for (i in 0..<list.size()) {
//            println i
//        }
//        println "-----"

        // i меньше или равно размера листа
        // не путать этот in с in из if/switch
//        for (i in 0..list.size()) {
//            println i
//        }
//        println "-----"

        // iter
        // не путать этот in с in из if/switch
//        for (value in list) {
//            println value
//        }
//        println "-----"

        // Но чаще используется другая конструкция
        // у числа вызываем метод upto() и на вход ему передаем размер листа а дальше идет Closure, а его мы можем
        // написать за скобками
//        0.upto(list.size()) {
//            println it
//        }
//        println "-----"

        // если хотим перебрать список в обратную сторону
//        list.size().downto(0) {
//            println it
//        }
//        println "-----"

        // НЕВКЛЮЧИТЕЛЬНО перебираем. За последний индекс не вылезем получается
//        list.size().times {
//            println it
//        }

        // перебрать с определенным шагом. Тут установим шаг 2
        0.step(5, 2) {
            println it
        }
    }
}
