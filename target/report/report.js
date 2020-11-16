$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("pessoa.feature");
formatter.feature({
  "line": 1,
  "name": "Consulta e cadastro de pessoas",
  "description": "  Validação do endpoint de consulta e registro de pessoa física",
  "id": "consulta-e-cadastro-de-pessoas",
  "keyword": "Feature"
});
formatter.before({
  "duration": 55711100,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Registrar nova pessoa no sistema",
  "description": "",
  "id": "consulta-e-cadastro-de-pessoas;registrar-nova-pessoa-no-sistema",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "tento cadastrar uma nova pessoa",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "recebo status \"201\"",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "valido campos cadastrados",
  "keyword": "And "
});
formatter.match({
  "location": "ApiStepDefs.cadastro_uma_nova_pessoa()"
});
formatter.result({
  "duration": 898482000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "201",
      "offset": 15
    }
  ],
  "location": "ApiStepDefs.recebo_status(String)"
});
formatter.result({
  "duration": 5087300,
  "status": "passed"
});
formatter.match({
  "location": "ApiStepDefs.valido_campos_cadastrados()"
});
formatter.result({
  "duration": 153100,
  "status": "passed"
});
formatter.before({
  "duration": 4542500,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Buscar pessoa no sistema",
  "description": "",
  "id": "consulta-e-cadastro-de-pessoas;buscar-pessoa-no-sistema",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "busco uma pessoa cadastrada",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "recebo status \"200\"",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "valido campos cadastrados",
  "keyword": "And "
});
formatter.match({
  "location": "ApiStepDefs.busco_uma_pessoa_cadastrada()"
});
formatter.result({
  "duration": 185030000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 15
    }
  ],
  "location": "ApiStepDefs.recebo_status(String)"
});
formatter.result({
  "duration": 94300,
  "status": "passed"
});
formatter.match({
  "location": "ApiStepDefs.valido_campos_cadastrados()"
});
formatter.result({
  "duration": 56400,
  "status": "passed"
});
formatter.before({
  "duration": 1401500,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Registrar pessoa com CPF já cadastrado",
  "description": "",
  "id": "consulta-e-cadastro-de-pessoas;registrar-pessoa-com-cpf-já-cadastrado",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "tento cadastrar uma pessoa com CPF já cadastrado",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "recebo status \"400\"",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "valido a mensagem de erro para cpf cadastrado",
  "keyword": "And "
});
formatter.match({
  "location": "ApiStepDefs.tento_cadastrar_uma_pessoa_com_cpf_ja_cadastrado()"
});
formatter.result({
  "duration": 172464700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "400",
      "offset": 15
    }
  ],
  "location": "ApiStepDefs.recebo_status(String)"
});
formatter.result({
  "duration": 107000,
  "status": "passed"
});
formatter.match({
  "location": "ApiStepDefs.valido_a_mensagem_de_erro_para_cpf_cadastrado()"
});
formatter.result({
  "duration": 184500,
  "status": "passed"
});
formatter.before({
  "duration": 2198100,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Registrar pessoa sem CPF",
  "description": "",
  "id": "consulta-e-cadastro-de-pessoas;registrar-pessoa-sem-cpf",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "tento cadastrar uma pessoa sem CPF",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "recebo status \"500\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiStepDefs.tento_cadastrar_uma_pessoa_sem_cpf()"
});
formatter.result({
  "duration": 281076800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500",
      "offset": 15
    }
  ],
  "location": "ApiStepDefs.recebo_status(String)"
});
formatter.result({
  "duration": 110600,
  "status": "passed"
});
formatter.before({
  "duration": 1950700,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Registrar pessoa sem telefone",
  "description": "",
  "id": "consulta-e-cadastro-de-pessoas;registrar-pessoa-sem-telefone",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 24,
  "name": "tento cadastrar uma pessoa sem telefone",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "recebo status \"500\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiStepDefs.tento_cadastrar_uma_pessoa_sem_telefone()"
});
formatter.result({
  "duration": 354558100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500",
      "offset": 15
    }
  ],
  "location": "ApiStepDefs.recebo_status(String)"
});
formatter.result({
  "duration": 111600,
  "status": "passed"
});
formatter.before({
  "duration": 1595300,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "Registrar pessoa só com DDD",
  "description": "",
  "id": "consulta-e-cadastro-de-pessoas;registrar-pessoa-só-com-ddd",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 28,
  "name": "tento cadastrar uma pessoa só com DDD",
  "keyword": "Given "
});
formatter.step({
  "line": 29,
  "name": "recebo status \"500\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiStepDefs.tento_cadastrar_uma_pessoa_so_com_ddd()"
});
formatter.result({
  "duration": 410852300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500",
      "offset": 15
    }
  ],
  "location": "ApiStepDefs.recebo_status(String)"
});
formatter.result({
  "duration": 115500,
  "status": "passed"
});
formatter.before({
  "duration": 1531200,
  "status": "passed"
});
formatter.scenario({
  "line": 31,
  "name": "Registrar pessoa só com número do telefone",
  "description": "",
  "id": "consulta-e-cadastro-de-pessoas;registrar-pessoa-só-com-número-do-telefone",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 32,
  "name": "tento cadastrar uma pessoa só com número de telefone",
  "keyword": "Given "
});
formatter.step({
  "line": 33,
  "name": "recebo status \"500\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiStepDefs.tento_cadastrar_uma_pessoa_so_com_telefone()"
});
formatter.result({
  "duration": 373747300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500",
      "offset": 15
    }
  ],
  "location": "ApiStepDefs.recebo_status(String)"
});
formatter.result({
  "duration": 92800,
  "status": "passed"
});
formatter.before({
  "duration": 1229600,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "Registrar pessoa sem endereço",
  "description": "",
  "id": "consulta-e-cadastro-de-pessoas;registrar-pessoa-sem-endereço",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 36,
  "name": "tento cadastrar uma pessoa sem endereço",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "recebo status \"201\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiStepDefs.tento_cadastrar_uma_pessoa_sem_endereco()"
});
formatter.result({
  "duration": 215588200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "201",
      "offset": 15
    }
  ],
  "location": "ApiStepDefs.recebo_status(String)"
});
formatter.result({
  "duration": 82900,
  "status": "passed"
});
formatter.before({
  "duration": 1606300,
  "status": "passed"
});
formatter.scenario({
  "line": 39,
  "name": "Buscar pessoa com telefone inválido",
  "description": "",
  "id": "consulta-e-cadastro-de-pessoas;buscar-pessoa-com-telefone-inválido",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 40,
  "name": "informo um telefone não cadastrado",
  "keyword": "Given "
});
formatter.step({
  "line": 41,
  "name": "recebo status \"404\"",
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "valido a mensagem de erro para telefone",
  "keyword": "And "
});
formatter.match({
  "location": "ApiStepDefs.informo_um_telefone_nao_cadastrado()"
});
formatter.result({
  "duration": 69216400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 15
    }
  ],
  "location": "ApiStepDefs.recebo_status(String)"
});
formatter.result({
  "duration": 308100,
  "status": "passed"
});
formatter.match({
  "location": "ApiStepDefs.valido_a_mensagem_de_erro_para_telefone()"
});
formatter.result({
  "duration": 138100,
  "status": "passed"
});
});