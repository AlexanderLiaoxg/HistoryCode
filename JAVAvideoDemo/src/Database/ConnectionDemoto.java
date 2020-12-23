package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//class MysqlOperate {
//	public MysqlOperate(String Driver, String Url, String User, String Password) {
//		try {
//			Connection con = DriverManager.getConnection(Url, User, Password);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

public class ConnectionDemoto {
	public static void main(String[] args) throws Exception {
		// String Driver="org.mm.mysql.Driver";
		String Driver = "com.mysql.jdbc.Driver";
		String Url = "jdbc:mysql://localhost:3306/phpsystem";
		String User = "root";
		String Password = "123456";
		Connection con = null;

		Class.forName(Driver);// 动态加载Mysql驱动
		con = DriverManager.getConnection(Url, User, Password);
		System.out.println("connect sucess!");
		java.sql.Statement stmt = con.createStatement();
		DBOperation d = new DBOperation(con);
		d.selectAlldata(con);

	}
}

class DBOperation {
	Connection con;

	public DBOperation(Connection con) {
		super();
		this.con = con;
	}

	public void selectAlldata(Connection con) {
		// String sql = "select * from student2";
		// String sql = "select sno,sname from student2 where sname = '廖六'";
		// String sql = "select sno,sname,avg(grade) from student2 where sname = '李明明'";
		// String sql = "select * from student2 where sex = '男'";
		String sql = "select * from student2 where grade>60";

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql); // 执行sql语句后的结果集
			while (rs.next()) {
				System.out.println(stmt.executeUpdate(sql));
				String sno = rs.getString("sno"); // 查找名字为sno的列
				String sname = rs.getString(2);// 第2列
				// String average = rs.getString(3);
				String classno = rs.getString(3);
				String sex = rs.getString(4);
				String grade = rs.getString(5);
				System.out.println("学号：" + sno + " 姓名：" + sname + "课程名：" + classno + " 性别：" + sex + " 成绩：" + grade);
				// System.out.println("学号：" + sno + " 姓名：" + sname + "平均成绩" + average);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
