// Use Scala 2.13 (Spark 4.x requires this)
name                  := "spark-template"
Global / organization := "org.techion.templates"
Global / scalaVersion := "2.13.18"
Global / version      := "0.1.0-SNAPSHOT"

Global / libraryDependencies += compilerPlugin("com.github.ghik" %% "zerowaste" % "1.0.0" cross CrossVersion.full)

lazy val library        = project.in(file("library"))
lazy val script         = project.in(file("script")).dependsOn(library)
lazy val spark_template = project.in(file(".")).aggregate(library, script)

//Sbt aliases
addCommandAlias("ci", "; clean ; compile ; test ; library/package")
addCommandAlias("lci", "; clean ; compile ; test ; library/package ; dependencyUpdates")
