package com.matrix.servicio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@ContextConfiguration
@ActiveProfiles("test")
@TestPropertySource("/application-test.properties")
class SerivicioMatrixApplicationTests {

	@Test
	void contextLoads() {
	}

}
