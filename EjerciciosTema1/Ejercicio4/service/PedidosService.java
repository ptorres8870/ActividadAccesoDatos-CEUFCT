package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.LineaPedidosDao;
import dao.PedidosDao;
import modelo.LineaPedido;
import modelo.Pedido;

public class PedidosService {
	OpenConnection openConn;

	public PedidosService() {
		openConn = new OpenConnection();
	}

	public void insertarPedido(Pedido pedido) throws PedidosServiceException {

		Connection conn = null;
		try {

			conn = openConn.getConection();
			conn.setAutoCommit(false);

			PedidosDao pedidosDao = new PedidosDao();
			LineaPedidosDao lineasPedidosDao = new LineaPedidosDao();

			Long idPedidoGenerado = pedidosDao.insertarPedido(conn, pedido);

			Integer numeroLinea = 1;
			for (LineaPedido pedido2 : pedido.getListaPedido()) {
				pedido2.setIdPedido(idPedidoGenerado);
				pedido2.setNumeroLinea(numeroLinea);
				lineasPedidosDao.insertarPedidosLineas(conn, pedido2);
				numeroLinea++;
			}
			conn.commit();

		} catch (SQLException e) {

			System.err.println("Ha habido un error en la base de datos : " + e.getMessage());

			try {
				conn.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

			throw new PedidosServiceException("Error al insertar pedidos en la bbdd", e);
		}

		finally {
			try {
				conn.close();
			} catch (Exception e) {
			}

		}

	}

}
