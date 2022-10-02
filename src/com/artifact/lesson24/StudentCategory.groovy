package com.artifact.lesson24

import com.artifact.lesson18.WithId
import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@TupleConstructor
// @Mixin(WithId.class) // deprecated
class StudentCategory implements WithId {
    String firstName
    String lastName
    Integer age

    def getAt(Integer index) {
        index == 0 ? firstName : lastName
    }
}
