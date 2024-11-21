package com.arielzarate.api_rest.repository

import com.arielzarate.api_rest.dto.MovieDTO
import com.arielzarate.api_rest.entity.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository

//aca usamos la potencia de springDataJpa para extender de su interface y usar sus metodos
interface MovieRepository :JpaRepository<Movie,Long> {


//creare un metodo opcinal para devolver una lista de movies
    @Query("SELECT m FROM Movie as m")
    fun getAllMovies(): List<Movie>

}

