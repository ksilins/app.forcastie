@smoke
Feature: forcastie smoke test

  Scenario: search existing city
    Given app is opened
    When search for Riga
    And select it from locations
    Then selected city weather is shown

  Scenario Outline: switching day tabs
    Given I'm on main page
    When I tap on <day> tab
    Then <day> weather is shown
    Examples:
      | day      |
      | tomorrow |
      | today    |
      | later    |

  Scenario Outline: changing temperature scale
    Given I'm on main page
    When I set temperature scale to <scale>
    And return to main page
    Then temperature is shown <scale>
    Examples:
      | scale      |
      | Fahrenheit |
      | Kelvin     |

  Scenario: update weather report
    Given I'm on main page
    When I tap refresh button
    Then weather report is updated