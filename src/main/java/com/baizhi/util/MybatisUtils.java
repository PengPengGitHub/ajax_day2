package com.baizhi.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

	private static SqlSessionFactory sqlSessionFactory;
	private static ThreadLocal<SqlSession> t = new ThreadLocal<SqlSession>();
	
	static{
		try {
			//��ȡ����
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			//����sqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//����sqlSession
	public static SqlSession getSqlSession(){
		//��ȡ��ǰ�߳���sqlSession
		SqlSession sqlSession = t.get();
		if(sqlSession==null){
			sqlSession = sqlSessionFactory.openSession();
			t.set(sqlSession);
		}
		return sqlSession;
	}
	
	
	//�ͷ�sqlSession
	public static void close(){
		SqlSession sqlSession = t.get();
		if(sqlSession!=null){
			sqlSession.close();
			t.remove();
		}
	}
	
	//�ύ����
	public static void commit(){
		getSqlSession().commit();//�ύ����  
		close();//�ر�sqlSession
	}
	
	//�ع�����
	public static void rollback(){
		getSqlSession().rollback();
		close();
	}
}
