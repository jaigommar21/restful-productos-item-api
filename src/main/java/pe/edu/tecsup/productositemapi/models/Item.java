package pe.edu.tecsup.productositemapi.models;

public class Item {

	private Producto producto;
	
	private Integer cantidad;

	public Item() {
		super();
	}

	public Item(Producto producto, Integer cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getTotal() {
		if(this.producto != null && this.producto.getPrecio() != null && this.cantidad != null) {
			return this.producto.getPrecio() * this.cantidad.doubleValue();
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "Item [producto=" + producto + ", cantidad=" + cantidad + "]";
	}
	
}
