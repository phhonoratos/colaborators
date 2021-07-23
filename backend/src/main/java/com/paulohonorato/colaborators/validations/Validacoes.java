package com.paulohonorato.colaborators.validations;

import org.springframework.beans.factory.annotation.Autowired;

import com.paulohonorato.colaborators.entities.Colaborador;
import com.paulohonorato.colaborators.exceptions.RegraDeNegocioException;
import com.paulohonorato.colaborators.repositories.ColaboradorRepository;

public class Validacoes {

    @Autowired
    ColaboradorRepository repository;

    public Validacoes(){
        
    }
    
    public Validacoes(ColaboradorRepository repository) {
        super();
        this.repository = repository;
    }

    public void cadastro(Colaborador colaborador) {
        if(repository.existsByEmail(colaborador.getEmail())) {
            throw new RegraDeNegocioException("Já existe um usuário cadastrado com este email.");
        }
        if(repository.existsByCpf(colaborador.getCpf())) {
            throw new RegraDeNegocioException("Já existe um usuário cadastrado com este cpf.");
        }
        if(repository.existsByPis(colaborador.getPis())) {
            throw new RegraDeNegocioException("Já existe um usuário cadastrado com este pis.");
        }
    }

    public void atualizacao(Colaborador colaborador) {
        if(colaborador.getNome() == null || colaborador.getNome().trim().equals("") || colaborador.getNome().length() < 4) {
            throw new RegraDeNegocioException("Informe um NOME com pelo menos 4 letras.");
        }
        if(colaborador.getCep() == null || colaborador.getCep().trim().equals("") || colaborador.getCep().length() < 8) {
            throw new RegraDeNegocioException("Informe um CEP válido.");
        }
        if(colaborador.getNumero() == null || colaborador.getNumero().trim().equals("")) {
            throw new RegraDeNegocioException("Informe um NÚMERO de endereço válido.");
        }
        if(colaborador.getCpf() == null || colaborador.getCpf().trim().equals("") || colaborador.getCpf().length() < 11) {
            throw new RegraDeNegocioException("Informe um CPF válido.");
        }
        if(colaborador.getPis() == null || colaborador.getPis().trim().equals("") || colaborador.getPis().length() < 11) {
            throw new RegraDeNegocioException("Informe um PIS válido.");
        }
        if(colaborador.getSenha() == null || colaborador.getSenha().trim().equals("") || colaborador.getSenha().length() < 8) {
            throw new RegraDeNegocioException("Informe uma SENHA.");
        }
    }

}