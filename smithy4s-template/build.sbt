//Basic Setup
scalaVersion := "3.7.1"
name         := "smithy4s-techion"
organization := "com.ftlt.techion"

//Scalafix setup
semanticdbEnabled := true
semanticdbVersion := scalafixSemanticdb.revision

//Dependencies Setup
libraryDependencies += compilerPlugin("com.github.ghik" %% "zerowaste" % "1.0.0" cross CrossVersion.full)
libraryDependencies ++= Seq(
  "com.disneystreaming.smithy4s" %% "smithy4s-http4s"         % smithy4sVersion.value,
  "com.disneystreaming.smithy4s" %% "smithy4s-http4s-swagger" % smithy4sVersion.value,
  "org.http4s"                   %% "http4s-ember-server"     % "0.23.33",
  "software.amazon.smithy"        % "smithy-cli"              % "1.64.0"
)

import smithy4s.codegen.Smithy4sCodegenPlugin
enablePlugins(Smithy4sCodegenPlugin)

//Sbt aliases
addCommandAlias("fmt", "; scalafmtAll ; scalafmtSbt ; scalafixAll")
addCommandAlias("fmtc", "; scalafmtCheckAll ; scalafmtSbtCheck ; scalafixAll --check")
addCommandAlias("ci", "; clean ; compile ; fmtc ; test")
addCommandAlias("lci", "; clean ; compile ; fmt ; fmtc ; test ; dependencyUpdates")
