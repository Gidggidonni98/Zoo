package com.example.zoo.animal.controller;

import com.example.zoo.animal.model.Animal;
import com.example.zoo.animal.model.AnimalRepository;
import com.example.zoo.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class AnimalService {
    @Autowired
    AnimalRepository ar;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("ok", false, ar.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if(ar.existsById(id)){
            return new ResponseEntity<>(new Message("Encontrado", false, ar.findById(id)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("No encontrado", true, null), HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Animal a){
        Optional<Animal> exist = ar.findByClaveAnimal(a.getClaveAnimal());
        if(exist.isPresent()){
            return new ResponseEntity<>(new Message("El registro ya existe", true, null), HttpStatus.BAD_REQUEST);
        }else{
            Animal saved = ar.saveAndFlush(a);
            return new ResponseEntity<>(new Message("Guardado", false, saved), HttpStatus.OK);
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Animal a){
        if(ar.existsById(a.getId())){
            return new ResponseEntity<>(new Message("Actualizado", false, ar.saveAndFlush(a)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Error al actualizar", true, null), HttpStatus.BAD_REQUEST);
        }
    }
}
