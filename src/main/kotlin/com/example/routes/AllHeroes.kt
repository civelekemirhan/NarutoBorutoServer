package com.example.routes

import com.example.models.ApiResponse
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllheroes() {

    get("/boruto/heroes") {

        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1..5)

            call.respond(page)
        } catch (e: NumberFormatException) {
            call.respond(
                message = ApiResponse(success = true, messsage = "Only Numbers Allowed"),
                status = HttpStatusCode.BadRequest
            )

        }catch(e: IllegalArgumentException){
            call.respond(
                message = ApiResponse(success = true, messsage = "Heroes not found"),
                status = HttpStatusCode.BadRequest
            )
        }


    }

}