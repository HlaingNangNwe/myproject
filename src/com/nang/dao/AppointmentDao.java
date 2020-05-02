package com.nang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nang.common.DatabaseManager;
import com.nang.model.Appointment;

public class AppointmentDao {
	public void saveAppointment(Appointment a) {
		try {
			Connection con=DatabaseManager.getConnection();
			String sql="insert into appointment(date,time) values(?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, a.getDate());
			pstmt.setString(2, a.getTime());
			pstmt.executeUpdate();
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
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
