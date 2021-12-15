name := "akka-http-file-upload-examples"

version := "0.1"

scalaVersion := "2.13.5"


libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.6.17",
  "com.typesafe.akka" %% "akka-stream" % "2.6.17",
  "com.typesafe.akka" %% "akka-http" % "10.2.4",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.2.4" % Test
)
