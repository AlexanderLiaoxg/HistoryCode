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
		System.out.println("����Ԥ����sql!");
	}

	public PreparedStatement getPstmt() {
		return pstmt;
	}

	public Connection getCon() {
		return con;
	}

	public MyDBconnection(String Driver, String Url, String User, String Password) throws Exception {
		Class.forName(Driver);// ��̬����Mysql����
		con = DriverManager.getConnection(Url, User, Password);
		System.out.println("succses");
	}

	public String toString() {
		return "���������ݿⲢ����Ԥ�������";
	}

}

class DBPreparedOperation {
	private MyDBconnection my = null;

	private Connection con = null;
	private PreparedStatement pstmt = null;

	public DBPreparedOperation(MyDBconnection my) {
		con = my.getCon();
		pstmt = my.getPstmt(); // IMPORTANT ������Ĳ���ͬ��
	}

	/**
	 * String sno; String sname; String ssex; int age; String sdept; String class;
	 * 
	 * @throws SQLException
	 * 
	 **/

	public void insert(String sno, String sname, String ssex, int age, String sdept, String sclass)
			throws SQLException {
		String sql = "insert into course (sno,sno,ssex,age,sdept,sclass)  values (?,?,?,?,?,?)";// ?��ʾռλ��
		pstmt = con.prepareStatement(sql); // ʵ����Ԥ�������
		pstmt.setString(1, sno);
		pstmt.setString(2, sname);
		pstmt.setString(3, ssex);
		pstmt.setInt(4, age);
		pstmt.setString(5, sdept);
		pstmt.setString(6, sclass);
		pstmt.executeUpdate(); // ִ��Ԥ���������Ҫsql���
		pstmt.close();
		System.out.println("�������");
	}

	public void delet(String id) throws SQLException {
		String sql = "delet  from course where id = '?'";
		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		pstmt.setString(1, id);
		System.out.println("ɾ�����������pstmt" + pstmt);
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
		rs.last();// ִ�����һ����䣬firstִ�е�һ�����;
		int rows = rs.getRow(); // ��ý����������Ŀ
		System.out.println("����" + rows + "��");
		for (int i = 1; i <= rows; i++) {
			rs.absolute(i);// ǿ�ƶ�λ����i����¼
			System.out.println("ѧ�ţ�" + rs.getString(1));// ��õ�һ�е�����
			System.out.println("������" + rs.getString(2));
			System.out.println("�Ա�" + rs.getString(3));
			System.out.println("���䣺" + rs.getInt(4));
			System.out.println("רҵ��" + rs.getString(5));
			System.out.println("�༶��" + rs.getString(6));
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

		// myopr.insert("2018", "����", "��", 20, "��ѧ", "1��");
		// myopr.delet("20164234");
		myopr.select();
	}

}
