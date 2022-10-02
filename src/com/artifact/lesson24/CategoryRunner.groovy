package com.artifact.lesson24

class CategoryRunner {

    static void main(String[] args) {

        def student = new StudentCategory(age: 18, firstName: "Ivan")

        // но создав Category этот объект не будет юзать сам эти методы. Его нужно попросить используя use()
        // по сути в методе use() происходит добавление всех методов из Category класса в metaClass всех объектов
        // внутри блока Closure. После выхода из блока Closure - удаляются из метаКласс
        // в строчке 16 у нас уже не будет этого метода и мы получим исключение
        use(DefaultStudentMethods.class) {
            student.testStr()
            student.anotherMethod("Test arg")
        }
//        student.testStr()
    }
}
