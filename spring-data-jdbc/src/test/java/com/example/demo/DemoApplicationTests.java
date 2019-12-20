package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private MovieRepository movieRepository;
	@Test
	void contextLoad() {
		// one-to-one
		Movie movie = new Movie(null, "Matrix", "...",
				 new Movie.Rental(Duration.ofDays(10), 13));
		movieRepository.save(movie);
		System.out.println(movieRepository.findAll());
	}


	@Autowired
	private ShopOrderRepository shopOrderRepository;
	@Test
	void orderTest() {
		// one-to-many(set)
		Set<ShopOrder.LineItem>  lineItems = new HashSet<>();
		lineItems.add(new ShopOrder.LineItem(BigDecimal.valueOf(34), BigDecimal.valueOf(12.3)));
		lineItems.add(new ShopOrder.LineItem(BigDecimal.valueOf(24), BigDecimal.valueOf(2.3)));
		lineItems.add(new ShopOrder.LineItem(BigDecimal.valueOf(14), BigDecimal.valueOf(10.3)));
		ShopOrder shopOrder = new ShopOrder(null, "test", lineItems);

		shopOrderRepository.save(shopOrder);

		System.out.println(shopOrderRepository.findAll());
	}

	@Autowired
	private ShopOrderNumberedRepository shopOrderNumberedRepository;
	@Test
	void orderNumberedTest() {
		List<ShopOrderNumbered.LineItemNumbered> lineItems = new ArrayList<>();
		lineItems.add(new ShopOrderNumbered.LineItemNumbered(BigDecimal.valueOf(12.3), BigDecimal.valueOf(3.46)));
		ShopOrderNumbered shopOrderNumbered = new ShopOrderNumbered(null, "numbered", lineItems);
		shopOrderNumberedRepository.save(shopOrderNumbered);
		System.out.println(shopOrderNumberedRepository.findAll());

		shopOrderNumbered.removeLineItems();
		shopOrderNumberedRepository.save(shopOrderNumbered);
		System.out.println(shopOrderNumberedRepository.findAll());

	}

	@Autowired
	private ShopOrderKeyedRepository shopOrderKeyedRepository;
	@Test
	void orderKeyedTest() {
		Map<String, ShopOrderKeyed.LineItemKeyed> lineItems = new HashMap<>();
		lineItems.put("第一条", new ShopOrderKeyed.LineItemKeyed(BigDecimal.valueOf(23.23), BigDecimal.valueOf(14.44)));
		lineItems.put("第er条", new ShopOrderKeyed.LineItemKeyed(BigDecimal.valueOf(3.23), BigDecimal.valueOf(4.44)));
		ShopOrderKeyed shopOrderKeyed = new ShopOrderKeyed(null, "keyed 数据", lineItems);
		shopOrderKeyedRepository.save(shopOrderKeyed);
	}

	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;
	@Test
	void manyToManyTest() {
//		Author author = new Author();
//		author.setName("刘增胡");
//		author.setBirthDate(LocalDate.of(1990, 3, 23));
//		Author author1 = new Author();
//		author1.setName("李法增");
//		author1.setBirthDate(LocalDate.of(1987, 7,10));
//
//		authorRepository.save(author);
//		authorRepository.save(author1);
//
//		Book book = new Book();
//		book.setIsbn("TP312.8");
//		book.setTitle("Mybatis");
//		book.addAuthor(author);
//		book.addAuthor(author1);
//
//		bookRepository.save(book);

//		Author author2 = authorRepository.findById(1L).get();
//		System.out.println(author2);
//		Book book1 = new Book();
//		book1.setTitle("37度8");
//		book1.setIsbn("hello");
//		bookRepository.save(book1);
//		author2.addBook(book1);
//		//author2.addBook(book);
//		authorRepository.save(author2);


		Author author2 = authorRepository.findById(1L).get();
		System.out.println(author2);
		author2.getBooks().stream().map(BookRef::getId).forEach(
				id -> {
					System.out.println(bookRepository.findById(id));
				}
		);

	}

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Test
	void manyToOneTest() {
		Department department = new Department();
		department.setName("研发部");
		departmentRepository.save(department);
		System.out.println(department);

		Employee employee = new Employee();
		employee.setName("刘小东");
		employee.setDepartment(department);
		employeeRepository.save(employee);
		System.out.println(employee);
	}

}
