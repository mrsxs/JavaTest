package com.song.test;

import com.song.dao.impl.MovieDaoimpl;
import com.song.entity.Movies;

/**
 * MovieTest
 * @author song
 */
public class MovieTest {

    public static void main(String[] args) {
        MovieDaoimpl movieDaoimpl = new MovieDaoimpl();
        Movies movie = new Movies( "电影名","导演",1,"主演","地区","2023:01:01 19:02:00","描述","图片",1.0);
      int i=  movieDaoimpl.addMovie(movie);
      if(i==0){
        System.out.println("添加失败");
      }else{
        System.out.println("添加成功");
      }
      
    }
}
