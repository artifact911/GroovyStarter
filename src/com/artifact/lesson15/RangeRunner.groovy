package com.artifact.lesson15

class RangeRunner {

    static void main(String[] args) {
//        def range = 2..8    // Создал range от 2 до 8

        // не включая 8
        def range = 2..<8
        assert range.getClass() == IntRange

        // В нулевом индексе 2, в третьем получается 5
        assert range.get(3) == 5

        // Проверка, входит ли 8 в наш диапазон
        assert range.contains(7)
        assert !range.contains(9)

        range.each { println it}

        // создать range можно и так:
        ('a'..'d').each { println it}

        // и по енаму
        (WeekDay.MO..WeekDay.FR).each { println it}

        // в обратную сторону можно если написать интуитивно-понятно (5..2)
        (WeekDay.WE..WeekDay.MO).each { println it}
    }
}
