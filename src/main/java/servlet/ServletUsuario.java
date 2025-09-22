package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import entities.*;
// Servlet implementation class ServletUsuario

@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoTypeSeguro daoType = new DaoTypeSeguro();
	private DaoSeguro daoSeguro = new DaoSeguro();

	// @see HttpServlet#HttpServlet()
	public ServletUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	// This function will get all type of Seguros...
	private ArrayList<TypeSeguro> uploadTypeSeguro() {
		ArrayList<TypeSeguro> listTypes = null;
		DaoTypeSeguro daoType = new DaoTypeSeguro();
		listTypes = daoType.findAll();
		return listTypes;
	}

	private Boolean builtSeguroAndAdd(String description, int idType, double contratringCost,
	    double maxInsuredCost) {
		// Built...
		TypeSeguro typeSeguro = new TypeSeguro();
		Seguro seguro = new Seguro();
		typeSeguro = daoType.findOne(idType);
		seguro.setDescription(description);
		seguro.setTypeSeguro(typeSeguro);
		seguro.setContractingCost(new BigDecimal(contratringCost));
		seguro.setInsuranceCost(new BigDecimal(maxInsuredCost));

		System.out.println("BuiltSefuro: " + seguro);
		System.out.println();
		return daoSeguro.addOne(seguro);
		
	}

	// @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	// response)
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws ServletException, IOException {
		// listening file "Home.jsp"
		ArrayList<Seguro> list = null;
		DaoSeguro daoseguro = new DaoSeguro();
		if (req.getParameter("paramhome") != null) {

			list = daoseguro.findAll();
			System.out.println("Entre PARAMHOME");
			req.setAttribute("list", list);
			RequestDispatcher requestDispatcher2 = req.getRequestDispatcher("/ListarSeguros.jsp");
			requestDispatcher2.forward(req, res);
		}

		ArrayList<TypeSeguro> listTypes = null;

		if (req.getParameter("param") != null) {
			// listTypes = daoType.findAll();
			System.out.println("Entre PARAM");
			listTypes = this.uploadTypeSeguro();
			req.setAttribute("listTypes", listTypes);
			RequestDispatcher requestDispatcher2 = req.getRequestDispatcher("/AgregarSeguros.jsp");
			requestDispatcher2.forward(req, res);

		}
	}

	// @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	// response)

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	    throws ServletException, IOException {

		ArrayList<TypeSeguro> listTypes = null;

		if (req.getParameter("btnSend") != null) {
			// todo: create a functions in daoSeguro.
			String description = req.getParameter("description");
			int typeSeguro = Integer.parseInt(req.getParameter("typeSeguro"));
			double contratringCost = Double.parseDouble(req.getParameter("contratringCost"));
			double maxInsuredCost = Double.parseDouble(req.getParameter("maxInsuredCost"));
			System.out.println("ENTRE POST");

			if (typeSeguro == -1) {
				String message = "Error: La descripción es obligatoria";
				req.setAttribute("message", message);
			} else {
				// ADD TO THE DATABASE..
				Boolean isAdded = this.builtSeguroAndAdd(description, typeSeguro, contratringCost,
				    maxInsuredCost);
				String message = "";

				if (isAdded)
					message = "Se ha agrega con exito.";
				else
					message = "Erro: No se ah agregado con exito.";

				req.setAttribute("message", message);

			}
			// We have to send the collection typesSeguro...
			listTypes = this.uploadTypeSeguro();
			req.setAttribute("listTypes", listTypes);
			req.getRequestDispatcher("/AgregarSeguros.jsp").forward(req, res);
		}

	}

}
