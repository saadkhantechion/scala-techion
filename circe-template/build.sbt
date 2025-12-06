//Basic Setup
scalaVersion := "3.4.0"
name         := "cirice-template"
organization := "org.techion.templates"

//Scalafix setup
semanticdbEnabled := true

//Dependencies Setup

val circeVersion = "0.15.0-M1"
libraryDependencies ++= Seq(
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  compilerPlugin("com.github.ghik" %% "zerowaste" % "0.2.18" cross CrossVersion.full)
)
//Sbt aliases
addCommandAlias("fmt", "; scalafmtAll ; scalafmtSbt ; scalafixAll")
addCommandAlias("fmtc", "; scalafmtCheckAll ; scalafmtSbtCheck ; scalafixAll --check")
addCommandAlias("ci", ";clean ; compile ; fmtc ; test")
addCommandAlias("lci", "; clean ; compile ; fmt ; fmtc ; test")
