package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.*;

public class DaoSeguro {

	public DaoSeguro() {
	}

	public ArrayList<Seguro> findAll() {
		ArrayList<Seguro> listSeguro = new ArrayList<Seguro>();
		String query = "SELECT * FROM seguros";

		try (Connection conn = new Conexion().getConection()) {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Seguro seguro = new Seguro();
				seguro.setId(resultSet.getInt("idSeguro"));
				seguro.setDescription(resultSet.getString("descripcion"));
				// 
				int idTypeSeguro = resultSet.getInt("idTipo");
				TypeSeguro typeSeguro = new TypeSeguro();
				DaoTypeSeguro daoType = new DaoTypeSeguro();
				// typeSeguro.setId(resultSet.getInt("idTipo"));
				typeSeguro = daoType.findOne(idTypeSeguro);
				seguro.setTypeSeguro(typeSeguro);
				//
				seguro.setContractingCost(resultSet.getBigDecimal("costoContratacion"));
				seguro.setInsuranceCost(resultSet.getBigDecimal("costoAsegurado"));

				listSeguro.add(seguro);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listSeguro;
	}

}
