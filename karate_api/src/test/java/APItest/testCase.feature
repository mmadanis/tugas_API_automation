Feature: Test Case

  Background:
    Given url "https://petstore.swagger.io/"
    And print "--try open petstore API--"

  Scenario:
    When url "https://petstore.swagger.io/v2/user/login"
    When method get
    Then print response
    And status 200
