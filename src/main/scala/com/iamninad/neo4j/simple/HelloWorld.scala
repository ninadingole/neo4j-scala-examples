package com.iamninad.neo4j.simple

import org.neo4j.driver.v1._

// Make sure you have your local neo4j running
class HelloWorld extends App {

  val driver           = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "admin@123"))
  val session: Session = driver.session()
  private val result: String = session.writeTransaction(new TransactionWork[String] {
    override def execute(tx: Transaction): String = {
      val result = tx.run("CREATE (a:Greeting {message='HelloWorld'}) RETURN a.message from node id(a)")
      result.single().get(0).asString()
    }
  })
  driver.close()
  println(result)
}
