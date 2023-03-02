package com.knoldus.components

import akka.Done
import akka.stream.scaladsl.Sink

import scala.concurrent.Future

object Sinks {

  val ignoreSink: Sink[Any, Future[Done]] = Sink.ignore
  val sink: Sink[Any, Future[Done]] = Sink.foreach[Any](value => println(s"[Info] $value"))
  val headSink: Sink[Int, Future[Int]] = Sink.head[Int]
  val lastSink: Sink[Int, Future[Int]] = Sink.last[Int]
  val headOptionSink: Sink[Int, Future[Option[Int]]] = Sink.headOption[Int]
  val lastOptionSink: Sink[Int, Future[Option[Int]]] = Sink.lastOption[Int]
  val sumSink: Sink[Int, Future[Int]] = Sink.fold(0){
    case (sum, element) => sum + element
  }

}
