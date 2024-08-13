package com.n1b3lung0.inventory;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryServiceApplicationTests {

	@ServiceConnection
	static PostgreSQLContainer<?> postgreSQLContainer;
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		postgreSQLContainer = new PostgreSQLContainer<>("postgres:16.3-alpine");
		postgreSQLContainer.start();
	}

	@Test
	void contextLoads() {
	}

	@Test
	void shouldReadInventory() {
		var response = RestAssured.given()
				.when()
				.get("/inventories?skuCode=iphone_15&quantity=1")
				.then()
				.log().all()
				.statusCode(200)
				.extract().response().as(Boolean.class);
		Assertions.assertTrue(response);

		var negativeResponse = RestAssured.given()
				.when()
				.get("/inventories?skuCode=iphone_15&quantity=1000")
				.then()
				.log().all()
				.statusCode(200)
				.extract().response().as(Boolean.class);
		Assertions.assertFalse(negativeResponse);

	}
}
