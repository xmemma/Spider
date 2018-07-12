package edu.csuft.xmei.spider;

public class Film implements Comparable<Film> {
	/**
	 * 排名
	 */
	private int id; 
	
	/**
	 *片名
	 */
	private String title;
	
	/**
	 * 导演
	 */
	private String director;  
	
	/**
	 * 主演
	 */
	private String superstar; 
	
	/**
	 * 国家
	 */
	private String country; 
	
	/**
	 * 评分
	 */
	private double star;
	
	/**
	 *评价人数
	 */
	private int rating_num;
	
	/**
	 * 海报路径
	 */
	private String poster; 
	
	/**
	 * 概要
	 */
	private String quote;
	
	public Film() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDirctor() {
		return director;
	}
	
    public void setDirector(String director) {
		this.director=director;
	}

    public String getSuperstar() {
		return superstar;
	}

    public void setSuperstar(String superstar) {
    	this.superstar=superstar;
	}
    
    public String getCountry() {
		return country;
	}

    public void setCountry(String country) {
		this.country=country;
	}

    public double getStar() {
    	return star;
	}
    
    public void setStar(double star) {
		this.star=star;
	}
    
	public int getRating_num() {
	    return rating_num;
	}
	    
	 public void setRating_num(int rating_num) {
	    this.rating_num=rating_num;	
	} 

	 public String getPoster() {
		return poster;
	}

    public void setPoster(String poster) {
		this.poster = poster;
	}
		
	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", director=" + director + "superstar="
	+ superstar + ", country=" + country + ", star="  + star + ",rating_num =" + rating_num 
	+ ", poster=" +poster + ", quote=" + quote + "]";
	}

	public int compareTo(Film o) {
		return id - o.id;
	}
}