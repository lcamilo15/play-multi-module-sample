name := """multi-module-sample-project"""

version := "1.0-SNAPSHOT"

lazy val admin = (project in file("module/admin")).enablePlugins(PlayJava)
lazy val user = (project in file("module/user")).enablePlugins(PlayJava)
lazy val root = (project in file(".")).enablePlugins(PlayJava)
  .aggregate(admin, user)
  .dependsOn(admin, user)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
