package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDemo {
	public static void main(String[] args) throws Exception {
		// String Driver="org.mm.mysql.Driver";
		String Driver = "com.mysql.jdbc.Driver";
		String Url = "jdbc:mysql://localhost:3306/t";
		String User = "root";
		String Password = "123456";
		Class.forName(Driver);// 动态加载Mysql驱动
		ConnectionDemo d = new ConnectionDemo();
		Statement stmt = d.SQLTO(Url, User, Password);
		d.select(stmt);
		String sql = "insert into student (sno,sname,ssex,sage,sdept,class) values ('20164234','王明明','男',20,'美术','4')";
		d.insert(stmt, sql);
	}

	public Statement SQLTO(String Url, String User, String password) throws SQLException {
		Connection con = null;
		con = DriverManager.getConnection(Url, User, password);
		System.out.println("connect sucess!");
		Statement stmt = con.createStatement();
		return stmt;
	}

	public void select(Statement stmt) throws SQLException {
		String sql = "select * from student";
		ResultSet rs = stmt.executeQuery(sql);
		int colCount = rs.getMetaData().getColumnCount();// 获得列数
		while (rs.next()) {
			for (int i = 1; i <= colCount; i++) {
				System.out.println(rs.getString(i) + "t");
			}
		}
	}

	public void insert(Statement stmt, String sql) {
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(Statement stmt, String sql) {
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updata(Statement stmt, String sql) {
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeAll(Statement stmt, String sql) throws SQLException {
		ResultSet rs = stmt.executeQuery(sql);
		if (rs != null)
			rs.close();
	}
}
