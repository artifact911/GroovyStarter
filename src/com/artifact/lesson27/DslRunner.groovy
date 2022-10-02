package com.artifact.lesson27

import static com.artifact.lesson27.DslBuilder.*

//    def email = new Email()
//    email.setFrom("from@mail.ru")
//    email.setTo("to@mail.ru")
//    email.detTitle("title")
//
//    def body = new EmailBody()
//    body.setText("qweqwe")
//    body.setImages(List.of("image.jpg"))
//
//    email.setBody(body)

    // все это сложно и давайте перепишем
    // builder
    mail {
        from "rom@mail.ru"
        to "to@mail.ru"
        title "title"
        body {
            text "qweqwe"
            images (['image.jpg', 'image2.png'])
        }
    }
