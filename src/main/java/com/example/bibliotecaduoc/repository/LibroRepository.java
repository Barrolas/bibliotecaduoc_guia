package com.example.bibliotecaduoc.repository;
import com.example.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {
    
    private List<Libro> Listalibros = new ArrayList<>();


    public List<Libro> obtenerLibros(){
        return Listalibros;
    }
    
    public Libro buscarPorId(int id){
        for (Libro libro : Listalibros){
            if (libro.getId() == id){
                return libro;
            }
        }
        return null;
    }

    public Libro buscarPorIsbn(String isbn){
        for (Libro libro : Listalibros){
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }

        }
        return null;
    }
    public Libro guardar (Libro lib){
        Listalibros.add(lib);
        return lib;
    }

    public Libro actualizar(Libro lib){
        int id = 0;
        int idPosicion = 0;
        for (int i = 0; i < Listalibros.size(); i++){
            if (Listalibros.get(i).getId() == lib.getId()) {
                id = lib.getId();
                idPosicion = i;
                
            }
        }

        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());;
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        Listalibros.set(idPosicion, libro1);
        return libro1;
      }
      
      public void eliminar(int id){
        Libro libro = buscarPorId(id);
        if (libro != null) {
            Listalibros.remove(libro);
        }

        int idPosicion = 0;
        for(int i = 0; i < Listalibros.size(); i++){
            if (Listalibros.get(i).getId() == id) {
                idPosicion = i;
                break;
            }
        }
        if (idPosicion > 0) {
            Listalibros.remove(idPosicion);
        }

        Listalibros.removeIf(x -> x.getId() == id);
      }
}
