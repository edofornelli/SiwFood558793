package it.uniroma3.siwfood.service;

import it.uniroma3.siwfood.model.User;
import it.uniroma3.siwfood.repository.CredentialsRepository;
import it.uniroma3.siwfood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(Long id){
        return userRepository.findById(id).get();
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }

}
