# Scala Cucumber Tachyon

This is a starter template for scala cucumber and the scoverage sbt plugin.

You can run the examle as 
```shell
sbt testc
```

## The required depedencies
The scala cucumber is setup to run with junit with the following dependencies
```sbt
"io.cucumber" %% "cucumber-scala"  % "8.20.0" % Test,
"io.cucumber"  % "cucumber-junit"  % "7.15.0" % Test,
"com.novocode" % "junit-interface" % "0.11"   % Test,
```

## The test runner
We can configure the runner as follows.
```scala
import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(plugin = Array("pretty", "html:target/cucumber.html"))
class CucumberTestRunner {}
```
* We configure the runner to run via junit runner.
* Use the `@CucumberOptions` to configure the cucumber settings.

## Step Definitions

```scala
package cucumber.features

import com.ftlt.basic.tachyon.Calculator
import io.cucumber.scala.{EN, ScalaDsl, Scenario}

class StepDefinitions extends ScalaDsl with EN:

  //Define the state vars as needed
  //var operandOne: Int ...  
  
  //Step definitions that bind to steps in feature file.
  Given("operand one {int}") { (_operandOne: Int) =>
    operandOne = _operandOne
  }

  When("calculation is performed") { () =>
    result = Calculator.performCalc(operation, operandOne, operandTwo)
  }

  Then("result is {int}") { (_result: Int) =>
    assert(result == _result)
  }
```

* StepDefinitions is where we define our state
* Here is where we also define the step code that is executed.
* We can also define scenario and step hooks, see the code example.
* We can also define global hooks, see the code example.
* For the step definition syntax see the cucmber scala doc in reference below.

# References
* [Cucumber Scala Tachyon](https://github.com/FasterThanLightTech/scala-tachyons/tree/scala-cucumber)
* [cucumber-jvm-scala/docs](https://github.com/cucumber/cucumber-jvm-scala/tree/main/docs) in github
* [Cucumber-Scala](https://cucumber.io/docs/installation/scala/)