package com.ftlt.tachyon.di.bootstrap

import com.ftlt.tachyon.di.domain.Person

object MainApp:

  @main def main =
    Registry.registry.personService.save(Person("name", "age", "location"))
