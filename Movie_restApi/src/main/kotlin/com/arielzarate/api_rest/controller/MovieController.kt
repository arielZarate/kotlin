package com.arielzarate.api_rest.controller

import com.arielzarate.api_rest.dto.MovieDTO
import com.arielzarate.api_rest.service.MovieService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/movie/")

//inyeccion de dependencias mediante interfaces
class MovieController(
    private val movieService: MovieService
) {


   @GetMapping("/all")
  fun getMovies():ResponseEntity<Any>{
      val movies=movieService.getMovies();
    return ResponseEntity.ok(movies);
  }

    @GetMapping("/{id}")
    fun getMovie(@PathVariable id:Long):ResponseEntity<Any>{
        val movieFound=movieService.getMovie(id);
        return ResponseEntity.ok(movieFound);
    }


    @PostMapping("/save")
   fun createMovie(@RequestBody movieDTO: MovieDTO):ResponseEntity<Any>{

     //  return try {
           val savedMovie = movieService.createMovie(movieDTO)
         return   ResponseEntity(savedMovie, HttpStatus.CREATED)
    /*
       } catch (e: IllegalArgumentException) {
           ResponseEntity(e.message, HttpStatus.BAD_REQUEST) // Mensaje claro para el cliente
       } catch (e: Exception) {
           ResponseEntity("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR)
       }
    * */
   }


    @PutMapping("/update/{id}")
    fun updateMovie(@RequestBody movieDTO: MovieDTO,@PathVariable id:Long):ResponseEntity<Any>{

        val updateMovie = movieService.updateMovie(movieDTO,id);
        return   ResponseEntity(updateMovie, HttpStatus.OK)

    }


    @DeleteMapping("/delete/{id}")
    fun updateMovie(@PathVariable id:Long):ResponseEntity<Any>{

        val updateMovie = movieService.deleteMovie(id);
        return   ResponseEntity(updateMovie, HttpStatus.NO_CONTENT)

    }

}