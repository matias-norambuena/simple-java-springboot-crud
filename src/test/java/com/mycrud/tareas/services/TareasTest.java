package com.mycrud.tareas.services;

import com.mycrud.tareas.entities.Tareas;
import com.mycrud.tareas.repositories.TareasRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TareasTest {

    private TareasService tareasService;
    private Tareas tareaPrueba;
    private TareasRepository tareasRepository;

    @BeforeEach
    public void setup() {
        tareasRepository = Mockito.mock(TareasRepository.class);
        tareasService = new TareasService(tareasRepository);
        tareaPrueba = new Tareas(1,"descripcion",true);
    }

    @Test
    public void getAllTest(){
        Assertions.assertTrue(tareasService.getAllTareas().isEmpty());
    }

    @Test
    public void saveTest() {
        when(tareasRepository.save(any())).thenReturn(tareaPrueba);
        Optional<Tareas> tareaGenerada = tareasService.save(tareaPrueba);
        Assertions.assertTrue(tareaGenerada.isPresent());
        Assertions.assertEquals(tareaGenerada,Optional.of(tareaPrueba));
    }

    @Test
    public void deleteTest() {
        when(tareasRepository.findById(1L)).thenReturn(Optional.of(tareaPrueba));
        tareasService.delete(1L);
        verify(tareasRepository,never()).findById(1L);
    }
}
