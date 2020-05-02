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
import com.nang.common.DatabaseManager;
import com.nang.dao.PatientDao;



/**
 * Servlet implementation class PatientServlet
 */
@WebServlet("/PatientServlet")
public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     PatientDao pdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientServlet() {
    	
        super();
        // TODO Auto-generated constructor stub
    } 
    public void init() {
    	 pdao= new PatientDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("pname");
		String age=request.getParameter("page");
		String gender=request.getParameter("pgender");
		String temp=request.getParameter("ptemp");
		String address= request.getParameter("paddress");
		Patient p=new Patient( 0,name,age,gender,temp, address);
		pdao.savePatient(p);
		List<Patient> pList = pdao.getPatientList();
		request.setAttribute("patientList",pList);
		RequestDispatcher rd=request.getRequestDispatcher("patient_list.jsp");
		
		rd.forward(request, response);
		  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
