package com.example.demo;

import com.example.demo.model.Pet;
import com.example.demo.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;

@SpringBootApplication
@EnableJdbcRepositories
public class DemoApplication {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}


	@Bean
	ApplicationRunner applicationRunner(PetRepository petRepository) {
		return args -> {
			// simple entity
//			Pet pet = Pet.of("欣欣", LocalDate.of(2017, 5,13), Pet.type.TWO);
//			petRepository.save(pet);
			System.out.println(petRepository.findByName("欣欣"));  // todo this actually works, "TWO" => Pet.type.Two





//			Pet pet1 = Pet.create("Zuk", LocalDate.of(2014, 5, 13));
//			Pet pet2 = Pet.create("Hilly", LocalDate.of(2016, 1, 3));
//			Pet pet = new Pet(1L, "hello", LocalDate.of(2019, 9, 23));
//			System.out.println(petRepository.save(pet));
//			//System.out.println(petRepository.save(pet2));
//			System.out.println(petRepository.findByName("Hilly"));
//			//System.out.println(petRepository.findAll(Sort.by("name")));
//			Author author = new Author();
//			author.name = "Greg L. Turnquist";
//			authorRepositroy.save(author);
//
//			Book book = new Book();
//			book.title = "Spring boot";
//			book.addAuthor(author);
//
//			bookRepository.save(book);




		};
	}

}
