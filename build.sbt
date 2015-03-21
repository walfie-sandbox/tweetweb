name := """tweetweb"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  "com.github.tototoshi" %% "slick-joda-mapper" % "1.2.0",
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "org.postgresql" % "postgresql" % "9.3-1103-jdbc4"
)

