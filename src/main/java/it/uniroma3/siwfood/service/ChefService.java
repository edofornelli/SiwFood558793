package it.uniroma3.siwfood.service;

import it.uniroma3.siwfood.model.Chef;
import it.uniroma3.siwfood.repository.ChefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChefService {
    @Autowired
    private ChefRepository chefRepository;

    public Chef findById (long id) {
        return chefRepository.findById(id).get();
    }


    public Iterable<Chef> findAll(){
        return chefRepository.findAll();
    }

    public void save(Chef chef) {
        chefRepository.save(chef);
    }
}
