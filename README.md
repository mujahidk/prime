Prime Finder application instructions
=====================================

#### Prerequisites
- Java Development Kit 1.8

Building console application
----------------------------
_Require Internet connection to load project dependencies._

1. Go to project root directory
2. Run `./gradlew jar`

The above steps will build the application and places the compiled `prime.jar` in `build/libs/` directory.

### Running the application from command line.
After building jar, you can run the application from project root directory with the following command.
```
java -jar build/libs/prime.jar <Prime Search Limit> [Threads]
```
_When thread value is not provided or less than 1, the program executes in main thread._

### Running sample from gradle.
You can directly run the application from the gradle build with defaults(_100 and 5_) set in `build.gradle` file. Run the following command in project root directory.
```
./gradlew run
```

Building web application
------------------------
1. Go to project root directory
2. Run `./gradlew war`

The above steps will create a web application archive `prime.war` inside `build/libs/` directory.

### Running web application.
Using `jetty` gradle plugin which adds embedded container to build process, the web application can be verified. To run the embedded Jetty web container, run the following command in project root directory.
```
./gradlew jettyRunWar
```
_This command starts a webserver using port **8080**. If port 8080 is already in use, please change the port number in `build.gradle` file._

Once the web container is running, you can access the site using following [http://localhost:8080/prime/](http://localhost:8080/prime/) url.

_Require Internet connection to load Bootstrap files through CDN_

Viewing and modifying source code.
----------------------------------
To view and edit code in Eclipse or IntelliJ you can run the below commands in the project root directory.

For Eclipse:
```
./gradlew eclipse
```
_This command will generate Eclipse `.project` and `.classpath` files._

For IntelliJ Idea
```
./gradlew idea
```
_This command will generate IntelliJ Idea project files._

### Viewing additional Gradle tasks.
To view all the Gradle tasks available in the build, run the following commands.
```
./gradlew tasks
```

### Java 8 feature usage
1. Java 8 lambda expression and `IntStream` is used in `com.mujahidk.prime.module.SlowPrimeFinder`.
2. Java 8 lambda expression is used in `com.mujahidk.prime.strategy.MultiThreadConsoleHandler`.

### Other technical details
1. For build, Gradle 2.14.1 is used.
2. There are few JUnit test cases.
3. Basic use of Bootstrap.
