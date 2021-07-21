package com.paulohonorato.colaborators.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.paulohonorato.colaborators.dtos.ColaboradorDTO;
import com.paulohonorato.colaborators.repositories.ColaboradorRepository;
import com.paulohonorato.colaborators.security.ColaboradorSS;

@Service
public class ColaboradorDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ColaboradorRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ColaboradorDTO colaborador = repository.findByEmail(email);
        if(colaborador == null) {
            throw new UsernameNotFoundException(email);
        }
        return new ColaboradorSS(colaborador.getId(), colaborador.getEmail(), colaborador.getSenha());
    }
    
}