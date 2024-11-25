package com.example.plugins

import com.example.di.koinModule
import io.ktor.server.application.*
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin(){
   install(Koin){
       slf4jLogger()
       modules(koinModule)  // Burada Koin modülünüzü yükleyin

   }
}