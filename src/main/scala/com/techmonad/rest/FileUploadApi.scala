package com.techmonad.rest


import java.io.File

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.directives.FileInfo

trait FileUploadApi {

  val route =
    pathPrefix("upload") {
      path("csv") {
        post {
          storeUploadedFile("csv", tempDestination) {
            case (metadata, file) =>
              println(metadata + " " + file)
              // file.delete()
              complete(StatusCodes.OK)
          }
        }
      } ~
        path("text") {
          post {
            storeUploadedFile("text", tempDestination) {
              case (metadata, file) =>
                println(metadata + " " + file)
                // file.delete()
                complete(StatusCodes.OK)
            }
          }
        }
    }

  def tempDestination(fileInfo: FileInfo): File =
    File.createTempFile("uploaded-file-", s"-${fileInfo.fileName}")

}
