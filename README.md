# Multi-project Testing project ###
This is the root project of the Testing framework

## Getting Started
This is the base project of the testing framework, please read below to understand how to use it 
and how to add new modules.

Project structure:
service
    src
        test
            java
                dtos
                enums
                helpers
                runners
                stepsDefinitions
            resources
                features

## Prerequisites ##
1. You need to install:

* [JDK 8](https://www.oracle.com/technetwork/java/javase/downloads/) - Java Development Kit

2. Update your webdriver path in serenity.properties in web module.

## How execute ##

mvn clean install