name := "Neo4J-Scala-Examples"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies += "org.neo4j.driver" % "neo4j-java-driver" % "1.5.1"
libraryDependencies += "org.scala-lang.modules" %% "scala-java8-compat" % "0.8.0"
libraryDependencies += "org.neo4j.test" % "neo4j-harness" % "3.3.5" % Test
libraryDependencies += "org.neo4j" % "neo4j-bolt" % "3.3.5" % Test