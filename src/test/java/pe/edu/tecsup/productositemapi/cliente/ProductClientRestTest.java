package pe.edu.tecsup.productositemapi.cliente;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.tecsup.productositemapi.models.Producto;

@SpringBootTest
public class ProductClientRestTest {
	
	private static final Logger logger 
		= LoggerFactory.getLogger(ProductClientRestTest.class);

	
	@Autowired
	ProductoClienteRest productoClienteRest;

	@Test
	public void consulta() {
		List<Producto> productos 
			= productoClienteRest.listar();
		logger.info(productos.toString());
		assertThat(productos.isEmpty(), is(false));
	}
	
	@Test
	public void findById() {
		Long id = 1L;
		Producto producto = productoClienteRest.detalle(id);
		logger.info(producto.toString());
		assertThat(producto,is(notNullValue()));
	}
}