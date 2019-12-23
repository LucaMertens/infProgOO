## this

Refers to the curret object of a class, hence it cannot be use in a static environment.

_Example:_

```java

// Constructor
ExampleClass(String wübbel) {
	// Left side: instance-variable, right side: local var.
	this.wübbel = wübbel;
}
```

## static

Declares a variable / method as beeing a class variable / method.  
_Example:_

```java
// Class variable, accessible with <Classname>.PI
static final double PI = 3.14;
```

## null

Null is a special value that can be interpreted as "empty" / "no object".
Every object-variable can assume `null` as their value,
as opposed to primitive-type-vars, which must have a value of said type.

_Example:_

```java
SomeClass test = new SomeClass();
// If the method exists, this would be possible.
test.someMethod();

// The type of test will remain SomeClass,
// but the variable will now point to null.
test = null;
// Error, because test is now "nothing".
test.someMethod();
```

## Instance variable / class variable

Both sorts of variables are declared within a class, but outside of its methods.

An **instance variable** is created with every object of a class.
A **class variable** is saved only once per class.

_Example:_

```java
// Class variable, accessible via <Classname>.PI
static final double PI = 4;
// Instance var, accessible via <Objectname>.state
double state = 1337;
```

## Constructor

A function that is executed when creating an instance of a class.
By default just calls the superclasses' constructor.

_Example:_

```java
class  SomeClass  {
	// Instance var.
	private  int someInt;

	// Constructors with different param-types are possible.
	SomeClass()  {
		// Call the other constructor with a default value.
		this(0);
	}

	SomeClass(int  someInt)  {
		// Initialize instance vars with actual parameters.
		this.someInt  = someInt;
	}
}
```

## Access modifiers

**private**

The variable / method only visible inside the current class.

```java
// Accessing hildegard from another class,
// even a subclass, is not possible.
private double hildegard;
```

**Default (no modifier):**

- only visible to classes in the current package.

```java
double günther;
```

**protected**

- only visible inside the same package **and** all subclasses of the current class.

```java
// bartholomeus is also visible in all subclasses
// of the class he was defined in.
protected double bartholomeus;
```

**public**

- visible from every class.

```java
// Usefull for variables that you want to expose to the user.
public double dieter;
```
