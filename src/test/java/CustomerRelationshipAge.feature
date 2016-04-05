Feature: Customer ReleationShip Age

@mockTimelineCustomerAge5Month
  Scenario: Customer Relationship duration
    Given I was authenticated and have a valid session
    When I retrieved releationship age
    Then I will get the customer releationship date
