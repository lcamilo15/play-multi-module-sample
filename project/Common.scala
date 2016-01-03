import sbt._
import Keys._
import play.sbt.PlayImport._
import play.sbt.routes.RoutesKeys.routesGenerator
import play.routes.compiler.InjectedRoutesGenerator
import com.typesafe.sbt.web.SbtWeb.autoImport.{Assets, pipelineStages}
import com.typesafe.sbt.less.Import.LessKeys
import com.typesafe.sbt.rjs.Import.{rjs, RjsKeys}
import com.typesafe.sbt.digest.Import.digest
import com.typesafe.config._

object Common {
  // Common settings for every project
  def settings(theName: String) = Seq(
    name := theName,
    organization := "com.myweb",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.11.7",
    routesGenerator := InjectedRoutesGenerator,
    doc in Compile <<= target.map(_ / "none"),
    scalacOptions ++= Seq("-feature", "-deprecation", "-unchecked", "-language:reflectiveCalls"),
    resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
  )

  /*
  * Utilities to replicate shared.*.conf files
  */

  lazy val sharedConfFilesReplicator = taskKey[Seq[File]]("Replicate shared.*.conf files.")

  def sharedConfFilesReplicate(rootDir: File, managedDir: File, log: Logger): Seq[File] = {
    val files = ((rootDir / "conf") ** "shared.*.conf").get
    val destinationDir = managedDir / "conf"
    destinationDir.mkdirs()
    files.map { file =>
      val destinationFile = destinationDir / file.getName()
      IO.copyFile(file, destinationFile)
      file
    }
  }

  // Settings for every module, i.e. for every subproject
  def moduleSettings(module: String) = settings(module) ++: Seq(
    javaOptions += s"-Dconfig.resource=$module-dev.conf",
    sharedConfFilesReplicator in Compile := sharedConfFilesReplicate(baseDirectory.value / ".." / "..", resourceManaged.value, streams.value.log),
    resourceGenerators in Compile <+= (sharedConfFilesReplicator in Compile)
  )

  val commonDependencies = Seq(
    javaJdbc,
    cache,
    javaWs,
    "junit" % "junit" % "4.10",
    "org.webjars" % "jquery" % "2.1.4",
    "org.webjars" % "bootstrap" % "3.3.5" exclude("org.webjars", "jquery"),
    "org.webjars" % "requirejs" % "2.1.19"
    // Add here more common dependencies:
    // jdbc,
    // anorm,
    // ...
  )
}
