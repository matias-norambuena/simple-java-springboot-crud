package com.mycrud.tareas.repositories;

import com.mycrud.tareas.entities.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TareasRepository extends JpaRepository<Tareas, Long> {
}

