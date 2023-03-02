package com.knoldus

import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, ActorMaterializerSettings}
import com.knoldus.components.Sinks._
import com.knoldus.components.Flows._
import com.knoldus.components.Sources._
import com.knoldus.faultTolerance.Recover._
import com.knoldus.faultTolerance.{CustomSupervision, Recover}

object Application extends App {

  val customSupervision = new CustomSupervision
  implicit val actorSystem = ActorSystem("Akka-Stream")
  implicit val materializer = ActorMaterializer(ActorMaterializerSettings(actorSystem) withSupervisionStrategy(customSupervision.myCustomSupervisor))

  singleSource.via(toUpperFlow).to(sink).run()
  wholeNumberSource.via(divide).to(sink).run()
  repeatSource.to(ignoreSink)
  repeatSource.to(sink).run()

}
