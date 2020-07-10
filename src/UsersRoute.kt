package com.example

import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get

fun Routing.users() {
    get("/users") {
        call.respondText(userData)
    }
}