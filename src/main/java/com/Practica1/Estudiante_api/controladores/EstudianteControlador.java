package com.Practica1.Estudiante_api.controladores;
import com.Practica1.Estudiante_api.dominio.Estudiante;
import com.Practica1.Estudiante_api.dto.EstudianteDTO;
import com.Practica1.Estudiante_api.servicios.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControlador {

    @Autowired
    private EstudianteServicio servicio;

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiante(@PathVariable Long id) {
        Optional<Estudiante> estudiante = servicio.obtenerPorId(id);
        return estudiante.map(valor -> new ResponseEntity<>(valor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody EstudianteDTO dto) {
        Estudiante creado = servicio.crearEstudiante(dto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @RequestBody EstudianteDTO dto) {
        Optional<Estudiante> actualizado = servicio.actualizarEstudiante(id, dto);
        return actualizado.map(est -> new ResponseEntity<>(est, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        boolean eliminado = servicio.eliminarEstudiante(id);
        return eliminado ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}