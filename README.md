# Introduction to Java 8 - Lambdas, Streams and Other Cool Stuff

After completing Oracle's JDK8 MOOC in December, I decided to run a 'Brown Bag' (basically a knowledge-sharing lunch time talk/presentation we run in my team) on an introduction to Java8 because we as a team wrote Java programs using JDK7.

This repository contains the code I used during the talk. 
I've also added the slides used (this is not content heavy, I used it mainly to help me keep track of what points I wanted to talk about or demonstrate via code)

You need at least At least JDK8 to compile the code. This can be found on Oracle's website.

The project is [Gradle](https://gradle.org/getting-started/using-a-build) bootstrapped, and I also only added Eclipse plugin to the build file.

So to set up project in eclipse simple import project to eclipse and configure your build path by adding *'src/main/java'* and *'src/test/groovy'* as your **only** source folders.

To build and add dependencies to eclipse, simply open a terminal or command prompt windoe, change directory to the project root directory and..
*	for *nix OS run the command - ./gradlew clean build
* 	for Windows OS run the command - gradlew.bat clean build
