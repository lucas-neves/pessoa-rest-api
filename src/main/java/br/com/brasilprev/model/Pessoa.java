package br.com.brasilprev.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lucasns
 * @since #1.0
 */
public class Pessoa {
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("cpf")
    private String cpf;
    @JsonProperty("enderecos")
    private List<Endereco> enderecos = new ArrayList<>();
    @JsonProperty("telefones")
    private List<Telefone> telefones = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void addEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public void addTelefone(Telefone telefone) {
        this.telefones.add(telefone);
    }
}
