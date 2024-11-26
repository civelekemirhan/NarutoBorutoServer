package com.example.plugins

import com.example.routes.getAllheroes
import com.example.routes.root
import com.example.routes.searchHeroes
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        root()
        getAllheroes()
        searchHeroes()
        staticResources("/images","images")
    }
}
