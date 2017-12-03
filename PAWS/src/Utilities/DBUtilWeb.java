package Utilities;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
 
public class DBUtilWeb{

        
        Connection conn = null;
        Session session= null;
        
        String host = "128.199.211.133";
        String servUser = "root";
        String servPwd = "pAws123321pawS";
        int port = 22;
        
        String rhost = "localhost";
        int rport = 3306;
        int lport = 3307;
 
        String driverName = "com.mysql.jdbc.Driver";
        String db2Url = "jdbc:mysql://localhost:" + lport + "/paws-web";
        String dbUsr = "root";
        String dbPwd = "";
         
        public DBUtilWeb()
        {
	        try {
	        	String boundaddress ="127.0.0.1";
	            JSch jsch = new JSch();
	            // Get SSH session
	            session = jsch.getSession(servUser, host, port);
	            session.setPassword(servPwd);
	            java.util.Properties config = new java.util.Properties();
	            // Never automatically add new host keys to the host file
	            config.put("StrictHostKeyChecking", "no");
	            session.setConfig(config);
	            // Connect to remote server
	            session.connect();
	            // Apply the port forwarding
	            if(session.getPortForwardingL()!=null)
	            {
	            	try
		            {
		            		session.setPortForwardingL(boundaddress, lport, rhost, rport);
		            }
		            catch(Exception e)
		            {
		            	
		            }
	            }
	            // Connect to remote database
	            Class.forName(driverName);
	            conn = (Connection) DriverManager.getConnection(db2Url, dbUsr, dbPwd);
	            System.out.println ("Connection to database established!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
       
	        	
        }
		
        public Connection getConnection(){
			if(conn != null) 
				System.out.println("Connection Established.");
			return this.conn;
        }
        
       public void cutPort()
       {
    	   try {
    		   if(session.getPortForwardingL()!=null)
    			   session.delPortForwardingL(lport);
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			
		}
       }
}





















/*package Utilities;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBUtilWeb 
{
	
	int lport = 6666;
	int rport = 3306;
	String rhost = "139.59.108.59";
	String host = "139.59.108.59";
	String user = "root";
	String password = "paws123123";
	String dbUser = "root";
	String dbPass = "paws123123";
	String schema = "paws-web";
	Connection conn = null;
	Session jschSession = null;
	public DBUtilWeb(){

	try {
		Properties config = new Properties();	
		config.put("StrictHostKeyChecking", "no");
	
		JSch jsch = new JSch();
		jschSession = jsch.getSession(user, host, 22);
		jschSession.setPassword(password);
		jschSession.setConfig(config);
		jschSession.connect();
		
		System.out.println("CONNECTED TO SSH");
		logger.info("Connected");

		int assigned_port = jschSession.setPortForwardingL(lport, rhost, rport);
		logger.info("localhost:" + assigned_port + " -> " + rhost + ":" + rport);
		logger.info("Port Forwarded");
	

		System.out.println("PORT FORWARDED");
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String url = "jdbc:mysql://localhost:" + lport + "/" + schema;
		conn = (Connection) DriverManager.getConnection(url, dbUser, dbPass);
	
		logger.info("Database connection established");
	
	
		Statement stmt = (Statement) conn.createStatement();
	
	
		String sql = "SELECT * FROM TEST_TABLE";
	
		ResultSet rs = stmt.executeQuery(sql);
	
	
		while(rs.next()) {
	
			logger.info(rs.getInt(1) + " " + rs.getString(2));

		}	


		rs.close();
	
		stmt.close();
	
	
		logger.info("DONE");
		} catch (Exception e) {
	
			e.printStackTrace();
		
			logger.error(e.getMessage());
		
			if (jschSession != null && jschSession.isConnected()) 
			{
				System.out.println("Closing SSH Connection during error");
				logger.error("Closing SSH Connection during error");
				jschSession.disconnect();
			}
	
	
		} 
		
		private static final String DB_URL = "jdbc:mysql://139.59.108.59:22/paws-web";
		private static final String USER = "root";
		private static final String PASS = "paws123123";
		private Connection conn = null;
		private Statement stmt = null;
		public DBUtilWeb(){
			try{
				System.out.println("Trying..");
				Class.forName("com.mysql.jdbc.Driver");
				this.conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
				this.stmt = (Statement) this.conn.createStatement();
			} catch (SQLException se){
				System.out.println("Wrong DB URL, USER, PASS");
			} catch (Exception e){
				System.out.println("JDBC Driver not properly set.");
			}
		}
		
		public Connection getConnection(){
			if(conn != null) System.out.println("Connection Established.");
			return this.conn;
		}
		
		public int getLastID(){
			return 3;
		}
		
	}		
	public Connection getConnection(){
		if(conn != null) System.out.println("Connection Established.");
		return this.conn;
	}
}*/