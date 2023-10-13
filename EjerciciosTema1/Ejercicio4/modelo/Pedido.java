package modelo;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

	private Long idPedido;
	private LocalDate fechaPedido;
	private LocalDate fechaEntrega;
	private String cliente;
	private List<LineaPedido> listaPedido;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega2) {
		this.fechaEntrega = fechaEntrega2;
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<LineaPedido> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(List<LineaPedido> listaPedido) {
		this.listaPedido = listaPedido;
	}

}
