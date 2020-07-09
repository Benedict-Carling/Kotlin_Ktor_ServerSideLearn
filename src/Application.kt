package com.example

import io.ktor.application.*
import io.ktor.http.ContentType
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

private val userData = "{\"users\": [\"Nate\", \"Megan\", \"John\" }"

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    routing {
        get("/") {
            call.respondText("hello", ContentType.Text.Plain)
        }

        post("/") {
            val post = call.receive<String>()
            call.respondText("received $post from the post body", ContentType.Text.Plain)
        }

        get("/users") {
            call.respondText(userData)
        }
    }
}

