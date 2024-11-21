package com.arielzarate.api_rest.service

import com.arielzarate.api_rest.common.MovieValidator
import com.arielzarate.api_rest.dto.MovieDTO
import com.arielzarate.api_rest.dto.MovieMapper
import com.arielzarate.api_rest.entity.Movie
import com.arielzarate.api_rest.exception.MovieException
import com.arielzarate.api_rest.repository.MovieRepository
import org.springframework.stereotype.Service
import java.util.Optional


@Service
class MovieServiceImpl(
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper,
    private val movieValidator :MovieValidator
):MovieService {


    override fun createMovie(movieDTO: MovieDTO):MovieDTO {

        //validateMovie(movieDTO)
        movieValidator.validate(movieDTO);  //este ya es un componente asignado para validar
        val movie=movieMapper.toEntity(movieDTO)
        movieRepository.save(movie);//guardo la entidad en persistencia

        return movieMapper.fromEntity(movie);
       // return movieDTO;
    }

    override fun getMovies(): List<MovieDTO> {
   /*

   //opcion 1
         val movieIterable= movieRepository.findAll()
        //movies son de tipo Movie
        val movies= movieIterable.map { movie->
            movieMapper.fromEntity(movie)
        }

      //ahora que tengo todos los movies dto en movie retorno
        return movies;
   * */


        //opcion 2

        val movies= movieRepository.getAllMovies();
        return  movies.map{m-> movieMapper.fromEntity(m)}
    }

    override fun getMovie(id: Long): MovieDTO {
       val movie = movieRepository.findById(id).orElseThrow{
           MovieException("La pelicula con el id $id no fue encontrada")
        }

        return movieMapper.fromEntity(movie)

    }

    override fun deleteMovie(id: Long) {
       val exist=movieRepository.existsById(id)
        if(!exist)
        {
            throw  MovieException("no se encuentra la movie con el id:$id")
        }
        movieRepository.deleteById(id);
      //  return "La movie fue eliminada con exito"
    }

    override fun updateMovie(movie: MovieDTO,id: Long):MovieDTO {

        val existingMovie = movieRepository.findById(id).orElseThrow {
            MovieException("La película con id $id no fue encontrada")
        }

        //existing movie es una movie no un  dto
        existingMovie.name=movie.name;
        existingMovie.rating=movie.rating;
       //lo guardo
       movieRepository.save(existingMovie)

       //ahora retorno pero con el mapper echo

       return movieMapper.fromEntity(existingMovie);

    }


    //=====================================================================
    // Función PRIVATE para validar los datos de entrada
    private fun validateMovie(movieDTO: MovieDTO) {
        if (movieDTO.id != null) throw IllegalArgumentException("El ID debe ser nulo al crear una nueva película")
        require(movieDTO.name.isNotBlank()) { "El nombre de la película no puede estar vacío" }
        require(movieDTO.rating in 0.0..10.0) { "El rating debe estar entre 0.0 y 10.0" }
    }
}