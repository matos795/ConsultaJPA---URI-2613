package com.consultaJPA.uri2613.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.consultaJPA.uri2613.dto.MovieMinDTO;
import com.consultaJPA.uri2613.entities.Movie;
import com.consultaJPA.uri2613.projections.MovieMinProjection;

public interface MovieRepository extends JpaRepository<Movie, Long>{

    @Query(nativeQuery = true, value = "SELECT movies.id, movies.name FROM movies " + //
                "INNER JOIN prices ON movies.id_prices = prices.id " + //
                "WHERE prices.value < :value")
    List<MovieMinProjection> search1(Double value);

    @Query("SELECT new com.consultaJPA.uri2613.dto.MovieMinDTO(obj.id, obj.name) FROM Movie obj WHERE obj.price.value < :value")
    List<MovieMinDTO> search2(Double value);
}
