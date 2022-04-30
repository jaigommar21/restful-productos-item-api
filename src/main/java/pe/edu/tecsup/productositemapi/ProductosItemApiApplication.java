package pe.edu.tecsup.productositemapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class ProductosItemApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductosItemApiApplication.class, args);
	}

}
