package it.uniroma3.siwfood.repository;

import it.uniroma3.siwfood.model.Chef;
import it.uniroma3.siwfood.model.Credentials;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface  CredentialsRepository extends CrudRepository<Credentials, Long>  {
    public Optional<Credentials> findByUsername(String username);
    public Optional<Credentials> findById(Long id);

}
