//Basic Setup
scalaVersion := "3.7.1"
name         := "di-template"
organization := "org.techion.templates"

//Scalafix setup
semanticdbEnabled := true

//Dependencies Setup
libraryDependencies += compilerPlugin("com.github.ghik" %% "zerowaste" % "1.0.0" cross CrossVersion.full)

//Sbt aliases
addCommandAlias("fmt", "; scalafmtAll ; scalafmtSbt ; scalafixAll")
addCommandAlias("fmtc", "; scalafmtCheckAll ; scalafmtSbtCheck ; scalafixAll --check")
addCommandAlias("ci", "; fmtc ; test ")
addCommandAlias("lci", "; clean ; compile   ; fmt ; fmtc ; test ; dependencyUpdates")
