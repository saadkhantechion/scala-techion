# Dependency Injection Template

In this article we will take a look at how to implement simple dependency injection in scala.
* We want an approach the externalize the management of dependencies. 
* We want to code to interfaces so we can have the dependencies be loosely coupled.
* We want to use the same approach for testing and have the flexibility to mock/stub particular instances. Without having
to write a whole bunch of code for test setup.

To accomplish this goal we will use `traits` and `lazy vals`
* We will use trait to define the contracts.
* We will use traits for implementation also.
* We will use lazy vals in trait to declare the dependencies.
* Lazy vals within traits will allow us to delay the initialization of dependencies.
* We will create a registry to compose all of this together using traits and lazy vals.

## How do traits and lazy vals work
Here we have `SomeTrait` that has a dependency on variable of type Map.  The dependency is not initialized and it can be 
used in the code.
```scala
trait SomeTrait :
  lazy val someDependency:Map[String,String]
  def someMethod(arg1:String) : String = arg1 + "=" + someDependency.getOrElse(arg1,"Default")
```
Here we create an instance of `SomeTrait` and initialize the dependency with some concrete type for production code.
```scala
new SomeTrait{
  override lazy val someDependency:Map[String,String] = HashMap()
}
```
And in our test code we can initialize it with some mock instance
```scala
new SomeTrait {
  override lazy val someDependency:Map[String,String] = Mockito.mock(classOf[Map[String,String]])
}
```
Where ever this SomeTrait is used and injected it will have the mock map.

## Simple dependency injection real example
* The `PersonServiceDefault` is an implementation but it is defined as a trait.
* It has two dependencies `PersonRestClient` and `PersonDao`.  
* These are declared but not initialized and will be initialized when we create an instance of `PersonServiceDefault`  


```scala
trait PersonServiceDefault extends PersonService:
  lazy val personRestClient: PersonRestClient
  lazy val personDao: PersonDao
  override def save(person: Person): Unit =
    if personRestClient.isReal(person) then personDao.save(person)
```

to compose all these dependencies together we will use a Registry and RegistryDefault which itself is a trait and uses lazy vals.

The dependencies are injected when `PersonServiceDefault` is initialized in `RegistryDefault`
```scala
trait RegistryDefault extends Registry:
  self =>
  override lazy val personRestClient: PersonRestClient = new PersonRestClientDefault {} 
  override lazy val personDao: PersonDao = new PersonDaoJdbc {}
  override lazy val personService: PersonService = new PersonServiceDefault:
    override lazy val personRestClient: PersonRestClient = self.personRestClient //injecting the dependency
    override lazy val personDao: PersonDao               = self.personDao //injecting the dependency
```

in production code we will simply create an instance of the RegistryDefault and use the traits within it.
```scala
val registry = new RegistryDefault{}
registry.personService.save(...)
```

We can now see the benefit of this in the test class, where we instantiate `RegsitryDefault` and override the traits we need to mock/stub
```scala
val testRegistry = new RegistryDefault:
  override lazy val personRestClient: PersonRestClient = new PersonRestClientStub {} //Mocking the person rest client
```
Here we only override the PersonRestClient and the stub will get injected within PersonServiceDefault because lazy val delays the initialization.
So now in the test when we call `personService.save(...)` it delegate to the person client rest stub.

Please see code for details.
