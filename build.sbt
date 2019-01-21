inThisBuild(
  Seq(
    organization := "com.iterable",
    licenses := Seq("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.html")),
    homepage := Some(url("https://github.com/Iterable/guava-bursty-rate-limiter")),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/Iterable/guava-bursty-rate-limiter"),
        "scm:git@github.com:Iterable/guava-bursty-rate-limiter.git"
      )
    ),
    developers := List(
      Developer(
        "gmethvin",
        "Greg Methvin",
        "greg@methvin.net",
        new URL("https://github.com/gmethvin")
      )
    )
  )
)

lazy val root = (project in file("."))
  .settings(
    name := "guava-bursty-rate-limiter",
    crossPaths := false,
    autoScalaLibrary := false,
    libraryDependencies += "com.google.guava" % "guava" % "19.0"
  )

scalafmtOnCompile in ThisBuild := true

publishMavenStyle in ThisBuild := true
publishTo in ThisBuild := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)

import sbtrelease.ReleasePlugin.autoImport.ReleaseTransformations._

releaseCrossBuild := false
releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  releaseStepCommand("publishSigned"),
  setNextVersion,
  commitNextVersion,
  releaseStepCommand("sonatypeReleaseAll"),
  pushChanges
)
