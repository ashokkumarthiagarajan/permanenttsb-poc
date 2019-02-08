@login
Feature:  User navigation - Alert message validation for permanenttsb web application

  @booking
 Scenario Outline: Verify Alert Message if User doesnot provide mandatory fieldss
    Given permanenttsb online user is successfully able to launch the web application
    When user is able to navigate to Current Accounts
    And user wants to explore current accounts more
    And user tries to book an appointment by submitting the details "<FirstName>" "<SurName>" "<Day>" "<Month>" "<Year>" "<Address1>" "<Address2>" "<Town>"
    Then system successfully alerts the user to enter mandatory details


    Examples:
      |FirstName	|SurName	|Day|Month	|Year|Address1		|Address2		|Town	|
      |Ashok		|Thiagarajan|25	|08		|1988|2 Gable End	|ClockHouse Road|Dublin	|