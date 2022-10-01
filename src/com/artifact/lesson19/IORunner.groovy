package com.artifact.lesson19

import groovy.io.FileType

class IORunner {

    static void main(String[] args) {

        // read

        // просто считаем файл
        // не нужно открывать никаких потоков ввода-вывода, ни закрывать их. Все произойдет автоматически
        def file = new File(".gitignore")
        println file.text

        // если мы хотим считать построчно, а не весь:
        file.each { line -> println line }

        // если все же на нужен InputStream
        file.withInputStream {
            def allText = new String(it.readAllBytes())
            println allText
        }

        // Если нужно, мы можем создать свой Reader и передать туда нужный Charset (по умолчанию UTF-8)
        // но в таком случае нам придется закрывать поток
//        try (def reader = file.newReader()) {
//            // что-то делаем
//        }


        // write
        def file2 = new File("text.txt")
        // так он будет перезатирать все
        file2.text = "Some text"
        // чтобы не перезатирать моржно дописывать при помощи >> (System.lineSeparator - добавил разделитель)
        file2 << System.lineSeparator() << "New Line" << System.lineSeparator()

        // Теперь наш writer получает все, что считал reader
        // StringWriter() у нас в inMemory то его закрывать не нужно, в отличии от reader
//        def writer = new StringWriter()
//        try (def reader = file.newReader()) {
//            writer << reader
//        }

        // как мы открывали inputStream мы может открыть и outputStream
        file2.withOutputStream {} // на вход oStream и его не нужно закрывать

        // можем создать writer bkb oStream но их закрывать придется т.к. он не в inMemory
//        file2.newWriter()
//        file2.newOutputStream()

        // так же как Files в Java класс File в Groovy может итерироваться по директориям
        def srcDir = new File("src")

        // для каждой директории в src применим closure (там окажется только одна директроия com)
        srcDir.eachDir { println it }

        // если мы хотим итерироваться по всему дереву, то:
        srcDir.eachDirRecurse { println it }

        // если нужно получить файлы/папки можно иначе передав в параметры то, что хотим:
        // (в src у нас лежит только один FirstScript)
        srcDir.eachFile(FileType.FILES) { println it }
    }
}
