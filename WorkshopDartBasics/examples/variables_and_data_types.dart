import 'dart:collection';

void main() {
  String name = "Shesha";
  int age = 20;
  double height = 5.8;
  bool isStudent = false;

  List<String> studentNames = ['Mobile', 'Dev', 'Workshop'];
  List<String> students = [];
  students.add("Mobile");
  students.add("Dev");

  Map<int, String> fruits = {
    1: "Banana",
    2: "Apple"
  };

  LinkedHashMap<int, String> orderedMap = LinkedHashMap();
  orderedMap[1] = 'Banana';
  orderedMap[2] = 'Apple';

  print(addNumbers(5, 6));
}

int addNumbers(int a, int b) {
  return a +b;
}