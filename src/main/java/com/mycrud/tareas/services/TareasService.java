package com.mycrud.tareas.services;

import com.mycrud.tareas.entities.Tareas;
import com.mycrud.tareas.repositories.TareasRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TareasService {
    private final TareasRepository repository;

    public TareasService(TareasRepository repository) {
        this.repository = repository;
    }

    /**
     * Entrega una lista de todas las tareas
     */
    public List<Tareas> getAllTareas() {
        return (List<Tareas>) repository.findAll();
    }

    /**
     * Guarda las tareas en la base de datos
     *
     * @return
     */
    public Optional<Tareas> save(Tareas tarea) {
        var nuevaTarea = repository.save(tarea);
        return Optional.of(nuevaTarea);
    }

    /**
     * Borra las tareas por su id
     */
    public void delete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Modifica las tareas existentes
     */
    public void modificar(Tareas tarea) throws Exception {
        Optional<Tareas> optionalTareas = repository.findById((long) tarea.id);
        if (optionalTareas.isEmpty()) {
            throw new Exception("No existe este registro");
        }
        Tareas tareaModificada = optionalTareas.get();
        tareaModificada.descripcion = tarea.descripcion;
        tareaModificada.vigente = tarea.vigente;
        tareaModificada.fechaCreacion = Instant.now();
        repository.save(tareaModificada);
    }
}
