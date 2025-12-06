//Basic Setup
scalaVersion := "3.7.1"
name         := "basic-techion"
organization := "com.ftlt.techion"

//Scalafix setup
semanticdbEnabled := true

//Dependencies Setup
libraryDependencies += compilerPlugin("com.github.ghik" %% "zerowaste" % "1.0.0" cross CrossVersion.full)

//Sbt aliases
addCommandAlias("fmt", "; scalafmtAll ; scalafmtSbt ; scalafixAll")
addCommandAlias("fmtc", "; scalafmtCheckAll ; scalafmtSbtCheck ; scalafixAll --check")
addCommandAlias("ci", "; fmtc ; test ")
addCommandAlias("lci", "; fmt ; fmtc ; test ; dependencyUpdates")
