scalaVersion := "2.10.0"

scalacOptions in ThisBuild ++=
  Seq("-feature", "-deprecation", "-Xlint")

libraryDependencies +=
  "com.chuusai" %% "shapeless" % "1.2.3"

libraryDependencies +=
  "org.scalatest" %% "scalatest" % "1.9.1" % "test"
