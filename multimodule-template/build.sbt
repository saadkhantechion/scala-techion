//Global settings for all modules
scalaVersion in Global := "3.3.1"
organization in Global := "com.ftlt.tachyons"

//Scalafix setup
semanticdbEnabled in Global := true

//Sbt aliases
addCommandAlias("fmt", ";scalafmtAll;scalafmtSbt;scalafixAll")
addCommandAlias("fmtc", ";scalafmtCheckAll;scalafmtSbtCheck;scalafixAll --check")

lazy val core   = project.in(file("mod-core"))
lazy val client = project.in(file("mod-client"))
lazy val server = project.in(file("mod-server")).dependsOn(core)

lazy val root = project
  .in(file("."))
  .aggregate(client, core, server)
