class MyClass {
  String _privateProperty = 'I am private';

  void _privateMethod() {
    print('This is a private method.');
  }
}


class MyBaseClass {
  String _protectedProperty = 'I am "protected" (not enforced)';
}

class MyDerivedClass extends MyBaseClass {
  void useProtectedProperty() {
    print(_protectedProperty);  // This will work, even though it's not enforced protection.
  }
}

class MyClassPublic {
  String publicProperty = 'I am public';

  void publicMethod() {
    print('This is a public method.');
  }
}

void main() {
  MyClass myClass = MyClass();
  myClass._privateMethod();
}
