package com.chs.plugins

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello, Coutube Music Server", ContentType.Text.Html)
        }
    }
}
