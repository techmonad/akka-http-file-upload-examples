package com.techmonad.rest

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.io.StdIn

object RestServer extends App with FileUploadApi {

  implicit val system = ActorSystem("ActorSystem")
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  implicit val executionContext = system.dispatcher

  val bindingFuture = Http().newServerAt("0.0.0.0", 9000).bindFlow(route)

  println(s"Server online at http://localhost:9000/\nPress RETURN to stop...")
  StdIn.readLine() // let it run until user presses return
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => system.terminate()) // and shutdown when done


}
