class Person {
  String name;
  int age;

  // Constructor
  Person(this.name, this.age);

  // Method
  void greet() {
    print('Hello, my name is $name and I am $age years old.');
  }
}

void main() {
  // Creating objects from the class
  Person person1 = Person('Alice', 25);
  Person person2 = Person('Bob', 30);

  // Accessing object properties
  print('${person1.name} is ${person1.age} years old.');
  print('${person2.name} is ${person2.age} years old.');

  // Calling object methods
  person1.greet();
  person2.greet();
}
