Feature: Test online calculator scenarios

  Scenario: Verify that at first launch, the number default is 0
    Given The calculator is ready to use
    Then the result should be 0 on the screen

#  Scenario Outline: Verify that all number is working functionality
#    Given The calculator is ready to use
#    When I have entered <Number> into the calculator
#    Then the result should be <Number> on the screen
#    Examples:
#      | Number |
#      | 1      |
#      | 2      |
#      | 3      |
#      | 4      |
#      | 5      |
#      | 6      |
#      | 7      |
#      | 8      |
#      | 9      |
#      | 0      |
#
#  Scenario Outline: Verify that the operation is working normally
#    Given The calculator is ready to use
#    When I have entered <First> into the calculator
#    And I press <Function>
#    And I have entered <Second> into the calculator
#    And I press =
#    Then the result should be <Result> on the screen
#    Examples:
#      | First | Function | Second | Result     |
#      | 50.5    | +        | 120    | 170.5        |
#      | -30    | *        | 70     | -2100       |
#      | 60    | /        | 90     | 0.66666667 |
#      | 650   | -        | 20     | 630        |
#      | 11110 | /        | 0      | Error      |
#
#  Scenario Outline: Verify button clear is working
#    Given The calculator is ready to use
#    When I have entered <Number> into the calculator
#    And I press button Clear
#    Then the result should be 0 on the screen
#    Examples:
#      | Number |
#      | 1      |
#      | 2      |
#
#  Scenario: Verify remember function is working correctly