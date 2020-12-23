package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class MyDBconnection {
	private Connection con = null;
	private PreparedStatement pstmt = null;

	public void setPstmt(String sql) throws SQLException {
		pstmt = con.prepareStatement(sql);
		System.out.println("设置预处理sql!");
	}

	public PreparedStatement getPstmt() {
		return pstmt;
	}

	public Connection getCon() {
		return con;
	}

	public MyDBconnection(String Driver, String Url, String User, String Password) throws Exception {
		Class.forName(Driver);// 动态加载Mysql驱动
		con = DriverManager.getConnection(Url, User, Password);
		System.out.println("succses");
	}

	public String toString() {
		return "已连接数据库并创立预处理对象";
	}

}

class DBPreparedOperation {
	private MyDBconnection my = null;

	private Connection con = null;
	private PreparedStatement pstmt = null;

	public DBPreparedOperation(MyDBconnection my) {
		con = my.getCon();
		pstmt = my.getPstmt(); // IMPORTANT 俩个类的参数同步
	}

	/**
	 * String sno; String sname; String ssex; int age; String sdept; String class;
	 * 
	 * @throws SQLException
	 * 
	 **/

	public void insert(String sno, String sname, String ssex, int age, String sdept, String sclass)
			throws SQLException {
		String sql = "insert into course (sno,sno,ssex,age,sdept,sclass)  values (?,?,?,?,?,?)";// ?表示占位符
		pstmt = con.prepareStatement(sql); // 实例化预处理对象
		pstmt.setString(1, sno);
		pstmt.setString(2, sname);
		pstmt.setString(3, ssex);
		pstmt.setInt(4, age);
		pstmt.setString(5, sdept);
		pstmt.setString(6, sclass);
		pstmt.executeUpdate(); // 执行预处理对象不需要sql语句
		pstmt.close();
		System.out.println("插入完成");
	}

	public void delet(String id) throws SQLException {
		String sql = "delet  from course where id = '?'";
		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		pstmt.setString(1, id);
		System.out.println("删除操作里面的pstmt" + pstmt);
		while (rs.next()) {
			rs.deleteRow();
		}
		rs.close();
		pstmt.close();
	}

	public void updata(String sname) throws SQLException {
		String sql = "select sno,sname,ssex,age,sdept,sclass from student where sname='?'";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, sname);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			// rs.updateInt(columnIndex, x);
			// rs.updateRow();
		}
	}

	public void select() throws SQLException {
		String sql = "select * from student";
		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.last();// 执行最后一条语句，first执行第一条语句;
		int rows = rs.getRow(); // 获得结果集的行数目
		System.out.println("共用" + rows + "行");
		for (int i = 1; i <= rows; i++) {
			rs.absolute(i);// 强制定位到第i条记录
			System.out.println("学号：" + rs.getString(1));// 获得第一列的数据
			System.out.println("姓名：" + rs.getString(2));
			System.out.println("性别：" + rs.getString(3));
			System.out.println("年龄：" + rs.getInt(4));
			System.out.println("专业：" + rs.getString(5));
			System.out.println("班级：" + rs.getString(6));
		}
		rs.close();
		pstmt.close();
	}

}

public class PrepareStatementDemo {
	public static void main(String[] args) throws Exception {
		String Driver = "com.mysql.jdbc.Driver";
		String Url = "jdbc:mysql://localhost:3306/t";
		String User = "root";
		String Password = "123456";
		MyDBconnection my = new MyDBconnection(Driver, Url, User, Password);
		DBPreparedOperation myopr = new DBPreparedOperation(my);

		// myopr.insert("2018", "利好", "男", 20, "数学", "1班");
		// myopr.delet("20164234");
		myopr.select();
	}

}
