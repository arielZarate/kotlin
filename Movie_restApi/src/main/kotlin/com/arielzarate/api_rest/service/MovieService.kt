package com.arielzarate.api_rest.service

import com.arielzarate.api_rest.dto.MovieDTO
import com.arielzarate.api_rest.entity.Movie


//esta interface sirve para poder implementar los servicios de movie
interface MovieService {


fun createMovie(movieDTO:MovieDTO): MovieDTO //crea una nueva movie

fun getMovies():List<MovieDTO>

fun getMovie(id:Long):MovieDTO

fun updateMovie(movie: MovieDTO,id:Long):MovieDTO

//fun deleteMovie(id:Long):String

fun deleteMovie(id:Long)

}