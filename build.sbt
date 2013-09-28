scalaVersion := "2.10.2"

scalacOptions in ThisBuild ++=
  Seq("-feature", "-deprecation", "-Xlint")

libraryDependencies +=
  "com.chuusai" %% "shapeless" % "1.2.4"

libraryDependencies +=
  "org.scalatest" %% "scalatest" % "1.9.1" % "test"

// rillit uses macros, so it needs this
libraryDependencies +=
  "org.scala-lang" % "scala-reflect" % scalaVersion.value

libraryDependencies +=
  "fi.akisaarinen" %% "rillit" % "0.1.1-SNAPSHOT" from
    "http://cl.ly/2u3O1P0E3Z3G/rillit_2.10-0.1.1-SNAPSHOT.jar"
