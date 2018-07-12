package edu.csuft.xmei.spider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.google.gson.Gson;

/**
 * ��������������
 * @author xmei
 *
 */

public class App {
	public static void main(String[] args) {
		String url = "https://movie.douban.com/top250";
		List<Film> films = Collections.synchronizedList(new LinkedList<>());
		ExecutorService pool = Executors.newFixedThreadPool(4);
		pool.execute(new Spider(url, films));
		for (int i = 1; i < 10; i++) {
			url = String.format("https://movie.douban.com/top250?start=%d&filter=", 25 * i);
			pool.execute(new Spider(url, films));
		}
		pool.shutdown();
		while (true) {
			if (pool.isTerminated()) {
				writeData(films);
				break;
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		//�洢�����ݿ�
		//��������  ������ģʽ
		SqlSessionFactory factory = null;
		try {
			factory = new SqlSessionFactoryBuilder().build(
					new FileReader("config.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSession session = factory.openSession();
		
		// ����˽ӿڵľ���ʵ�֣����䣩
		FilmMapper mapper = session.getMapper(FilmMapper.class);
		for (Film f : films) 
		{
			mapper.insert(f);
		}
		session.commit();
		session.close();
		System.out.println("�洢�ɹ�");	
	}

	private static void writeData(List<Film> films) {
		System.out.println(films.size());
		Collections.sort(films);
		
		// for (Film film : films) {
		// System.out.println(film);
		// }
		
		String json = new Gson().toJson(films);
		try (FileWriter out = new FileWriter("250.json")) {
			out.write(json);
			System.out.println(" д JSON ���");
		} catch (Exception e) {
		}
		ExecutorService pool = Executors.newFixedThreadPool(8);
		for (Film film : films) {
			pool.execute(new ImgLoader(film));
		}
		pool.shutdown();
		while (true) {
			if (pool.isTerminated()) {
				break;
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}