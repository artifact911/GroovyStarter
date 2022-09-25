package com.artifact.lesson7

/**
 * Как можно создать строку
 * 1. " "
 * 2. ' '
 * 3. """ """
 * 4. ''' '''
 * 5. / /
 * 6. $/ /$
 */

char char1 = 'H'

// позволяет использовать внутри " " кавычки без экранирования
def name = 'Ivan "Hi!"'
println name

// позволяет использовать внутри ' ' кавычки без экранирования
// StringInterpolation(канкатенация строк)
def value = "Ivan $name"
println value

// позволяет использовать внутри " " и ' ' кавычки без экранирования
// StringInterpolation(канкатенация строк)
def value2 = """
SELECT *
FROM table
WHERE name = $name
"""
println value2


// позволяет использовать внутри " " и ' ' кавычки без экранирования
// StringInterpolation(канкатенация строк)
def value3 = '''
SELECT *
FROM table
WHERE name = $name
'''
println value3

// StringInterpolation позволяет взять не только переменную, но и функцию
def value4 = """
SELECT *
FROM table
WHERE name = ${getWithPrefix(name)}
"""
println value4

def getWithPrefix(String name) {
    "prefix-" + name
}

// ничего не экранируем (часто используется в регулярных выражениях)
// можно использовать интерполяцию
def value5 = /Hello world $name/
println value5

// то же самое, только еще и $ можно не экранировать в регулярках
def value6 = $/Hello world $name/$
println value6

// Со строками можно работать как с массивом

// взял элемент во втором индексе
println name[2]
// взял первый элемент отсчитывая с конца
println name[-1]
// взял в первого по третий
println name[1..3]
// разсмножил строку
println name * 3
// вычел из строки первое встретившейся совпадение
println name - 'Iv'
println name - 'an'





