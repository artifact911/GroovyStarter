package com.artifact.lesson18

import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@TupleConstructor
// @Mixin(WithId.class) // deprecated
class StudentWithTrait implements WithId {
    String firstName
    String lastName
    Integer age

    def getAt(Integer index) {
        index == 0 ? firstName : lastName
    }
}
