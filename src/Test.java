import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws Exception {
		// 1.加载驱动，使用反射知识
		Class.forName("com.mysql.jdbc.Driver");
		try {
			// 2.使用DriverManager获取数据库连接，其中返回的Connection就代表了Java程序和数据库的连接
			// 不同数据库的URL写法需要查看驱动文档，用户名、密码由DBA分配
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/MARS_DEV_MYSQL", "Jack_Huang", "123456");
			// 3.使用Connection来创建一个Statement对象
			Statement stmt = conn.createStatement();
			// 4.执行SQL语句
			// Statement有三种执行SQL语句的方法
			ResultSet rs = stmt.executeQuery("select PARAM_VAL "
					+ "from T_SYS_PARAM WHERE PARAM_ID='MAIN_HOST_ADDR' ");
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
