package br.com.brasilprev.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author lucasns
 * @since #1.0
 */
public class Telefone {
    @JsonProperty("ddd")
    private String ddd;
    @JsonProperty("numero")
    private String numero;

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
