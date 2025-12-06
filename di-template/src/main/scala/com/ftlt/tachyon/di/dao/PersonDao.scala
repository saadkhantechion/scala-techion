package com.ftlt.tachyon.di.dao

import com.ftlt.tachyon.di.domain.Person

trait PersonDao:

  def save(person: Person): Unit
