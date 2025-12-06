package com.ftlt.basic.tachyon

class SampleCode2:

  def someMethod(): Either[Nothing, Int] =
    for
      one <- Right(1)
      two <- Right(3)
    yield one + two

  def someMethod2() = {}
