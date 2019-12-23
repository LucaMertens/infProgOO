Question 1
---
```java
int n1 = readInt("Enter n1: ");
```
* **Type**:   integer (whole numbers)
* **Name**:   n1
* **Value**:  The integer returned by the method `readInt` (with the argument: `"Enter n1: "`).
This will be the number the user enters after being prompted "Enter n1".
<hr>

```java
int n2 = readInt("Enter n2: ");
```
* **Type**: integer
* **Name**: n2
* **Value**: The integer returned by the method `readInt` (argument: `"Enter n2: "`).
The number the user enters after being prompted "Enter n2".
<hr>
```java
int n3 = readInt("Enter n3: ");
```
* **Type**: integer
* **Name**: n3
* **Value**: The integer returned by the method `readInt` (argument:  `"Enter n3: "`).
The number the user enters after being prompted "Enter n3".
<hr>
```java
int total = n1 + n2 + n3;
```
* **Type**: Integer
* **Name**: total
* **Value**: The sum of n1, n2, n3
<hr>

Question 2
---
**ConsoleProgram** is a subclass of **acm.Program**. It is also the superclass of **Add3Integers**.  
Therefore, **Add3Integers** is a subclass of both **ConsoleProgram** and **Program**.    
The hierarchy can also be illustrated like this (Superclass --> Subclass):  
**acm.Program** --> **ConsoleProgram** --> **Add3Integers**