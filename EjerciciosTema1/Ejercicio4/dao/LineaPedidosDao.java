package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.LineaPedido;

public class LineaPedidosDao {
	public void insertarPedidosLineas(Connection conn, LineaPedido lineaPedido) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(
					"insert into pedidos_lineas (id_Pedido, numero_linea, articulo, precio) values (?,?,?,?)");
			stmt.setLong(1, lineaPedido.getIdPedido());
			stmt.setInt(2, lineaPedido.getNumeroLinea());
			stmt.setString(3, lineaPedido.getArticulo());
			stmt.setBigDecimal(4, lineaPedido.getPrecio());

			stmt.execute();
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}
}
