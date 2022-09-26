package com.artifact.lesson8

import java.util.regex.Matcher
import java.util.regex.Pattern

class RegexRunner {

    static void main(String[] args) {

        // /w - один символ
        // /d - одна цифра
        // /w+ - ноль или более
        // /w* - один или более

        String value = "one 1 two 2 three 333"

        // JavaStyle - нужно экранировать
//        String regex = "\\w+ \\d+"

        // GroovyStyle
//        String regex = /\w+ \d+/

        // Разбили на группы и теперь в Первых скобках группа 1 и группа 2 во вторых
        String regex = /(\w+) (\d+)/

//        Pattern pattern = Pattern.compile(regex)
        // Равнозначная запись верхней
        Pattern pattern = ~regex

//        Matcher matcher = pattern.matcher(value)
        // Равнозначная запись верхней и Pattern мы теперь не используем
        Matcher matcher = value =~regex

        // проверит всю строку на соответствие
//        def result = matcher.matches()

        // 1 вариант использования matcher
        // Равнозначная запись верхней
        def result = value ==~ regex
        println result



        // 2 вариант использования matcher
        // тут мы ищем подтексты во всем нашем тексте
//        while (matcher.find()) {
//            // если группу не указывать, то обращаемся ко всему выражению
//            println matcher.group()
//            println matcher.group(1)
//            println matcher.group(2)
//            println "-----"
//        }

        // аналог while но неудобно
//        println matcher[0]
//        println matcher[1]
//        // хочу только вторую группу в этом индексе
//        println matcher[1][2]
//        println matcher[2]
//
//        println matcher[1..2]

//        matcher.each (group -> println group)
        matcher.each ((group, group1, group2) -> {
            println group
            println group1
            println group2
        })
    }
}
