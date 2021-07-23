package com.paulohonorato.colaborators.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.paulohonorato.colaborators.dtos.ColaboradorDTO;
import com.paulohonorato.colaborators.entities.Colaborador;

public class ConverterColaborador {

    @Autowired
    private BCryptPasswordEncoder encrypt;
    
	public ConverterColaborador() {
		super();
	}

	public Colaborador toEntity(ColaboradorDTO dto) {
        Colaborador colaborador = new Colaborador();
        colaborador.setId(dto.getId());
        colaborador.setNome(dto.getNome());
        colaborador.setEmail(dto.getEmail());
        colaborador.setPais(dto.getPais());
        colaborador.setEstado(dto.getEstado());
        colaborador.setMunicipio(dto.getMunicipio());
        colaborador.setCep(dto.getCep());
        colaborador.setRua(dto.getRua());
        colaborador.setNumero(dto.getNumero());
        colaborador.setComplemento(dto.getComplemento());
        colaborador.setCpf(dto.getCpf());
        colaborador.setPis(dto.getPis());
        colaborador.setSenha(encrypt.encode(dto.getSenha()));

        return colaborador;
    }

    public ColaboradorDTO toDto(Colaborador colab) {
        ColaboradorDTO colaborador = new ColaboradorDTO();
        colaborador.setId(colab.getId());
        colaborador.setNome(colab.getNome());
        colaborador.setEmail(colab.getEmail());
        colaborador.setPais(colab.getPais());
        colaborador.setEstado(colab.getEstado());
        colaborador.setMunicipio(colab.getMunicipio());
        colaborador.setCep(colab.getCep());
        colaborador.setRua(colab.getRua());
        colaborador.setNumero(colab.getNumero());
        colaborador.setComplemento(colab.getComplemento());
        colaborador.setCpf(colab.getCpf());
        colaborador.setPis(colab.getPis());
        colaborador.setSenha(encrypt.encode(colab.getSenha()));

        return colaborador;
    }
}
