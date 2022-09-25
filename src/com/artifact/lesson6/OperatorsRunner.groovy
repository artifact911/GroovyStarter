package com.artifact.lesson6

assert 1 + 2 == 3
assert 4 - 3 == 1
assert 3 * 5 == 15
// внимание! В java тут был бы 1. Если мы ходим целочисленное деление то нужно юзать intdiv()
assert 3 / 2 == 1.5
assert 3.intdiv(2) == 1
assert 10 % 3 == 1
assert 2**3 == 8

// приведение типов
//    def result = (int) (3 / 2) // javaStyle
def result = (3 / 2) as Integer // groovyStyle. Можно так приводить к любому типу данных переопределив метод asType(clazz)

println result
println result <= 29
println result === Integer.valueOf(1)
println result * 130 === 130
println result <=> 130




