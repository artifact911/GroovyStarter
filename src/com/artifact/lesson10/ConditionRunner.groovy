package com.artifact.lesson10

/**
 * что мы можем юзать в условии if
 *
 * boolean           is true
 * Collection/Map    is not empty
 * Matcher           has match
 * String/GString    is not empty
 * Number/Char       != 0
 * reference         =! null
 *
 * Все потому, что во всех этих типах переопределена функция asBoolean. Мы можем для своих классов
 * пепеопределять ее как хотим
 */

class ConditionRunner {

    static void main(String[] args) {
        int x = 11

        // JavaStyle
        if(x > 0) {
            println x
        }

        // Number/Char != 0
        if(x) {
            println x
        }

        // сунули свой объект с переопределенным asBoolean
        def person = new Person(19)
        if(person) {
            println person.getId()
        }

        // В Java мы часто проверяем на null, прежде чем вызвать что-то:
        if(person != null) {
            person.getId()
        }
        // что на этот стчет делает groovy
        person?.getId()

        // и оператор Елвиса для if-else (два ветвления)
        // GroovyStyle Old
        if (x) {
            println x
        } else {
            println 1
        }
        // GroovyStyle
//        def result = x != null ? x : 1
        // упростим
//        def result = x ? x : 1 // типа если х не налл, тогда верни х ...

        // и для таких вариантов был создан новый оператор Элвиса
        def result = x ?: 1
        println result
    }
}
