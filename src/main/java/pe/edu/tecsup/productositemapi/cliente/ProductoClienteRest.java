package pe.edu.tecsup.productositemapi.cliente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pe.edu.tecsup.productositemapi.config.FeignConfig;
import pe.edu.tecsup.productositemapi.models.Producto;

//@FeignClient(name = "productos-api"/*, url = "localhost:8080"*//*, fallback = ProductoClienteRestFallback.class*//*, fallbackFactory =  ProductoClienteRestFallbackFactory.class*/)
@FeignClient(name = "productos-api", url = "localhost:8080",configuration = FeignConfig.class)
//@FeignClient(name = "", url = "localhost:8080")
public interface ProductoClienteRest {

	@GetMapping("/productos")
	public List<Producto> listar();
	
	@GetMapping(value="/productos/id/{id}") /*, consumes = "application/json")*/
	public Producto detalle(@PathVariable Long id);
	
}
