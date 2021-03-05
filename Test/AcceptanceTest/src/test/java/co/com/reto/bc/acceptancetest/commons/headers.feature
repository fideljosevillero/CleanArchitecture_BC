Feature: Get balance civic card

  Background:
    * url baseUrl
    * def genericHeader = read('../commons/datajson/headers.json')

  Scenario Outline: Consult all services when Content-Type header is empty
    * eval genericHeader['Content-Type'] = ""
    * configure headers = genericHeader

    Given request read('<data>')
    And path '<path>'
    When method POST
    Then status 200
    And match response.errors[0].status == "404"

    Examples:
      | path              | data                                                  |
      | BalanceAndDeta    | ../balanceanddeta/datajson/balanceanddetaRequest.json |

  Scenario Outline: Consult all services when Transaction-Tracker header is empty
    * eval genericHeader['Transaction-Tracker'] = ""
    * configure headers = genericHeader

    Given request read('<data>')
    And path '<path>'
    When method POST
    Then status 200
    And match response.errors[0].code == "#? _== 'ORQ001' || _== 'ORQ002'"
    And match response.errors[0].detail == "#notnull"

    Examples:
      | path                           | data                                                 |
      | BalanceAndDeta    | ../balanceanddeta/datajson/balanceanddetaRequest.json |

  Scenario Outline: Consult all services when Session-Tracker header is empty
    * eval genericHeader['Session-Tracker'] = ""
    * configure headers = genericHeader

    Given request read('<data>')
    And path '<path>'
    When method POST
    Then status 200
    And match response.errors[0].code == "#? _== 'ORQ003' || _== 'ORQ004'"
    And match response.errors[0].detail ==  "#notnull"

    Examples:
      | path                           | data                                                 |
      | BalanceAndDeta    | ../balanceanddeta/datajson/balanceanddetaRequest.json |

  Scenario Outline: Consult all services when Channel header is empty
    * eval genericHeader.Channel = ""
    * configure headers = genericHeader

    Given request read('<data>')
    And path '<path>'
    When method POST
    Then status 200
    And match response.errors[0].code == "#? _== 'ORQ005' || _== 'ORQ006'"
    And match response.errors[0].detail == "#notnull"

    Examples:
      | path                           | data                                                 |
      | BalanceAndDeta    | ../balanceanddeta/datajson/balanceanddetaRequest.json |

  Scenario Outline: Consult all services when Date header is empty
    * eval genericHeader.Date = ""
    * configure headers = genericHeader

    Given request read('<data>')
    And path '<path>'
    When method POST
    Then status 200
    And match response.errors[0].code == "#? _== 'ORQ007' || _== 'ORQ008' ||  _== 'ORQ009'"
    And match response.errors[0].detail == "#notnull"

    Examples:
      | path                           | data                                                 |
      | BalanceAndDeta    | ../balanceanddeta/datajson/balanceanddetaRequest.json |

  Scenario Outline: Consult all services when DateTime header is empty
    * eval genericHeader.DateTime = ""
    * configure headers = genericHeader

    Given request read('<data>')
    And path '<path>'
    When method POST
    Then status 200
    And match response.errors[0].code == "#? _== 'ORQ010' || _== 'ORQ011' || _== 'ORQ012'"
    And match response.errors[0].detail == "#notnull"

    Examples:
      | path                           | data                                                 |
      | BalanceAndDeta    | ../balanceanddeta/datajson/balanceanddetaRequest.json |

  Scenario Outline: Consult all services when Ip header is empty
    * eval genericHeader.Ip = ""
    * configure headers = genericHeader

    Given request read('<data>')
    And path '<path>'
    When method POST
    Then status 200
    And match response.errors[0].code == "#? _== 'ORQ013' || _== 'ORQ014'"
    And match response.errors[0].detail == "#notnull"

    Examples:
      | path                           | data                                                 |
      | BalanceAndDeta    | ../balanceanddeta/datajson/balanceanddetaRequest.json |

  Scenario Outline: Consult all services when ClientID header is empty
    * eval genericHeader.ClientID = ""
    * configure headers = genericHeader

    Given request read('<data>')
    And path '<path>'
    When method POST
    Then status 200
    And match response.errors[0].code == "#? _== 'ORQ015' || _== 'ORQ016' ||  _== 'ORQ017' || _== 'ORQ018'"
    And match response.errors[0].detail == "#notnull"

    Examples:
      | path                           | data                                                 |
      | BalanceAndDeta    | ../balanceanddeta/datajson/balanceanddetaRequest.json |

  Scenario Outline: Consult all services when ClientType header empty
    * eval genericHeader.ClientType = ""
    * configure headers = genericHeader

    Given request read('<data>')
    And path '<path>'
    When method POST
    Then status 200
    And match response.errors[0].code == "#? _== 'ORQ019' || _== 'ORQ020' || _== 'ORQ021'|| _== 'BPRCG206'"
    And match response.errors[0].detail ==  "#notnull"

    Examples:
      | path                           | data                                                 |
      | BalanceAndDeta    | ../balanceanddeta/datajson/balanceanddetaRequest.json |