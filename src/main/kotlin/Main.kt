package com.flurdy.kotlin.pizza

import freemarker.cache.ClassTemplateLoader
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.freemarker.FreeMarker
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.request.receiveParameters
import io.ktor.response.respond
import io.ktor.response.respondRedirect
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import io.ktor.routing.routing
import io.ktor.server.engine.commandLineEnvironment
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty


fun Application.module() {

    install(DefaultHeaders)
    install(CallLogging)
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }

    routing {
        get("/") {
            call.respond(
               FreeMarkerContent(
                   "index.ftl",
                     mapOf("top" to "tooop")))
        }
        static("/styles") {
            resources("styles")
        }
        route("/order"){
            get {
                call.respondRedirect("/", permanent = false)
            }
            post {
                val post = call.receiveParameters()
                if(post["pizza-id"] != null){
                   call.application.environment.log.info("PIZZA ORDERED ${post["pizza-id"]}")
                    call.respond(
                          FreeMarkerContent(
                                "index.ftl",
                                mapOf("orderState" to "Pizza ordered")))
                } else {
                    call.respond(
                          FreeMarkerContent(
                            "index.ftl",
                              mapOf("error" to "Invalid pizza order. Pineapple does not belong on a pizza")))
                }
            }
        }
    }
}

fun main(args: Array<String>) {

    embeddedServer(Netty, commandLineEnvironment(args)).start(wait = true)

}
