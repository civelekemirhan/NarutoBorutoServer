package com.example.routes

import com.example.models.ApiResponse
import com.example.models.Hero
import com.example.repository.HeroRepository
import com.example.repository.HeroRepositoryImpl
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.getAllheroes() {


    val heroRepository : HeroRepository by inject()

    get("/boruto/heroes") {

        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1..5)

            val apiResponse=heroRepository.getAllHeroes(page = page)

            call.respond(message = apiResponse,status=HttpStatusCode.OK)
        } catch (e: NumberFormatException) {
            call.respond(
                message = ApiResponse(success = true, message = "Only Numbers Allowed"),
                status = HttpStatusCode.BadRequest
            )

        }catch(e: IllegalArgumentException){
            call.respond(
                message = ApiResponse(success = true, message = "Heroes not found"),
                status = HttpStatusCode.BadRequest
            )
        }


    }

}