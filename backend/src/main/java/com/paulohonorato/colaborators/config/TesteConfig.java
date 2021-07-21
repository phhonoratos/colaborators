package com.paulohonorato.colaborators.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.paulohonorato.colaborators.entities.Colaborador;
import com.paulohonorato.colaborators.repositories.ColaboradorRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder encrypt;

    @Autowired
    private ColaboradorRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Colaborador colab1 = new Colaborador(null, "Paulo", "paulo@email.com", "Brasil", "São Paulo", "São Paulo", "11122233", "Rua da paz", "55", "apto x", "77215599019", "63469126513", encrypt.encode("senhasenha"));
        Colaborador colab2 = new Colaborador(null, "Pedro", "pedro@email.com", "Brasil", "Sao Paulo", "Sao Paulo", "11122233", "Rua da paz", "55", "apto x", "89058475018", "48871327729", encrypt.encode("senhasenha"));
        repository.saveAll(Arrays.asList(colab1, colab2));
    }
    
}