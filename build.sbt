scalaVersion := "2.10.2"

scalacOptions in ThisBuild ++=
  Seq("-feature", "-deprecation", "-Xlint")

libraryDependencies +=
  "com.chuusai" %% "shapeless" % "1.2.4"

libraryDependencies +=
  "org.scalatest" %% "scalatest" % "1.9.1" % "test"
