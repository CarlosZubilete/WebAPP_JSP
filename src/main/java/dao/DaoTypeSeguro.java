package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.*;

public class DaoTypeSeguro {

	public TypeSeguro findOne(int id) {
		TypeSeguro type = null;
		String query = "Select * from tiposeguros where idTipo = ?";
		try (Connection conn = new Conexion().getConection()) {
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id );
			ResultSet resulSet = preparedStatement.executeQuery();
			if(resulSet.next()) {
				type = new TypeSeguro();
				type.setId(resulSet.getInt("idTipo"));
				type.setDescription(resulSet.getString("descripcion"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return type;
	}

	public ArrayList<TypeSeguro> findAll() {
		ArrayList<TypeSeguro> listTypeSeguro = new ArrayList<TypeSeguro>();
		String query = "Select * from tiposeguros";

		try (Connection conn = new Conexion().getConection()) {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

				TypeSeguro type = new TypeSeguro();
				type.setId(resultSet.getInt("idTipo"));
				type.setDescription(resultSet.getString("descripcion"));

				listTypeSeguro.add(type);
			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listTypeSeguro;
	}
}
