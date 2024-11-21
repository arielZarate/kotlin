package com.arielzarate.api_rest.dto

import com.arielzarate.api_rest.entity.Movie
import com.arielzarate.api_rest.common.Mapper
import org.springframework.stereotype.Component

//implementa la interface Mapper
@Component
class MovieMapper:Mapper<MovieDTO,Movie>{


    //de movie a dto
    override fun fromEntity(entity: Movie): MovieDTO {
        return MovieDTO(
            id=entity.id,
            name = entity.name,
            rating = entity.rating

        )
    }



    // de dto a movie
    override fun toEntity(dto: MovieDTO): Movie
    =  Movie(
            dto.id,
            dto.name,
            dto.rating
            )

}