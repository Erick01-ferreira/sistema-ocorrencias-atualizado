package com.exemplo.ocorrencias.services;

import com.exemplo.ocorrencias.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável por fornecer os dados do usuário
 * durante o processo de autenticação.
 */
@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    /**
     * Carrega os detalhes do usuário com base no login fornecido.
     *
     * @param username login do usuário.
     * @return os detalhes do usuário encontrados.
     * @throws UsernameNotFoundException se o usuário não for encontrado.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }
}

