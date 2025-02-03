package com.wiux.workshopmongo.services;

import com.wiux.workshopmongo.domain.User;
import com.wiux.workshopmongo.dto.UserDTO;
import com.wiux.workshopmongo.repository.UserRepository;
import com.wiux.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById (String id) {
        User user = repo.findOne(id);
        if(user == null){
            throw new ObjectNotFoundException("objeto não encontrado!");
        }
        return user;
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
