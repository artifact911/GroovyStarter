package com.artifact.lesson26.task1

import com.artifact.lesson17.Student

/**
 * 1. Добавить метод инициализации make() для создания любых классов. Метод должен проксировать вызов на соответствующий
 конструктор;
 */
class Task1 {

    // создавать всякие штки не используя new а make()
    static void main(String[] args) {

        // добавим в метаКласс класса Class метод make
        Class.metaClass.make = { Object[] values ->

            // посмотрим кто есть кто
            println owner
            println thisObject
            println delegate // в консоле увидим, что делегат изменился

            // когда мы подправляем метаКласс, то делегаты автоматом относятся к тем объектам, у которых вызовется
            // мотод make()
            // тут мы запускаем конструктор
            delegate.metaClass.invokeConstructor(values)
        }

        def hashSet = HashSet.make([1, 2, 3, 4, 4])
        def student = Student.make("Ivan", "Ivanov", 20)
        def student2 = Student.make()

        println hashSet
        println student
        println student2
    }
}
