package com.nang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nang.common.DatabaseManager;
import com.nang.model.Clinic;

public class ClinicDao {
	public void saveClinic(Clinic c) {
		try {
			Connection con=DatabaseManager.getConnection();
			String sql="insert into clinic(cname,caddress) values(?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,c.getCname());
			pstmt.setString(2,c.getCaddress() );
			pstmt.executeUpdate();
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public	List<Clinic> getClinicList(){
			List<Clinic> ctdList=new ArrayList<Clinic>();
			Connection con=DatabaseManager.getConnection();
			String sql="select * from clinic";
			Statement stmt;
			try {
				stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				
				while(rs.next()) {
					Clinic ctd=new Clinic(Integer.parseInt(rs.getString("id")), rs.getString("cname"), rs.getString("caddress"));
					ctdList.add(ctd);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return ctdList;
			
		}
}
