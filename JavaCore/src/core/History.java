/**
 * 
 */
package core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Core java programing
 * 
 * @author no_name
 *
 */
public class History {

	public static void main(String[] args) {
		String dd = "ssbdjs";
		while(dd.length() > 0){
			try {
				System.out.println("Welcome to personal account information!");
				System.out.println("\n"+"Enter a to quit!");
				System.out.println("\n");
				System.out.println("Enter account number: ");
				BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
				String sx = read.readLine();
				if(sx.equals("q")){
					System.exit(0);
				}else{
					try{
						Class.forName("com.mysql.jdbc.Driver");
					}catch(ClassNotFoundException e){
						System.err.println(e.getMessage());
					}
					
					try{
						String url = "jdbc:mysql://localhost:3306/demo?useSSL=true";
						String username = "root";
						String password = "admin";
						int account = Integer.parseInt(sx);
						String command = "select * from customers where id = " + account;
						Connection conn = DriverManager.getConnection(url, username, password);
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery(command);
						
						while(rs.next()){
							String s1 = rs.getString(2);
							String s2 = rs.getString(3);
							
							String data = "Firstname " + s1 + ", lastname " + s2;
							System.out.println(data);
							System.out.println("\n");
						}
					}catch(SQLException e){
						System.err.println(e.getMessage());
					}
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
