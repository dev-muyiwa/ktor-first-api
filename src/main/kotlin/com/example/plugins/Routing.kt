package com.example.plugins

import com.example.routes.customerRouting
import com.example.routes.getOrderRoute
import com.example.routes.listOrderRoute
import com.example.routes.totalOrderRoute
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {

    routing {
        customerRouting()
        listOrderRoute()
        getOrderRoute()
        totalOrderRoute()
    }
}
