package com.nang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nang.common.DatabaseManager;
import com.nang.model.Patient;

public class PatientDao {
	
	
	public void savePatient(Patient p ) {
		try {
			Connection con=DatabaseManager.getConnection();
			String sql="insert into patient(pname,page,pgender,ptemp,paddress) values(?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getAge());
			pstmt.setString(3, p.getGender() );
			pstmt.setString(4, p.getTemperature());
			pstmt.setString(5, p.getAddress());
			pstmt.executeUpdate();
			 con.close();
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	public List<Patient> getPatientList(){
		List<Patient> ptdList=new ArrayList<Patient>();
		Connection con=DatabaseManager.getConnection();
		String sql="select * from patient";
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				Patient ptd=new Patient(Integer.parseInt(rs.getString("id")), rs.getString("pname"), rs.getString("page"),rs.getString("pgender"),rs.getString("ptemp"),rs.getString("paddress"));
				ptdList.add(ptd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ptdList;
	}


}
