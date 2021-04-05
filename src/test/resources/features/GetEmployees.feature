Feature: Consultar Empleos Disponibles

  Scenario: Consultar empleos disponible con palabra clave
    Given Ingreso a la pagina de choucairtesting
    And Navego a la opcion Empleos
    And Ingreso la palabra Migracion en el campo search_keywords
    When Doy Click en la opcion Search Jobs
    Then Visualizo la oferta de empleo disponible