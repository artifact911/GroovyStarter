package com.artifact.lesson16

import com.artifact.lesson10.Person

class IteratesRunner {

    static void main(String[] args) {

        // делаем какое-то условие и если какой-то объект удовлетворяет условиям возвращаем boolean
        assert [1, 4, 7, 9].any { it % 2 == 0 }

        // находит первое соответствие нашему условию
        assert [1, 3, 4, 7, 9].find { it % 2 == 0 } == 4

        // находит все соответствия
        assert [1, 4, 7, 9].findAll { it % 2 != 0 } == [1, 7, 9]

        // как и в стриме, возвращаем коллекцию
        assert (2..4).collect() == [2, 3, 4]

        def person = new Person(25)
        person.each { println it }

        // можем пердавать фильтр абсолютно любой, но он должет соответствовать условию isCase
        // в grep мы передаем все что угодно и у него вызывается isCase

        // засунем паттерн на одни числа
        assert ["asd", "dsf", "12", "546", "234df"].grep(~/\d+/) == ["12", "546"]

        // засунем closure
        assert ["asd", "dsf", "12", "546", "234df"].grep { it.length() > 4 } == ["234df"]
    }
}
