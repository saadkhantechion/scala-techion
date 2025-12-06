package com.ftlt.basic.tachyon

object Calculator:

  def performCalc(operation: String, a: Int, b: Int) =
    operation match
      case "+"      => a + b
      case "-" => a - b
      case "*" => a * b
      case "/"   => a / b
      case _          => throw new IllegalArgumentException(s"Unknown operation: $operation")
