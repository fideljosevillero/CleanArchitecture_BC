Feature: Get cost recharge

  Background:
    * url baseUrl
    * path 'recharge/costrecharge/'
    * def genericHeader = read('../commons/datajson/headers.json')
    * def data = read('datajson/balanceanddetaRequest.json')
    * def consultationcostResponse = read('datajson/balanceanddetaResponse.json')


  Scenario: Exitoso
    * configure headers = genericHeader

    Given request data
    When method POST
    Then status 200
    And match $.data[0].categoryRequestInformation.accountNumber  == 01530951240
    And match $.data[0].categoryRequestInformation.accountType == 'CUENTA_DE_AHORRO'


