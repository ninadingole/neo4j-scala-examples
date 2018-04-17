package com.iamninad.neo4j.async

import java.util.concurrent.CompletionStage

import org.neo4j.driver.v1._

import scala.compat.java8.FutureConverters._

object AsyncSelectQuery extends App {
  import scala.concurrent.ExecutionContext.Implicits.global

  val driver           = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "root"))
  val session: Session = driver.session()
  private val csStage: CompletionStage[StatementResultCursor] =
    session.runAsync("MATCH (tom {name: \"Tom Hanks\"}) RETURN properties(tom) as tom")
  csStage.toScala
    .flatMap(x => x.nextAsync().toScala)
    .map(record => record.asMap())
    .onComplete { p =>
      p.foreach(println)
      session.closeAsync()
    }
  driver.close()
}
