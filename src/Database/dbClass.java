package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.User;
public class dbClass {
	private String dburl="jdbc:mysql://localhost:3306/userdb";
	private String dbuname="root";
	private String dbpassword="mashrafi";
	private String dbdriver="com.mysql.jdbc.Driver";
	
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con=null;
		try {
			con=DriverManager.getConnection(dburl,dbuname,dbpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	public boolean update(User Old, User New) {
		loadDriver(dbdriver);
		Connection con=getConnection();
		String sql="update userdb.user set uname= ? where uname= ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,New.getUname());
			ps.setString(2,Old.getUname());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public ArrayList<String> select() {
		loadDriver(dbdriver);
		Connection con=getConnection();
		ArrayList<String> arr=new ArrayList<String>();
		String sql="select uname from userdb.user";
		ResultSet result=null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			result=ps.executeQuery();
			while (result.next()) {               // Position the cursor                  4 
				 arr.add(result.getString(1));        // Retrieve the first column value
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return arr;
		}
		
		return arr;
	}
	public boolean insert(User user) {
		loadDriver(dbdriver);
		Connection con=getConnection();
		String sql="insert into userdb.user values(?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,user.getUname());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean delete(User user) {
		loadDriver(dbdriver);
		Connection con=getConnection();
		String sql="delete from userdb.user where uname= ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,user.getUname());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
