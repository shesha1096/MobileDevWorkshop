class Person {
  String name;
  int age;

  Person(this.age, this.name);

  void greet() {
    print('Hello, my name is $name, and m age is $age');
  }
}

void main () {
  Person person = Person(27, 'Shesha');
  person.greet();
}