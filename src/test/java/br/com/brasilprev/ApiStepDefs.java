package br.com.brasilprev;

import br.com.brasilprev.api.APIConnection;
import br.com.brasilprev.model.Endereco;
import br.com.brasilprev.model.Pessoa;
import br.com.brasilprev.model.Telefone;
import br.com.brasilprev.util.Data;
import br.com.brasilprev.util.GeradorCPF;
import com.github.javafaker.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

/**
 * @author lucasns
 * @since #1.0
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestApplication.class)
@SpringBootTest
public class ApiStepDefs {

    private Faker faker;
    private ResponseEntity<Pessoa> pessoa;

    @Before
    public void setUp() {
        Data.getResourceProperties("application.properties");
        faker = new Faker(new Locale("pt-BR"));
    }

    @Given("^tento cadastrar uma nova pessoa$")
    public void cadastro_uma_nova_pessoa() {
        Pessoa pessoaModel = new Pessoa();
        String cpf = GeradorCPF.cpf(false);
        pessoaModel.setNome(faker.name().fullName());
        pessoaModel.setCpf(cpf);
        pessoaModel.addEndereco(generateFullAddress());

        Telefone telefoneModel = new Telefone();
        String ddd = faker.number().digits(2);
        String numero = faker.number().digits(8);
        telefoneModel.setDdd(ddd);
        telefoneModel.setNumero(numero);
        pessoaModel.addTelefone(telefoneModel);

        pessoa = APIConnection.postPessoa(pessoaModel);
        Data.set("cpf", cpf);
        Data.set("ddd", ddd);
        Data.set("numero", numero);
    }

    @Then("^recebo status \"([^\"]*)\"$")
    public void recebo_status(final String status) {
        Assert.assertEquals("O status não confere com o esperado", pessoa.getStatusCodeValue(), Integer.parseInt(status));
    }

    @And("^valido campos cadastrados$")
    public void valido_campos_cadastrados() {
        Assert.assertNotNull("O campo 'Nome' é nulo ou vazio", pessoa.getBody().getNome());
        Assert.assertNotNull("O campo 'CPF' é nulo ou vazio", pessoa.getBody().getCpf());
        Assert.assertNotNull("O campo 'Logradouro' é nulo ou vazio", pessoa.getBody().getEnderecos().get(0).getLogradouro());
        Assert.assertNotNull("O campo 'Numero' é nulo ou vazio", pessoa.getBody().getEnderecos().get(0).getNumero());
        Assert.assertNotNull("O campo 'Complemento' é nulo ou vazio", pessoa.getBody().getEnderecos().get(0).getComplemento());
        Assert.assertNotNull("O campo 'Bairro' é nulo ou vazio", pessoa.getBody().getEnderecos().get(0).getBairro());
        Assert.assertNotNull("O campo 'Cidade' é nulo ou vazio", pessoa.getBody().getEnderecos().get(0).getCidade());
        Assert.assertNotNull("O campo 'Estado' é nulo ou vazio", pessoa.getBody().getEnderecos().get(0).getEstado());
        Assert.assertNotNull("O campo 'DDD' é nulo ou vazio", pessoa.getBody().getTelefones().get(0).getDdd());
        Assert.assertNotNull("O campo 'Numero' é nulo ou vazio", pessoa.getBody().getTelefones().get(0).getNumero());
    }

    @Given("^busco uma pessoa cadastrada$")
    public void busco_uma_pessoa_cadastrada() {
        pessoa = APIConnection.getPessoa(Data.get("ddd"), Data.get("numero"));
    }

    @Given("^tento cadastrar uma pessoa com CPF já cadastrado$")
    public void tento_cadastrar_uma_pessoa_com_cpf_ja_cadastrado() {
        Pessoa pessoaModel = new Pessoa();
        pessoaModel.setNome(faker.name().fullName());
        pessoaModel.setCpf(Data.get("cpf"));
        pessoaModel.addEndereco(generateFullAddress());
        pessoaModel.addTelefone(generateFullPhone());

        pessoa = APIConnection.postPessoa(pessoaModel);
    }

    @And("^valido a mensagem de erro para cpf cadastrado$")
    public void valido_a_mensagem_de_erro_para_cpf_cadastrado() {
        Assert.assertTrue("Mensagem incorreta",
                Data.get("erro").contains(String.format("Já existe pessoa cadastrada com o CPF %s", Data.get("cpf"))));
    }

    @Given("^tento cadastrar uma pessoa sem CPF$")
    public void tento_cadastrar_uma_pessoa_sem_cpf() {
        Pessoa pessoaModel = new Pessoa();
        pessoaModel.setNome(faker.name().fullName());
        pessoaModel.addEndereco(generateFullAddress());
        pessoaModel.addTelefone(generateFullPhone());

        pessoa = APIConnection.postPessoa(pessoaModel);
    }

    @Given("^tento cadastrar uma pessoa sem telefone$")
    public void tento_cadastrar_uma_pessoa_sem_telefone() {
        Pessoa pessoaModel = new Pessoa();
        pessoaModel.setNome(faker.name().fullName());
        pessoaModel.setCpf(GeradorCPF.cpf(false));
        pessoaModel.addEndereco(generateFullAddress());

        Telefone telefoneModel = new Telefone();
        pessoaModel.addTelefone(telefoneModel);

        pessoa = APIConnection.postPessoa(pessoaModel);
    }

    @Given("^tento cadastrar uma pessoa só com DDD$")
    public void tento_cadastrar_uma_pessoa_so_com_ddd() {
        Pessoa pessoaModel = new Pessoa();
        pessoaModel.setNome(faker.name().fullName());
        pessoaModel.setCpf(GeradorCPF.cpf(false));
        pessoaModel.addEndereco(generateFullAddress());

        Telefone telefoneModel = new Telefone();
        telefoneModel.setDdd(faker.number().digits(2));
        pessoaModel.addTelefone(telefoneModel);

        pessoa = APIConnection.postPessoa(pessoaModel);
    }

    @Given("^tento cadastrar uma pessoa só com número de telefone$")
    public void tento_cadastrar_uma_pessoa_so_com_telefone() {
        Pessoa pessoaModel = new Pessoa();
        pessoaModel.setNome(faker.name().fullName());
        pessoaModel.setCpf(GeradorCPF.cpf(false));
        pessoaModel.addEndereco(generateFullAddress());

        Telefone telefoneModel = new Telefone();
        telefoneModel.setNumero(faker.number().digits(8));
        pessoaModel.addTelefone(telefoneModel);

        pessoa = APIConnection.postPessoa(pessoaModel);
    }

    @Given("^tento cadastrar uma pessoa sem endereço$")
    public void tento_cadastrar_uma_pessoa_sem_endereco() {
        Pessoa pessoaModel = new Pessoa();
        pessoaModel.setNome(faker.name().fullName());
        pessoaModel.setCpf(GeradorCPF.cpf(false));

        Endereco enderecoModel = new Endereco();
        pessoaModel.addEndereco(enderecoModel);
        pessoaModel.addTelefone(generateFullPhone());

        pessoa = APIConnection.postPessoa(pessoaModel);
    }

    @Given("^informo um telefone não cadastrado$")
    public void informo_um_telefone_nao_cadastrado() {
        String ddd = faker.number().digits(2);
        String numero = faker.number().digits(8);

        pessoa = APIConnection.getPessoa(ddd, numero);
        Data.set("ddd", ddd);
        Data.set("numero", numero);
    }

    @And("^valido a mensagem de erro para telefone$")
    public void valido_a_mensagem_de_erro_para_telefone() {
        Assert.assertTrue("Mensagem incorreta",
                Data.get("erro").contains(String.format("Não existe pessoa com o telefone (%s)%s", Data.get("ddd"), Data.get("numero"))));
    }

    private Endereco generateFullAddress() {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(faker.address().streetAddress());
        endereco.setNumero(Integer.parseInt(faker.address().streetAddressNumber()));
        endereco.setComplemento(faker.address().buildingNumber());
        endereco.setBairro(faker.address().cityName());
        endereco.setCidade(faker.address().city());
        endereco.setEstado(faker.address().state().substring(0, 2));
        return endereco;
    }

    private Telefone generateFullPhone() {
        Telefone telefone = new Telefone();
        telefone.setDdd(faker.number().digits(2));
        telefone.setNumero(faker.number().digits(8));
        return telefone;
    }
}
