### Gaggle Testing project ###
Automation testing project to test Gaggle APIs.
Include automation to build the API as a Docker image.
Build and test automation in a CI job with GitHub Actions.

Repo: https://github.com/lvivasa/gaggle
Serenity
Rest Assured
Maven
Github CICD
Docker

## Getting Started
Project structure:
    src
        test
            java
                com.gaggle.sdetassesment
                    asserts
                    dtos
                    helpers
                    runners
                    stepsDefinitions
                    utils
            resources
                features

## Prerequisites ##
1. You need to install:
* [JDK 8](https://www.oracle.com/technetwork/java/javase/downloads/) - Java Development Kit

## How execute ##
Option 1: 
    mvn clean verify

Option 2: specific test
    mvn clean verify -Dcucumber.options="--tags @updateSchoolNotFound"

## Test Report ##
target\site\serenity\index.html
