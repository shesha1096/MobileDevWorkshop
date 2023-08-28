import 'dart:collection';

void main() {
  // Creating a map
  Map<String, int> ages = {
    'Alice': 25,
    'Bob': 30,
    'Carol': 28,
  };

  // Accessing values
  print('Alice\'s age: ${ages['Alice']}');

  // Adding a new key-value pair
  ages['David'] = 22;

  // Iterating through the map
  for (var entry in ages.entries) {
    print('${entry.key}: ${entry.value}');
  }

  // Creating a HashMap
  HashMap<String, double> prices = HashMap();

  // Adding key-value pairs
  prices['Apple'] = 1.5;
  prices['Banana'] = 0.75;

  // Accessing values
  print('Price of Apple: ${prices['Apple']}');

  // Creating a LinkedHashMap
  LinkedHashMap<String, String> capitals = LinkedHashMap();

  // Adding key-value pairs
  capitals['USA'] = 'Washington, D.C.';
  capitals['France'] = 'Paris';
  capitals['Japan'] = 'Tokyo';

  // Iterating through the map (in insertion order)
  for (var entry in capitals.entries) {
    print('${entry.key}: ${entry.value}');
  }

  // Creating a SplayTreeMap
  SplayTreeMap<int, String> ranks = SplayTreeMap();

  // Adding key-value pairs
  ranks[3] = 'Bronze';
  ranks[1] = 'Gold';
  ranks[2] = 'Silver';

  // Iterating through the map (sorted keys)
  for (var entry in ranks.entries) {
    print('${entry.key}: ${entry.value}');
  }
}
