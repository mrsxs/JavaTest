package com.song.dao;

import java.util.List;

import com.song.entity.Movies;

public interface MovieDao {
  /**
   * 添加电影
   * 
   * @param movie
   */
  public int addMovie(Movies movie);

  /**
   * 删除电影
   * 
   * @param movieId
   */
  public int deleteMovie(int movieId);

  /**
   * 修改电影
   * 
   * @param movie
   */
  public int updateMovie(Movies movie);

  /**
   * 查询电影
   * 
   * @param movieId
   * @return
   */
  public Movies queryMovie(int movieId);

  /*
   * 查询所有电影
   */
  public List<Movies> queryAllMovie();

  /**
   * 判断电影是否存在
   */
  public boolean isExist(int movieId);

}
