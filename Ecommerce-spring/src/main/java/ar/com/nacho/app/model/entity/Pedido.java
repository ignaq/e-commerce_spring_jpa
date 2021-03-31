package ar.com.nacho.app.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pedidos" )
public class Pedido	implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL , orphanRemoval = true)
	@JoinColumn(name = "pedido_id")
	private List<Item> items;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pedido")
	private Date fechaPedido;
	
	@PrePersist
	public void prePersist() {
		fechaPedido = new Date();
	}

	
	public Double getTotal() {
		Double total = 0.0;
		
		int size = items.size();
		
		for (int i=0; i < size; i++) {
			total += items.get(i).calcularImporte();
		}
		return total;
	}
	
	
	//iniciar array de item en constructor
	public Pedido() {
		this.items = new ArrayList<Item>();
	}
	
	//agregar items
	public void addItemPedido(Item item) {
		this.items.add(item);
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}



	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", items=" + items + ", fechaPedido=" + fechaPedido + "]";
	}























	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
}
