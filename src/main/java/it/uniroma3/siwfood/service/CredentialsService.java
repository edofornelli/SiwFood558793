package it.uniroma3.siwfood.service;

import it.uniroma3.siwfood.model.Credentials;
import it.uniroma3.siwfood.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialsService {

    @Autowired
    private CredentialsRepository credentialsRepository;

    public Credentials getCredentials(Long id){
        return credentialsRepository.findById(id).get();
    }

    public Credentials getCredentials(String username){
        return credentialsRepository.findByUsername(username).get();

    }

    public Credentials saveCredentials(Credentials credentials){
        return credentialsRepository.save(credentials);
    }

}
