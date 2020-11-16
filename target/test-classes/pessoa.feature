Feature: Consulta e cadastro de pessoas
    Validação do endpoint de consulta e registro de pessoa física

  Scenario: Registrar nova pessoa no sistema
    Given tento cadastrar uma nova pessoa
    Then recebo status "201"
    And valido campos cadastrados

  Scenario: Buscar pessoa no sistema
    Given busco uma pessoa cadastrada
    Then recebo status "200"
    And valido campos cadastrados

  Scenario: Registrar pessoa com CPF já cadastrado
    Given tento cadastrar uma pessoa com CPF já cadastrado
    Then recebo status "400"
    And valido a mensagem de erro para cpf cadastrado

  Scenario: Registrar pessoa sem CPF
    Given tento cadastrar uma pessoa sem CPF
    Then recebo status "500"

  Scenario: Registrar pessoa sem telefone
    Given tento cadastrar uma pessoa sem telefone
    Then recebo status "500"

  Scenario: Registrar pessoa só com DDD
    Given tento cadastrar uma pessoa só com DDD
    Then recebo status "500"

  Scenario: Registrar pessoa só com número do telefone
    Given tento cadastrar uma pessoa só com número de telefone
    Then recebo status "500"

  Scenario: Registrar pessoa sem endereço
    Given tento cadastrar uma pessoa sem endereço
    Then recebo status "201"

  Scenario: Buscar pessoa com telefone inválido
    Given informo um telefone não cadastrado
    Then recebo status "404"
    And valido a mensagem de erro para telefone