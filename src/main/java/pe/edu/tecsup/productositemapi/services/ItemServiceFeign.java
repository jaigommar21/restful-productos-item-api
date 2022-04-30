package pe.edu.tecsup.productositemapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.productositemapi.clients.ProductoClienteRest;
import pe.edu.tecsup.productositemapi.models.Item;
import pe.edu.tecsup.productositemapi.models.Producto;

@Service
public class ItemServiceFeign {

	@Autowired
	private ProductoClienteRest productoClienteRest;
	
	public List<Item> findAll() {
		
		List<Producto> productos = productoClienteRest.listar();
		
		List<Item> items = new ArrayList<Item>();
		for( Producto prod : productos )
			items.add(new Item(prod,1));
		
		return items;	

		//return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}
	
	public Item findById(Long id, Integer cantidad) {
		
		Producto producto = productoClienteRest.detalle(id);
		
		return new Item(producto, cantidad);
	}
	
}
