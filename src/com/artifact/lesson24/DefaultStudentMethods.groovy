package com.artifact.lesson24

// я говорю, что эти методы и поля могут быть использованы только этим классом
@Category(StudentCategory.class)
class DefaultStudentMethods {

    // теперь мой метод знает с чем работает и я могу юзать this
    def testStr() {
        println "$age, $firstName"
    }

    // можем сами написать статический метод, который на вход будет принимать self
    static def anotherMethod(StudentCategory self, String value) {
        println "$self, args: $value"
    }
}
