package com.artifact.lesson5

import groovy.transform.CompileStatic

// можно переписать на alias
//import java.sql.Date

import java.sql.Date as SqlDate

class VariableRunner {

    /**
     * byte, short, int, long, BigInteger
     * float, double, BigDecimal
     * char
     * boolean
     */
    @CompileStatic
    static void main(String[] args) {

        Integer value = 5
        BigInteger value2 = 35G
        BigDecimal value3 = 3.3G

        def value4 = 5
        def value5 = 35G
        def value6 = 3.3G

//        new SqlDate()
    }
}
