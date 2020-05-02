package com.nang.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nang.model.Clinic;
import com.nang.model.Patient;
import com.nang.dao.ClinicDao;
import com.nang.dao.PatientDao;
import com.nang.common.DatabaseManager;


/**
 * Servlet implementation class ClinicServlet
 */
@WebServlet("/ClinicServlet")
public class ClinicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ClinicDao cdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClinicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
   	 cdao= new ClinicDao();
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    String cname=request.getParameter("cname");
		String caddress= request.getParameter("caddress");
		Clinic c=new Clinic(0, cname, caddress);
		cdao.saveClinic(c);
		List<Clinic> cList = cdao.getClinicList();
		request.setAttribute("cList",cList);
		RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
