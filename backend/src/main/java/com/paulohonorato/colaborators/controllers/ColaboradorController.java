package com.paulohonorato.colaborators.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulohonorato.colaborators.dtos.ColaboradorDTO;
import com.paulohonorato.colaborators.entities.Colaborador;
import com.paulohonorato.colaborators.exceptions.ErroDeAutenticacao;
import com.paulohonorato.colaborators.exceptions.RegraDeNegocioException;
import com.paulohonorato.colaborators.services.ColaboradorService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/colaborators")
public class ColaboradorController {
    
    @Autowired
    private ColaboradorService service;

    @GetMapping
    public ResponseEntity<List<ColaboradorDTO>> findAll() {
        List<ColaboradorDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Colaborador>> buscaPorId(@PathVariable("id") Long idColaborador) {
        Optional<Colaborador> colaborador = service.buscarPorId(idColaborador);
        return ResponseEntity.ok().body(colaborador);
    }

    @PostMapping("/acessar")
    public ResponseEntity<ColaboradorDTO> autenticar(@RequestBody ColaboradorDTO dto) {
        try {
            ColaboradorDTO colaboradorAutenticado = service.acessar(dto.getEmail());
            return ResponseEntity.ok().body(colaboradorAutenticado);
        } catch (ErroDeAutenticacao e) {
            throw new ErroDeAutenticacao(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<ColaboradorDTO> cadastrar(@RequestBody ColaboradorDTO dto) {
        try {
            ColaboradorDTO colaboradorSalvo = service.cadastrar(dto);
            return new ResponseEntity<ColaboradorDTO>(colaboradorSalvo, HttpStatus.CREATED);
        } catch (RegraDeNegocioException e) {
        	return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<ColaboradorDTO> atualizar(@PathVariable("id") Long id, @RequestBody ColaboradorDTO dto) {
    	try {
			dto.setId(id);
			ColaboradorDTO colab = service.atualizar(dto);
            return ResponseEntity.ok(colab);
        } catch (RegraDeNegocioException e) {
        	return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return service.buscarPorId(id).map(entity -> {
            service.deletar(entity);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }).orElseGet(() -> new ResponseEntity("Colaborador não encontrado na base de dados.", HttpStatus.BAD_REQUEST));
    }  
    
    @GetMapping("/find")
    public ColaboradorDTO buscarPorEmail(@RequestBody String email) {
			ColaboradorDTO colaborador = service.buscaPorEmail(email);
			return colaborador;
    }
    
}