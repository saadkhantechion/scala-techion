package com.ftlt.tachyon.di.services

import com.ftlt.tachyon.di.domain.Person

trait PersonService:

  def save(person: Person): Unit
