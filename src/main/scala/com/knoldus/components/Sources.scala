package com.knoldus.components

import akka.NotUsed
import akka.stream.scaladsl.Source

import scala.concurrent.duration.DurationInt

object Sources {

  val wholeNumberSource: Source[Int, NotUsed] = Source(0 to 10)
  val iteratorSource = Source.fromIterator{
    () => Iterator.from(0, 1)
  }
  val cycleSource = Source.cycle{
    () => Iterator.range(1, 10)
  }
  val emptySource = Source.empty[String]
  val singleSource = Source.single("I am single with no repetition !!!")
  val repeatSource = Source.repeat("Repeat me ...")
  val delaySource = Source.tick( initialDelay = 1 second,
                                 interval = 2 second,
                                 tick = "Wait for Delay")

}
