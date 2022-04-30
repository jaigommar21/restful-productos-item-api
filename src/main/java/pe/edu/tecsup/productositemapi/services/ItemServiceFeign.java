package pe.edu.tecsup.productositemapi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.productositemapi.cliente.ProductoClienteRest;
import pe.edu.tecsup.productositemapi.models.Item;
import pe.edu.tecsup.productositemapi.models.Producto;

@Service
public class ItemServiceFeign {

	@Autowired
	private ProductoClienteRest productoClienteRest;
	
	public List<Item> findAll() {
		
		List<Producto> productos = productoClienteRest.listar();
		
		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}
	
	public Item findById(Long id, Integer cantidad) {
		
		Producto producto = productoClienteRest.detalle(id);
		
		return new Item(producto, cantidad);
	}
	
}
