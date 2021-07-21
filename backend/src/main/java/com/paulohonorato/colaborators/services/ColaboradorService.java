package com.paulohonorato.colaborators.services;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulohonorato.colaborators.dtos.ColaboradorDTO;
import com.paulohonorato.colaborators.entities.Colaborador;
import com.paulohonorato.colaborators.repositories.ColaboradorRepository;
import com.paulohonorato.colaborators.validations.Validacoes;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository repository;

    @Autowired
    private Validacoes validar;

    public ColaboradorService(ColaboradorRepository repository) {
        super();
        this.repository = repository;
    }

    public List<ColaboradorDTO> findAll() {
        List<Colaborador> result = repository.findAll();
        return result.stream().map(x -> new ColaboradorDTO(x)).collect(Collectors.toList());
    }

    public ColaboradorDTO acessar(String email) {
        ColaboradorDTO colaborador = repository.findByEmail(email);
        return colaborador;
    }

    public Colaborador cadastrar(Colaborador colaborador) {
        validar.cadastro(colaborador);
        return repository.save(colaborador);
    }

    public Colaborador atualizar(Colaborador colaborador) {
        Objects.requireNonNull(colaborador.getId());
        validar.atualizacao(colaborador);
        return repository.save(colaborador);
    }

    public void deletar(Colaborador colaborador) {
        Objects.requireNonNull(colaborador.getId());
        repository.delete(colaborador);
    }
    
    public Optional<Colaborador> buscarPorId(Long id) {
        return repository.findById(id);
    }

}
