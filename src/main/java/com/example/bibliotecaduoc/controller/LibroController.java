package com.example.bibliotecaduoc.controller;
import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping ("/api/v1/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping("path")
    public List<Libro> listarLibros(){
        return libroService.getLibros();
    }
    
    
    @PostMapping("path")
    public Libro agregarLibro(@RequestBody Libro libro){
        return libroService.saveLibro(libro);
    }
    
    @GetMapping("path")
    public Libro buscarLibro(@PathVariable int id){
        return libroService.getLibroId(id);
    }
    
    @PutMapping
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro){
        return libroService.updateLibro(libro);
    }
    
    @DeleteMapping
    public String eliminarLibro(@PathVariable int id){
        return libroService.deleteLibro(id);
    }
    
}
