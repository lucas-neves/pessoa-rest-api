package br.com.brasilprev.api;

import br.com.brasilprev.model.Pessoa;
import br.com.brasilprev.util.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @author lucasns
 * @since #1.0
 */
public class APIConnection {

    private static final Logger log = LoggerFactory.getLogger(APIConnection.class.getTypeName());

    public static ResponseEntity<Pessoa> getPessoa(String ddd, String numero) {
        log.info("Buscando a pessoa...");
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForEntity(String.format("%s/%s/%s", Data.get("app.baseurl"), ddd, numero), Pessoa.class);
        } catch (HttpServerErrorException | HttpClientErrorException e) {
            Data.set("erro", e.getResponseBodyAsString());
            return new ResponseEntity<>(e.getStatusCode());
        }
    }

    public static ResponseEntity<Pessoa> postPessoa(Pessoa pessoaModel) {
        log.info("Cadastrando a pessoa...");
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.postForEntity(Data.get("app.baseurl"), pessoaModel, Pessoa.class);
        } catch (HttpServerErrorException | HttpClientErrorException e) {
            Data.set("erro", e.getResponseBodyAsString());
            return new ResponseEntity<>(e.getStatusCode());
        }
    }
}
