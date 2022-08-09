package com.primeiroProjetoSpringBoot.myfirstprojet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyfirstprojetApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyfirstprojetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 =new Category(1L, "Eletronics");
		Category cat2 =new Category(2l,"Books");
		Category cat3 =new Category(3l,"Books1");
		Category cat4 =new Category(4l,"Books2");
		Category cat5 =new Category(5l,"Books3");
		Category cat6 =new Category(6l,"Books4");
		
		categoryRepository.save(cat1);
		categoryRepository.save(cat2);
		categoryRepository.save(cat3);
		categoryRepository.save(cat4);
		categoryRepository.save(cat5);
		categoryRepository.save(cat6);

	}

}
