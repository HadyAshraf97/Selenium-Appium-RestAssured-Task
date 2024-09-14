Feature: Scenario Two

  Scenario Outline: CheckOut Scenario

    When user login with ValidUserName <UserName> and ValidPassword <Password>
    Then ProductTxt message should be <expectedMessageKey>
    When Select HighPrices from FilterBtn
    When Add The Most Expensive Two Products
    When Click on the cart button
    Then CartTxt message should be <expectedCartMessage>
    When Click on the CheckOut button
    Then CheckoutTxt message should be <expectedCheckOutMessage>
    When Fill all the displayed form <FirstName>, <LastName>,<PostalCode>
    When Click on the Continue button
    Then CheckoutOverViewTxt message should be <expectedCheckOutOverviewMessage>
    Then Verify the Items total amount before taxes
    Then Verify that the URL matches
    When Click on the “Finish” button
    Then Verify both, the Thank You and the order has been dispatched messages
    Examples:
      | UserName        | Password       | expectedMessageKey | expectedCartMessage | expectedCheckOutMessage      | FirstName | LastName | PostalCode | expectedCheckOutOverviewMessage |
      | "standard_user" | "secret_sauce" | "Products"         | "Your Cart"         | "Checkout: Your Information" | "Hady"    | "Omar"   | "02"       | "Checkout: Overview"            |