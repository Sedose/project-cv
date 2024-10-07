ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.5.1"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaPlayground2"
  )

libraryDependencies += "com.lihaoyi" % "scalatags_3" % "0.13.1"
