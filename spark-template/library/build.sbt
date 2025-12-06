
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "4.0.1",
  "org.apache.spark" %% "spark-sql"  % "4.0.1",
  // add more if needed, e.g. structured streaming, hive, etc.
  // "org.apache.spark" %% "spark-streaming" % "4.0.1" % "provided"

  // IMPORTANT: Scala reflection for Scala 2.13
  "org.scala-lang"    % "scala-reflect" % scalaVersion.value
)


assemblyJarName in assembly := "library.jar"
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}