package com.arielzarate.api_rest.dto


//dto una clase para pasar datos entre capas
//sin exponer la clase entidad que se encargara d ela persistencia
class MovieDTO (
   var id:Long?=null,
   var name:String,
    var rating:Double
    )