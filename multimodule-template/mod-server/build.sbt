libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic"     % Versions.logback,
  "org.http4s"    %% "http4s-ember-server" % Versions.http4s
)

enablePlugins(JavaAppPackaging)
