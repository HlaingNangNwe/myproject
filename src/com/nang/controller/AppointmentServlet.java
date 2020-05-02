package com.nang.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import com.nang.model.Appointment;
import com.nang.model.Clinic;
import com.nang.model.Patient;
import com.nang.common.DatabaseManager;
import com.nang.dao.PatientDao;
import com.nang.dao.ClinicDao;



/**
 * Servlet implementation class AppointmentServlet
 */
@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PatientDao pdao;
	ClinicDao cdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentServlet() {
    	
       super();
        
        // TODO Auto-generated constructor stub
    }
    public void init() {
   	 		pdao= new PatientDao();
   	 		cdao=new ClinicDao();
   }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {
			 //String date=request.getParameter("date");
			  //String time= request.getParameter("time");
			  //saveAppointment(date,time);
			 
			  List<Patient> patientList=pdao.getPatientList();
			  request.setAttribute("patientList",patientList);
			  List<Clinic> cList = cdao.getClinicList();
				request.setAttribute("cList",cList);
			  RequestDispatcher rd=request.getRequestDispatcher("appointment.jsp");
			  rd.forward(request, response);
	            
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new ServletException(e);
	        }
	}
	public void saveAppointment(String date,String time) {
		try {
			Connection con=DatabaseManager.getConnection();
			String sql="insert into appointment(date,time) values(?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, date);
			pstmt.setString(2, time);
			pstmt.executeUpdate();
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public List<Appointment> getAppointmentList(){
		List<Appointment> aList=new ArrayList<Appointment>();
		try {
			Connection con=DatabaseManager.getConnection();
			String  sql="select * from appointment";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Appointment a=new Appointment(Integer.parseInt(rs.getString("id")),Integer.parseInt(rs.getString("id")),Integer.parseInt(rs.getString("id")), Integer.parseInt(rs.getString("id")), rs.getString("date"), rs.getString("time"));
				aList.add(a);
			}
			
		}catch(Exception e) {
			
		}
		return aList;
	}

}
