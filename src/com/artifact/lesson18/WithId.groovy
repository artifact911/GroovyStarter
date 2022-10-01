package com.artifact.lesson18

trait WithId {

    Integer id

    boolean validate() {
        id > 0
    }
}