package com.consultaJPA.uri2613.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "prices")
public class Price {

    @Id
    private Long id;
    private String categorie;
    private Double value;

    @OneToMany(mappedBy = "price")
    private List<Movie> movies = new ArrayList<>();

    public Price() {
    }

    public Price(Long id, String categorie, Double value) {
        this.id = id;
        this.categorie = categorie;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "Price [id=" + id + ", categorie=" + categorie + ", value=" + value + ", movies=" + movies.size() + "]";
    }
    
}
