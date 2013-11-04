scalaVersion := "2.10.3"

scalacOptions in ThisBuild ++=
  Seq("-feature", "-deprecation", "-Xlint")

libraryDependencies +=
  "com.chuusai" %% "shapeless" % "1.2.4"

libraryDependencies +=
  "org.scalatest" %% "scalatest" % "2.0" % "test"

// shouldn't be necessary just because rillit uses macros, but currently
// is needed anyway. hopefully not in a future rillit
libraryDependencies +=
  "org.scala-lang" % "scala-reflect" % scalaVersion.value

libraryDependencies +=
  "fi.akisaarinen" %% "rillit" % "0.1.1-SNAPSHOT" from
    "http://cl.ly/2u3O1P0E3Z3G/rillit_2.10-0.1.1-SNAPSHOT.jar"
