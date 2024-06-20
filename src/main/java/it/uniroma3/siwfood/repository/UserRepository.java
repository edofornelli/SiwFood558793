package it.uniroma3.siwfood.repository;

import it.uniroma3.siwfood.model.Chef;
import it.uniroma3.siwfood.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
