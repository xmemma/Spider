package edu.csuft.xmei.spider;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

// ×¢½â
public interface FilmMapper {
	@Insert("insert into films(id,title,director,superstar,country,star,rating_num,poster,quote) "
			+ "values(#{id},#{title},#{director},#{superstar},#{country},"
			+ "#{star},#{rating_num},#{poster},#{quote})")
	void insert(Film m);

	// ·´Éä£¨ºÚÄ§·¨£©
	@Select("select * from films where id=#{pk}")
	Film load(int pk);

	@Select("select * from films")
	List<Film> find();
}