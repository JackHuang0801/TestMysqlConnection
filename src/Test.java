import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws Exception {
		// 1.����������ʹ�÷���֪ʶ
		Class.forName("com.mysql.jdbc.Driver");
		try {
			// 2.ʹ��DriverManager��ȡ���ݿ����ӣ����з��ص�Connection�ʹ�����Java��������ݿ������
			// ��ͬ���ݿ��URLд����Ҫ�鿴�����ĵ����û�����������DBA����
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/MARS_DEV_MYSQL", "Jack_Huang", "123456");
			// 3.ʹ��Connection������һ��Statement����
			Statement stmt = conn.createStatement();
			// 4.ִ��SQL���
			// Statement������ִ��SQL���ķ���
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
