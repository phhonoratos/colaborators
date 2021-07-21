package com.paulohonorato.colaborators.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paulohonorato.colaborators.dtos.ColaboradorDTO;
import com.paulohonorato.colaborators.entities.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    boolean existsByEmail(String email);
    
    boolean existsByCpf(String cpf);

    boolean existsByPis(String pis);

    ColaboradorDTO findByEmail(String email);
    
}
