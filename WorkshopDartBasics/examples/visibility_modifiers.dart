class Sample {
  String _privateProperty = "I am private";

  void _privateMethod() {
    print("This is a private method");
  }
}

class BaseClass {
  String _protectedProperty = "Protected Property";
}

class ExtendedClass extends BaseClass {
  void useProtectedProperty() {
    print(_protectedProperty);
  }
}

void main() {
  Sample sample = Sample();
  sample._privateProperty = "Test";
}