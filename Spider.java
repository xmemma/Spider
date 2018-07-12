package edu.csuft.xmei.spider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 爬虫
 * @author xmei
 *
 */

public class Spider implements Runnable {
	/**
	 * 目标页面
	 */
	private String url;
	
	/**
	 * 存储所有影片的列表
	 */
	private List<Film> films;

	/**
	 * 爬虫的构造方法
	 * @param url 目标页面
	 */
	public Spider(String url, List<Film> films) {
		this.url = url;
		this.films = films;
	}

	/**
	 * 执行
	 */
	public void run() {
		//抓取数据
		try {
			Document doc = Jsoup.connect(url).timeout(10000).get();
			Elements elms = doc.select(".grid_view .item");

			//遍历
			for (Element e : elms) {
				Film film = new Film();   
				String id = e.select(".pic em").first().text();   
				String poster = e.select(".pic img").get(0).attr("src");  
				String title = e.select(".title").get(0).text();       
				String quote = e.select(".quote .inq").text();   
				String info = e.select(".bd p").first().text();        
				String a[] = info.split("/"); 
				String b[] = info.split(":");  
				String c[] = info.split(" ");  
				String director = (String) b[1].subSequence(0, b[1].length()-2);  
				String rating_num = e.select(".star span").last().text();    
				String star = e.select(".star .rating_num").first().text();    
				String release_date = (a[a.length - 3].substring(a[a.length-3].length()-5,
						a[a.length-3].length()-1)); 
		
				film.setId(Integer.parseInt(id));                         
				film.setTitle(title);                                    
				film.setPoster(poster);                                  
				try {film.setQuote(quote); }catch (Exception t) {}       
				film.setDirector(director);                              
				film.setRating_num(Integer.parseInt(rating_num.substring(0, rating_num.length()-3))); 
				film.setStar(Double.parseDouble(star));                  
				if(c[6].length() < 2 )
					film.setSuperstar(c[7].replace(".", ""));
				else
					film.setSuperstar(c[6].replace(".", ""));            
				film.setCountry(a[a.length-2]);                           
				System.out.println(film);
				films.add(film);
				//System.out.println(Thread.currentThread().getName() + " download " + id);
			}
			System.out.println(Thread.currentThread() + " over");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}