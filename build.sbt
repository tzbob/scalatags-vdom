enablePlugins(ScalaJSPlugin)

name := "Scala.js Tutorial"

scalaVersion in ThisBuild := "2.11.8"

scalafmtConfig in ThisBuild := Some(file(".scalafmt"))

organization := "be.tzbob"
name := "scalatags-vdom"

scalacOptions ++= Seq(
  "-encoding",
  "UTF-8",
  "-target:jvm-1.6",
  "-feature",
  "-deprecation",
  "-Xlint",
  "-Yinline-warnings",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Xfuture",
  "-language:higherKinds",
  "-language:existentials"
)

libraryDependencies ++= Seq(
  "com.lihaoyi" %%% "scalatags" % "0.6.0"
)
