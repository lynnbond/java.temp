package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {
    // 测试用，通过连接参数直连数据库
    public static Connection open(String driverName, String url, String user,
            String password) throws SQLException {
    	Connection conn = null;
    	try {
	        Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, password);
    	} catch (ClassNotFoundException cnfe) {
    		throw new SQLException("Can't find JDBC Driver Class!\n" + cnfe.toString());
    	} catch (SQLException sqle) {
    		conn = null;// SQL异常时把连接设为null，以便于jvm清理
    		throw sqle;
    	}
    	return conn;
    }
    
    public static void main(String[] args) throws Exception{
        // 测试用 begin
    	String url="jdbc:oracle:thin:@(description=(ADDRESS_LIST =(LOAD_BALANCE=OFF)(FAILOVER=ON)" +
    			"(ADDRESS = (PROTOCOL = TCP)(HOST = 10.11.210.165)(PORT = 1521))(ADDRESS = (PROTOCOL = TCP)(HOST = 10.11.202.8)" +
    			"(PORT = 1521)))(CONNECT_DATA =(SERVER = DEDICATED)(SERVICE_NAME = master)(failover_mode=(type=select)(method=basic))))";
    	String user="sys as SYSDBA";// db username
    	String password="lilylily";// db password
    	String driverName="oracle.jdbc.driver.OracleDriver";// oracle db driver
    	Connection	conn=ConnectionTest.open(driverName, url, user, password);

		
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		
		String sql="Select db_unique_name from v$database";
		
		ResultSet rs= stmt.executeQuery(sql);
		
		while (rs.next()){
			System.out.println(rs.getString(1));
		}
		
    }
}
