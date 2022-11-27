package com.example.routes

import com.example.models.orderStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.listOrderRoute() {
    get("/order") {
        if (orderStorage.isNotEmpty()) {
            call.respond(orderStorage)
        }
    }
}

fun Route.getOrderRoute() {
    get("/order/{id?}") {
        val id = call.parameters["id"] ?: return@get call.respondText(
            text = "Bad Request",
            status = HttpStatusCode.BadRequest
        )
        val order = orderStorage.find { it.number == id } ?: return@get call.respondText(
            text = "Not Found",
            status = HttpStatusCode.NotFound
        )
        call.respond(order)
    }
}

fun Route.totalOrderRoute() {
    get("/order/{id?}/total") {
        val id = call.parameters["id"] ?: return@get call.respondText(
            text = "Bad Request",
            status = HttpStatusCode.BadRequest
        )
        val order = orderStorage.find { it.number == id } ?: return@get call.respondText(
            text = "Not Found",
            status = HttpStatusCode.NotFound
        )
        val totalOrders = order.contents.sumOf { it.amount * it.price }
        call.respond(totalOrders)
    }
}