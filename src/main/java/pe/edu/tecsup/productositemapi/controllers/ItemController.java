package pe.edu.tecsup.productositemapi.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.tecsup.productositemapi.models.Item;
import pe.edu.tecsup.productositemapi.services.ItemServiceFeign;

@RestController
public class ItemController {

	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	@Autowired	// Feign
	private ItemServiceFeign itemServiceFeign;	// Si se usa interface, habria dos tipos de itemService, se usa  @Qualifier para solucionar

	@GetMapping("/test")
	public String test() {
		logger.info("testing...!");
		return "test";
	}
	
		
	@GetMapping("/items")
	public List<Item> listar() {
			return itemServiceFeign.findAll();
	}
	
	@GetMapping("/items/{id}/cantidades/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemServiceFeign.findById(id, cantidad);
	}

	
}
