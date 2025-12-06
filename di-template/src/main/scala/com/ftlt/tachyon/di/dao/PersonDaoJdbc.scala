package com.ftlt.tachyon.di.dao

import com.ftlt.tachyon.di.domain.Person

trait PersonDaoJdbc extends PersonDao:

  override def save(person: Person): Unit =
    println(s"Person saved to JDBC DB: $person")
