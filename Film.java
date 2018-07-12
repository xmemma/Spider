package edu.csuft.xmei.spider;

public class Film implements Comparable<Film> {
	/**
	 * ����
	 */
	private int id; 
	
	/**
	 *Ƭ��
	 */
	private String title;
	
	/**
	 * ����
	 */
	private String director;  
	
	/**
	 * ����
	 */
	private String superstar; 
	
	/**
	 * ����
	 */
	private String country; 
	
	/**
	 * ����
	 */
	private double star;
	
	/**
	 *��������
	 */
	private int rating_num;
	
	/**
	 * ����·��
	 */
	private String poster; 
	
	/**
	 * ��Ҫ
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