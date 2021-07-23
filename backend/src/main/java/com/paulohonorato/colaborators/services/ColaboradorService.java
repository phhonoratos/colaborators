package com.paulohonorato.colaborators.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulohonorato.colaborators.dtos.ColaboradorDTO;
import com.paulohonorato.colaborators.entities.Colaborador;
import com.paulohonorato.colaborators.exceptions.RegraDeNegocioException;
import com.paulohonorato.colaborators.repositories.ColaboradorRepository;
import com.paulohonorato.colaborators.utils.ConverterColaborador;
import com.paulohonorato.colaborators.validations.Validacoes;

@Service
public class ColaboradorService {
	
	@Autowired
	private ConverterColaborador converter;

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

    public ColaboradorDTO cadastrar(ColaboradorDTO colaborador) {
    	try {
    		Colaborador colab = converter.toEntity(colaborador);
        	validar.cadastro(colab);        
            return new ColaboradorDTO(repository.save(colab));
		} catch (RegraDeNegocioException e) {
			throw new RegraDeNegocioException(e.getMessage());
		}
    }

    public ColaboradorDTO atualizar(ColaboradorDTO colaborador) {
    	try {
    		Colaborador colab = converter.toEntity(colaborador);
            Objects.requireNonNull(colab.getId());
            validar.atualizacao(colab);
            return new ColaboradorDTO(repository.save(colab));
		} catch (RegraDeNegocioException e) {
			throw new RegraDeNegocioException(e.getMessage());
		}    	
    }

    public void deletar(Colaborador colaborador) {
        Objects.requireNonNull(colaborador.getId());
        repository.delete(colaborador);
    }
    
    public Optional<Colaborador> buscarPorId(Long id) {
        return repository.findById(id);
    }
    
    public ColaboradorDTO buscaPorEmail(String email) {
    	return repository.findByEmail(email);
    }

}
