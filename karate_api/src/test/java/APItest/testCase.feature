Feature: Test Case

  Background:
    Given url "https://petstore.swagger.io/"
    And print "--try open petstore API--"

  Scenario: Login
    When url "https://petstore.swagger.io/v2/user/login"
    When method get
    And request {"username": "sdwreadd","password": "random"}
    Then print response
    And status 200

  Scenario: Create User
    * def reqBody = { 'id': '0','username': 'sdwreadd' }
    When url "https://petstore.swagger.io/v2/user"
    And request reqBody
    And method post
    Then print response
    And status 200

  Scenario: Delete User
    * def reqHeader = { 'Content-Type': 'application/json' }
    * def reqBody = { 'id': '0','username': 'sdwreadd' }
    When url "https://petstore.swagger.io/v2/user/adasdhaksjdhsakd"
    And method delete
    Then print response
    And status 404






