package com.consultaJPA.uri2613;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.consultaJPA.uri2613.dto.MovieMinDTO;
import com.consultaJPA.uri2613.projections.MovieMinProjection;
import com.consultaJPA.uri2613.repositories.MovieRepository;

@SpringBootApplication
public class Uri2613Application implements CommandLineRunner{

	@Autowired
	private MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2613Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<MovieMinProjection> list1 = movieRepository.search1(2.0);
		List<MovieMinDTO> listDTO1 = list1.stream().map(x -> new MovieMinDTO(x)).collect(Collectors.toList());

		System.out.println("---------------- M O V I E S   F O U N D   S Q L ----------------");
		for (MovieMinDTO obj : listDTO1) {
			System.out.println(obj);
		}
		System.out.println("-----------------------------------------------------------------");

		List<MovieMinDTO> listDTO2 = movieRepository.search2(2.0);
		System.out.println("---------------- M O V I E S   F O U N D   J P Q L ----------------");
		for (MovieMinDTO obj : listDTO2) {
			System.out.println(obj);
		}
		System.out.println("-----------------------------------------------------------------");
 	}

}
