package Ejercicio1.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Ejercicio1.modelo.Pelicula;

public class PeliculaDao {
	public List<Pelicula> consultarPeliculas(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Pelicula> peliculas = new ArrayList<Pelicula>();
			String sql = "select * from actor";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pelicula a = new Pelicula();
				a.setId(rs.getInt("film_id"));
				a.setTitulo(rs.getString("title"));
				a.setLongitud(rs.getInt("length"));
				peliculas.add(a);
			}
			return peliculas;
		}
		finally {
			try {
				stmt.close();
			}catch(Exception e) {}
		}

	}
}
