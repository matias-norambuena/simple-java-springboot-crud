package com.mycrud.tareas.controllers;

import com.mycrud.tareas.entities.Tareas;
import com.mycrud.tareas.services.TareasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareasController {

    private final TareasService tareasService;

    public TareasController(TareasService tareasService) {
        this.tareasService = tareasService;
    }

    @GetMapping("/listar")
    public List<Tareas> getAllTareas() {
        return tareasService.getAllTareas();
    }

    @PostMapping("/crear")
    public String crearTareas(@RequestBody Tareas tarea) {
        tareasService.save(tarea);
        return "Tarea creada";
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarTareas(@PathVariable Long id) {
        tareasService.delete(id);
        return "Tarea Borrada";
    }

    @PutMapping("/modificar")
    public String modificarTareas(@RequestBody Tareas tarea) throws Exception {
        tareasService.modificar(tarea);
        return "Tarea modificada";
    }
}
