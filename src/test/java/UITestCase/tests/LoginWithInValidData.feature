Feature: Login with invalid credentials

  Scenario Outline: Login with invalid Credentials from JSON
    When user login with inValidnumber <numberKey> and inValidpassword <passwordKey>
    Then verify the error message <expectedMessageKey>

    Examples:
      | numberKey | passwordKey | expectedMessageKey |
      | 1         | 1           | 1                  |
      | 2         | 2           | 2                  |
      | 3         | 3           | 3                  |
      | 4         | 4           | 4                  |