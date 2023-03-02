package com.knoldus.faultTolerance

import akka.stream.scaladsl.Flow

object Recover {

  val recoverWithZero = Flow[Int].recover{
    case _ : ArithmeticException => println("Divider should not be zero")
    case _                       => println("Everything is Fine")
  }

}
