@api
Feature: Schools
  As a customer
  I want to validate School APIs

  @getAllSchools
  Scenario: Get all the schools in memory.
  This will return an array of schools objects.
    Given I want to get the schools in memory
    When I call the api
    Then I get the array of schools objects

  @getSpecificSchoolFound
  Scenario Outline: Get as specific school from memory using the id.
  The schools in memory have ids 0 through 10. You may use any integer you wish.
  If the id is not found, the application will throw a NotFoundException.
    Given I want to get the school ID <schoolId>
    When I call the api
    Then I can see the school information
      | schoolId   | schoolName   | studentCount   | emailAddress   |
      | <schoolId> | <schoolName> | <studentCount> | <emailAddress> |

    Examples:
      | schoolId | schoolName | studentCount | emailAddress           |
      | 2        | Franklin   | 1250         | principal@franklin.edu |

  @getSpecificSchoolNotFound
  Scenario: Get as specific school from memory - id not found.
  The schools in memory have ids 0 through 10. You may use any integer you wish.
  If the id is not found, the application will throw a NotFoundException.
    Given I want to get the school ID 10
    When I call the api
    Then The status code is 500
    And The error message is Internal Server Error

  @createSchool
  Scenario Outline: Add a school to memory.
  It will add the new school with the id you give in the object.
  Submit the school object in the body of the PUT.
    Given I want to add a school with the following information
      | schoolId   | schoolName   | studentCount   | emailAddress   |
      | <schoolId> | <schoolName> | <studentCount> | <emailAddress> |
    When I call the api
    Then The school is created
    And The information is correct

    Examples:
      | schoolId | schoolName | studentCount | emailAddress      |
      | 12       | Miami Dade | 3490         | principal@mds.edu |

  @updateSchoolFound
  Scenario Outline: Update a specific school in memory.
  The schools in memory have ids 0 through 10.
  Submit the school object in the body of the POST.
  If the id is not found, the application will throw a NotFoundException.
    Given I want to update the school Id <schoolId> with the following information
      | schoolId   | schoolName   | studentCount   | emailAddress   |
      | <schoolId> | <schoolName> | <studentCount> | <emailAddress> |
    When I call the api
    Then The school is updated
    And The information is correct

    Examples:
      | schoolId | schoolName | studentCount | emailAddress      |
      | 12       | Miami Dade | 2000         | principal@mds.edu |

  @updateSchoolNotFound
  Scenario Outline: Update a specific school in memory - Id not found
  The schools in memory have ids 0 through 10.
  Submit the school object in the body of the POST.
  If the id is not found, the application will throw a NotFoundException.
    Given I want to update the school Id <schoolId> with the following information
      | schoolId   | schoolName   | studentCount   | emailAddress   |
      | <schoolId> | <schoolName> | <studentCount> | <emailAddress> |
    When I call the api
    Then The status code is 500
    And The error message is Internal Server Error

    Examples:
      | schoolId | schoolName | studentCount | emailAddress      |
      | 13       | Miami Dade | 2000         | principal@mds.edu |