//Basic Setup
scalaVersion := "3.7.1"
name         := "scalacucumber-template"
organization := "org.techion.templates"

//Scalafix setup
semanticdbEnabled := true

libraryDependencies += compilerPlugin("com.github.ghik" %% "zerowaste" % "1.0.0" cross CrossVersion.full)

//Dependencies Setup
libraryDependencies ++= Seq(
  "io.cucumber" %% "cucumber-scala"  % "8.20.0" % Test,
  "io.cucumber"  % "cucumber-junit"  % "7.15.0" % Test,
  "com.novocode" % "junit-interface" % "0.11"   % Test,
  "org.mockito"  % "mockito-core"    % "4.3.1"
)

//Sbt aliases
addCommandAlias("fmt", "; scalafmtAll ; scalafmtSbt ; scalafixAll")
addCommandAlias("fmtc", "; scalafmtCheckAll ; scalafmtSbtCheck ; scalafixAll --check")
addCommandAlias("testc", "; coverage ; test ; coverageReport")
addCommandAlias("ci", "; fmtc ; testc")
addCommandAlias("lci", "; fmt ; ci")
