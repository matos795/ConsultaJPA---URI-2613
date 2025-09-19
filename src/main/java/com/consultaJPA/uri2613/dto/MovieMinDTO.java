package com.consultaJPA.uri2613.dto;

import com.consultaJPA.uri2613.projections.MovieMinProjection;

public class MovieMinDTO {

    private Long id;
    private String name;
    
    public MovieMinDTO() {
    }

    public MovieMinDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public MovieMinDTO(MovieMinProjection projection) {
        id = projection.getId();
        name = projection.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MovieMinDTO [id=" + id + ", name=" + name + "]";
    }

    
}
