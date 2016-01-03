name := """multi-module-sample-project"""

version := "1.0-SNAPSHOT"

lazy val admin = (project in file("module/admin")).enablePlugins(PlayJava, PlayEbean)
lazy val user = (project in file("module/user")).enablePlugins(PlayJava, PlayEbean)
lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)
  .aggregate(admin, user)
  .dependsOn(admin, user)

scalaVersion := "2.11.6"

libraryDependencies ++= Common.commonDependencies

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
