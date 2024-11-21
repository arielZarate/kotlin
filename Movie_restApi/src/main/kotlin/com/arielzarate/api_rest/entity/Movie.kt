package com.arielzarate.api_rest.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "movie") //debo ponerlo sino hibernate no crea la tabla
data class Movie(


    //val porque son inmutables
    //var cuando cambiaran de nombre o algo
    //kotlin genera de forma automatica los @setter y @getter
    @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)

 val id: Long?=null,  //null para que jpa lo cree
    var name:String,
    var rating:Double

 )


//CLASES MAS LIMPIAS SIN TANTO CODIGO