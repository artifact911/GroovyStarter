package com.artifact.lesson22

import java.lang.reflect.Field
import java.lang.reflect.Method

// напишем свой мета-класс
// мета-класс это аналог Class.class java
class CustomMetaClass {

    // методы можно представить Map, где ключем будет название, а значением Method.class
    // мы тут упростили, т.к. в случае перегрузки мы не сможем указать уникальный ключ
    Map<String, Method> methods = new HashMap<>()

    // и набор полей
    Map<String, Field> fields = new HashMap<>()

}
