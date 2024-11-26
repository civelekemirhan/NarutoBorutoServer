package com.example.routes

import com.example.repository.HeroRepository
import com.example.repository.HeroRepositoryImpl
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.searchHeroes(){
   val heroRepository:HeroRepository by inject()


    get("/boruto/heroes/search"){
        val name= call.request.queryParameters["name"].toString()

        val apiResponse = heroRepository.searchHeroes(name)

        call.respond(
            message = apiResponse,
            status=HttpStatusCode.OK
        )

    }
}