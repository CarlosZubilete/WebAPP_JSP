package servlet;

import java.io.IOException;
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

	// @see HttpServlet#HttpServlet()
	public ServletUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	// @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	// response)

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws ServletException, IOException {
		// listening file "Home.jsp"
		ArrayList<Seguro> list =  null;
		DaoSeguro daoseguro = new DaoSeguro();
		if (req.getParameter("paramhome") != null) {
			
			list = daoseguro.findAll();
			System.out.println("Entre PARAMHOME");
			req.setAttribute("list", list);
			RequestDispatcher requestDispatcher2 = req.getRequestDispatcher("/ListarSeguros.jsp");
			requestDispatcher2.forward(req, res);
		}
		
		
		ArrayList<TypeSeguro> listTypes = null;
		DaoTypeSeguro daoType = new DaoTypeSeguro();
		// 
		if(req.getParameter("param") != null) {
			listTypes = daoType.findAll(); 
			System.out.println("Entre PARAM");
			req.setAttribute("listTypes", listTypes);
			RequestDispatcher requestDispatcher2 = req.getRequestDispatcher("/AgregarSeguros.jsp");
			requestDispatcher2.forward(req, res);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	    throws ServletException, IOException {

		if(req.getParameter("btnSend") != null) {
			System.out.println("ENTRE POST");
			// todo: create a functions in daoSeguro.
		}
	
	}

}
