package app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.LineaPedido;
import modelo.Pedido;
import service.PedidosService;

public class Test {
	public static void main(String[] args) {

		List<LineaPedido> listaArticulos = new ArrayList<>();

		Pedido p1 = new Pedido();
		p1.setCliente("Albertito");
		LocalDate fechaEntrega = LocalDate.of(2002, 10, 28);
		p1.setFechaEntrega(fechaEntrega);
		LocalDate fechaPedido = LocalDate.of(2002, 1, 28);
		p1.setFechaPedido(fechaPedido);

		LineaPedido l1 = new LineaPedido();
		l1.setArticulo("Paracaidas");
		l1.setNumeroLinea(1);
		BigDecimal precioL1 = BigDecimal.valueOf(100);
		l1.setPrecio(precioL1);

		LineaPedido l2 = new LineaPedido();
		l2.setArticulo("Camnioneta de maracatones");
		l2.setNumeroLinea(2);
		BigDecimal precioL2 = BigDecimal.valueOf(500);
		l2.setPrecio(precioL2);

		listaArticulos.add(l1);
		listaArticulos.add(l2);

		p1.setListaPedido(listaArticulos);

		try {
			PedidosService pS = new PedidosService();
			pS.insertarPedido(p1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
