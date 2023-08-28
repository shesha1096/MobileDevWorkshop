import 'package:flutter/material.dart';
import 'screen3.dart';

class Screen2 extends StatelessWidget {
  const Screen2({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Screen 2')),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => Screen3(data: 'Hello from Screen 2!'),
              ),
            );
          },
          child: const Text('Go to Screen 3'),
        ),
      ),
    );
  }
}
