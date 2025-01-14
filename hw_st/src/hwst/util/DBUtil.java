package hwst.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * 
 * @author gusdn
 * 사용을 피하라
 *
 */
@Deprecated
public class DBUtil {
	private static SqlSessionFactory factory = null;

	static {
		InputStream inputStream = null;
		try {
			inputStream = Resources
					.getResourceAsStream("hwst/conf/SqlMapConfig.xml");//실제 db용
					//.getResourceAsStream("hwst/service/config/SqlMapConfig.xml");//test db용
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					
					inputStream.close();
					inputStream = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static SqlSession getSqlSession() {
		return factory.openSession(true);//true- Auto_Commit
	}

	public static void closeSqlSession(SqlSession session) {
		if (session != null) {
			session.close();
		}
	}

	public static void closeSqlSession(boolean commit, SqlSession session) {
		if (session != null) {
			if (commit){
				session.commit();
			}else{
				session.rollback();
			}
			session.close();
		}
	}
}