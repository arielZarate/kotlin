package com.arielzarate.api_rest.common


interface Mapper<D,E> {

    //interface simple para poder ser implementada

    fun fromEntity(entity:E):D
    fun toEntity(domain:D):E
}