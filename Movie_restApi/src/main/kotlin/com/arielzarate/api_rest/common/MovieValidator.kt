package com.arielzarate.api_rest.common

import com.arielzarate.api_rest.dto.MovieDTO
import org.springframework.stereotype.Component


@Component
class MovieValidator {
    fun validate(movieDTO: MovieDTO) {
        require(movieDTO.id == null) { "El ID debe ser nulo al crear una nueva película" }
        require(movieDTO.name.isNotBlank()) { "El nombre de la película no puede estar vacío" }
        require(movieDTO.rating in 0.0..10.0) { "El rating debe estar entre 0.0 y 10.0" }
    }
}