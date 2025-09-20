package dominio;

import java.math.BigDecimal;
import java.util.ArrayList;

import dao.*;
import entities.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Seguro> listSeguro = new ArrayList<Seguro>();
		DaoSeguro daoSeguro = new DaoSeguro();

		listSeguro = daoSeguro.findAll();

		for (Seguro seguro : listSeguro) {
			System.out.println("Id " + seguro.getId());
			System.out.println("Description: " + seguro.getDescription());
			System.out.println("Type" + seguro.getTypeSeguro().getDescription());
			System.out.println("Contracting Cost: " + seguro.getContractingCost());
			System.out.println("Unsurance Cost: " + seguro.getInsuranceCost());
			System.out.println();
		}

//		ArrayList<TypeSeguro> listType = new ArrayList<TypeSeguro>();
//		DaoTypeSeguro daoType = new DaoTypeSeguro();
//
//		listType = daoType.findAll();
//
//		for (TypeSeguro type : listType) {
//			System.out.println("ID " + type.getId()	);
//			System.out.println("descrption" + type.getDescription());
//			System.out.println();
//		}

	}

}
