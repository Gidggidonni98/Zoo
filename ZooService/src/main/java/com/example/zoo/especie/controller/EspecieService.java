package com.example.zoo.especie.controller;

import com.example.zoo.especie.model.Especie;
import com.example.zoo.especie.model.EspecieRepository;
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
public class EspecieService {
    @Autowired
    EspecieRepository er;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("ok", false, er.findAll()),
                HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if (er.existsById(id)) {
            return  new ResponseEntity<>(new Message("ok", false, er.findById(id)),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La especie no se encuentra registrada", true, null),
                HttpStatus.BAD_REQUEST);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findByNombreComun(String nombreComun){
        if (er.existsByNombreComun(nombreComun)) {
            return  new ResponseEntity<>(new Message("ok", false, er.findByNombreComun(nombreComun)),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La especie no se encuentra registrada", true, null),
                HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Especie especie){
        Optional<Especie> exists = er.findByNombreComun(especie.getNombreComun());
        System.out.println(exists);
        if (exists.isPresent()){
            return new ResponseEntity<>(new Message("La especie ya se encuentra registrada", true, null),
                    HttpStatus.BAD_REQUEST);
        }
        System.out.println(especie.getFamilia());
        return new ResponseEntity<>(new Message("ok", false, er.saveAndFlush(especie)),
                HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Message> update(Especie especie){
        if (er.existsById(especie.getId())){
            return new ResponseEntity<>(new Message("ok", false, er.saveAndFlush(especie)),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La especie no se encuentra registrada", true, null),
                HttpStatus.BAD_REQUEST);
    }
}
