Feature: Search the cheapest plane ticket on the VivaAir webpage
  I as a traveller
  Want to search the cheapest plane ticket
  To save money

  Scenario: Search the cheapest ticket for tomorrow on the Medellín-Bogotá route
    Given Meg wants to search a ticket
    When Meg chooses the cheapest ticket
    Then Meg should watch the seat selection page
