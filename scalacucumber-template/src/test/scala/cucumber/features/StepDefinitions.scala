package cucumber.features

import com.ftlt.basic.tachyon.Calculator
import io.cucumber.scala.{EN, ScalaDsl, Scenario}

import scala.compiletime.uninitialized

class StepDefinitions extends ScalaDsl with EN:

  var operandOne: Int = uninitialized
  var operandTwo: Int = uninitialized
  var operation: String = uninitialized
  var result: Int = uninitialized

  Before { (scenario: Scenario) =>
    println("Before Scenario : "+scenario.getName)
  }

  After { (scenario: Scenario) =>
    println("After Scenario : " + scenario.getName)
  }

  BeforeStep { (step: Scenario) =>
    println(s"Before Step : ${step}")
  }

  AfterStep { (step: Scenario) =>
    println(s"After Step : ${step}")
  }

  Given("operand one {int}") { (_operandOne: Int) =>
    operandOne = _operandOne
  }

  Given("operand two {int}") { (_operandTwo: Int) =>
    operandTwo = _operandTwo
  }

  Given("operation {string}") { (_operation: String) =>
    operation = _operation
  }

  When("calculation is performed") { () =>
    result = Calculator.performCalc(operation, operandOne, operandTwo)
  }

  Then("result is {int}") { (_result: Int) =>
    assert(result == _result)
  }
