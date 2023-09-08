package com.xmacedo.controller;

import java.util.List;
import java.util.Optional;
import com.xmacedo.model.LibraryModel;
import com.xmacedo.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/library")
public class LibraryController {

    @Autowired
    LibraryRepository libraryRepository;

    @GetMapping
    public ResponseEntity<List<LibraryModel>> getAllSections(){
        List<LibraryModel> allSections = libraryRepository.findAll();
        return new ResponseEntity<>(allSections, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LibraryModel> getSectionById(@PathVariable Long id){
        Optional<LibraryModel> library = libraryRepository.findById(id);

        if(library.isPresent()){
            return new ResponseEntity<>(library.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<LibraryModel> createNewStudent(@RequestBody LibraryModel libBody) {
        LibraryModel libResult = libraryRepository.save(libBody);
        if (libResult == null) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(libResult, HttpStatus.CREATED);
    }
}