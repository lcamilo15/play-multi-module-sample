name := """user"""

version := "1.0-SNAPSHOT"

lazy val common = (project in file("../common")).enablePlugins(PlayJava, PlayEbean)
lazy val user = (project in file(".")).enablePlugins(PlayJava, PlayEbean)
  .aggregate(common)
  .dependsOn(common)

scalaVersion := "2.11.6"

libraryDependencies ++= Common.commonDependencies ++: Seq(
  // Add here the specific dependencies for this module:
)


// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

unmanagedClasspath in Test <+= baseDirectory map { bd => Attributed.blank(bd / "conf") }
