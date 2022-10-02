package com.artifact.lesson22

import com.artifact.lesson17.Student
import org.codehaus.groovy.runtime.DefaultGroovyMethods

class MetaClassRunner {

    static void main(String[] args) {

        // начнем в наш мета класс добавлять какие-то левые методы
        def customMetaClass = new CustomMetaClass()

        // этого метода нет в нашем мета классе, но он есть в defaultGroovyMethods
        // и мы добавим его в customMetaClass. Для этого:
        println "Hello"

        // получим этот метод по имени и передадим туда класс от имени которого мы вызываем метод и то, что в метод передаем
        def method = DefaultGroovyMethods.class.getMethod("println", Object.class, Object.class)

        // теперь положим его в наш customMetaClass
        customMetaClass.methods.put("println", method)


        // посмотрим как он вызывается
        // получим наш метод по ключу
        // в строке 16 этот метод вызовется у класса MetaClassRunner, а мы можем вызвать например у Student.class
        def student = new Student()
        def printlnMethod = customMetaClass.methods.get("println")

        printlnMethod.invoke(student, student, "Test 2")

        // MetaClassImpl - это основаня реализация metaClass
        // можем получить его у нашего студента
        println student.metaClass

        // ExpandoMetaClass - он позволяет нам динамически в наши метаКлассы новые поля и методы во время выполения
        // обращаюсь к мета-классу студента я могу добавить ему что-то

        // поле
        student.metaClass.abc = "Test property"

        // метод
        // метод добавить сложно, поэтому метод мы добавляем как поле, просто в виде closure
        student.metaClass.test = {
            println "it is a new method"
        }
        student.test()

        // если у всех есть мета класс, значит и у объекта класса Class  имы можем и туда что-то добавить:
        // вызываем metaClass у объекта класса Class student.class
        // и в него тож можно добавить какой-то метод
        // !!! Мы это создали после создания объекта student и если запустим - получим исключение, т.к. у этого студента
        // нет этго метода, но у вновьсозданных - будет
        student.class.metaClass.newMethod = { int value ->
            println "new method in class Student, $value"
        }
//        student.newMethod(28)
        new Student().newMethod(28)

        // и теперь если мы у студента возьмем метаКласс, это будет ExpandoMetaClass
        println student.metaClass

        // ProxyMetaClass - interceptors
    }
}
