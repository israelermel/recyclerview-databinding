package com.example.myapplication.pattern.mediator

class MediatorMain {
    val mediator = ChatMediator()

    val john = ChatUser(mediator, "John")

    init {
        mediator
            .addUser(ChatUser(mediator, "Alice"))
            .addUser(ChatUser(mediator, "Bob"))
            .addUser(john)

        john.send("Hi, everyone")

    }
}