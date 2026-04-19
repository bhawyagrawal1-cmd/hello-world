# Hello World

Java practice assignments for B1P18-R1-SEM2-2025-2029.

## Assignment Links

Main repository link:

https://github.com/bhawyagrawal1-cmd/hello-world

UC1: Display "Hello World"

https://github.com/bhawyagrawal1-cmd/hello-world/tree/main

UC2: Display "Hello" with Command-Line Argument

https://github.com/bhawyagrawal1-cmd/hello-world/tree/feature/UC2-display-name

UC3: Display "Hello" with Command-Line Argument or Default Message

https://github.com/bhawyagrawal1-cmd/hello-world/tree/feature/UC3-display-name-default

UC4: Display "Hello" with Multiple Command-Line Arguments or Default Message

https://github.com/bhawyagrawal1-cmd/hello-world/tree/feature/UC4-display-multiple-names

UC5: Display "Hello" with Multiple Command-Line Arguments using Enhanced For Loop or Default Message

https://github.com/bhawyagrawal1-cmd/hello-world/tree/feature/UC5-enhanced-for-loop

UC6: Display "Hello" with Multiple Command-Line Arguments using substring to Remove Trailing Delimiter

https://github.com/bhawyagrawal1-cmd/hello-world/tree/feature/UC6-substring-method

UC7: Display "Hello" with Multiple Command-Line Arguments using String.join() Method or Default Message

https://github.com/bhawyagrawal1-cmd/hello-world/tree/feature/UC7-string-join

## Practice Programs

Week 1 Level 1 Practice Programs

https://github.com/bhawyagrawal1-cmd/hello-world/blob/main/src/main/java/practice/week1/Week1Level1Programs.java

Array Level 1 Practice Programs

https://github.com/bhawyagrawal1-cmd/hello-world/blob/main/src/main/java/practice/arrays/level1/ArrayLevel1Programs.java

Array Level 2 Practice Programs

https://github.com/bhawyagrawal1-cmd/hello-world/blob/main/src/main/java/practice/arrays/level2/ArrayLevel2Programs.java

Array Level 3 Practice Programs

https://github.com/bhawyagrawal1-cmd/hello-world/blob/main/src/main/java/practice/arrays/level3/ArrayLevel3Programs.java

## Run

```powershell
javac -d target/classes src/main/java/HelloApp.java
java -cp target/classes HelloApp
```

Compile all practice programs:

```powershell
$files = Get-ChildItem -Path src/main/java -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac -d target/classes $files
```
