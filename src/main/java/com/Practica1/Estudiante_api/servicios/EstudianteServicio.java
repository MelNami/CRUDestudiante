package com.Practica1.Estudiante_api.servicios;
import com.Practica1.Estudiante_api.dominio.Estudiante;
import com.Practica1.Estudiante_api.dto.EstudianteDTO;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class EstudianteServicio {

    private List<Estudiante> estudiantes = new ArrayList<>();
    private AtomicLong contadorId = new AtomicLong(1);

    public EstudianteServicio() {
        estudiantes.add(new Estudiante(contadorId.getAndIncrement(), "Juan Pérez", "juanp@example.com"));
        estudiantes.add(new Estudiante(contadorId.getAndIncrement(), "María García", "mariag@example.com"));
        estudiantes.add(new Estudiante(contadorId.getAndIncrement(), "Luis Rodríguez", "luisr@example.com"));
    }

    public Optional<Estudiante> obtenerPorId(Long id) {
        return estudiantes.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public Estudiante crearEstudiante(EstudianteDTO dto) {
        Estudiante nuevo = new Estudiante(contadorId.getAndIncrement(), dto.getNombre(), dto.getCorreo());
        estudiantes.add(nuevo);
        return nuevo;
    }

    public Optional<Estudiante> actualizarEstudiante(Long id, EstudianteDTO dto) {
        Optional<Estudiante> encontrado = obtenerPorId(id);
        if (encontrado.isPresent()) {
            Estudiante estudiante = encontrado.get();
            estudiante.setNombre(dto.getNombre());
            estudiante.setCorreo(dto.getCorreo());
            return Optional.of(estudiante);
        }
        return Optional.empty();
    }

    public boolean eliminarEstudiante(Long id) {
        return obtenerPorId(id).map(estudiantes::remove).orElse(false);
    }
}
