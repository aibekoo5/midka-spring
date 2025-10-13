package com.aibek.midkaspring.controller;

import com.aibek.midkaspring.dto.StudentDto;
import com.aibek.midkaspring.dto.UniverDto;
import com.aibek.midkaspring.service.UniverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/univer")
public class UniverController {
    private final UniverService univerService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(univerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(univerService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addUniver(@RequestBody UniverDto univerDto){
        univerService.createUniver(univerDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUniver(@PathVariable(name = "id") Long id, @RequestBody UniverDto univerDto){
        univerService.updateUniver(id, univerDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUniver(@PathVariable(name = "id") Long id){
        univerService.deleteUniver(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
