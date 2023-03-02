package com.knoldus.components

import akka.NotUsed
import akka.stream.OverflowStrategy
import akka.stream.scaladsl.Flow

import scala.collection.immutable
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration.DurationInt

object Flows {

  val toUpperFlow: Flow[String, String, NotUsed] = Flow[String].map(_.toUpperCase)
  val divide = Flow[Int].map(10 / _)
  val slidingFlow: Flow[Int, immutable.Seq[Int], NotUsed] = Flow[Int].sliding(10, 2)
  val filterFlow: Flow[Int, Int, NotUsed] = Flow[Int].filter(_ % 5 == 0)
  val takeWithinFlow: Flow[Int, Int, NotUsed] = Flow[Int].takeWithin(1 second)
  val groupWithinFlow: Flow[String, immutable.Seq[String], NotUsed] = Flow[String].groupedWithin(10, 2 second)
  val dropWithinFlow: Flow[Int, Int, NotUsed] = Flow[Int].dropWithin(1 second)
  val asyncFlow: Flow[Int, Int, NotUsed] = Flow[Int].mapAsyncUnordered(2)(value => Future(value * 2))
  val bufferFlow: Flow[String, String, NotUsed] = Flow[String].buffer(5, OverflowStrategy.fail)

}
