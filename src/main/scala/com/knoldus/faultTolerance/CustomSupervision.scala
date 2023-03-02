package com.knoldus.faultTolerance

import akka.stream.Supervision

class CustomSupervision {

  def myCustomSupervisor : Supervision.Decider = {
    case _ : ArithmeticException   => Supervision.Resume
    case _ : NullPointerException  => Supervision.Restart
    case _                         => Supervision.Stop
  }

}
