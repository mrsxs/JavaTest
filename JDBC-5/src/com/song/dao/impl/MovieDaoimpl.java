package com.song.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.song.dao.MovieDao;
import com.song.entity.Movies;

public class MovieDaoimpl extends BaseDao implements MovieDao {

    /**
     * 添加电影
     *
     * @param movie
     * @return
     */
    @Override
    public int addMovie(Movies movie) {
        int count = 0;
        try {
            super.getConnection();
            String sql = "insert into movies(MovieName,director,typeId,stardom,region,showtime,description,image,price) values(?,?,?,?,?,?,?,?,?)";
            Object[] parames = {movie.getMovieName(), movie.getDirector(), movie.getTypeId(), movie.getStardom(),
                    movie.getRegion(), movie.getShowtime(), movie.getDescription(), movie.getImage(),
                    movie.getPrice()};
            count = super.update(sql, parames);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseAll();
        }
        return count;
    }

    /**
     * 删除电影
     *
     * @param movieId
     * @return·
     */

    @Override
    public int deleteMovie(int movieId) {
        int count = 0;
        try {
            super.getConnection();
            String sql = "delete from movies where MovieId = ?";
            count = super.update(sql, movieId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 判断电影是否存在
     *
     * @param movieId
     * @return
     */
    @Override
    public boolean isExist(int movieId) {
        boolean flag = false;
        try {
            super.getConnection();
            String sql = "select * from movies where MovieId = ?";
            rs = super.query(sql, movieId);
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 查询所有电影
     *
     * @return
     */

    @Override
    public List<Movies> queryAllMovie() {
        List<Movies> list = new ArrayList<Movies>();
        try {
            super.getConnection();
            String sql = "select * from movies";
            rs = super.query(sql);
            while (rs.next()) {
                Movies movie = new Movies();
                movie.setMovieId(rs.getInt("movieId"));
                movie.setMovieName(rs.getString("movieName"));
                movie.setDirector(rs.getString("director"));
                movie.setTypeId(rs.getInt("typeId"));
                movie.setStardom(rs.getString("stardom"));
                movie.setRegion(rs.getString("region"));
                movie.setShowtime(rs.getString("showtime"));
                movie.setDescription(rs.getString("description"));
                movie.setImage(rs.getString("image"));
                movie.setPrice(rs.getDouble("price"));
                list.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 查询电影
     *
     * @param movieId
     * @return
     */

    @Override
    public Movies queryMovie(int movieId) {
        List<Movies> list = new ArrayList<Movies>();
        try {
            super.getConnection();
            String sql = "select * from movies where MovieId = ?";
            rs = super.query(sql, movieId);
            while (rs.next()) {
                Movies movie = new Movies();
                movie.setMovieId(rs.getInt("movieId"));
                movie.setMovieName(rs.getString("movieName"));
                movie.setDirector(rs.getString("director"));
                movie.setTypeId(rs.getInt("typeId"));
                movie.setStardom(rs.getString("stardom"));
                movie.setRegion(rs.getString("region"));
                movie.setShowtime(rs.getString("showtime"));
                movie.setDescription(rs.getString("description"));
                movie.setImage(rs.getString("image"));
                movie.setPrice(rs.getDouble("price"));
                list.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.get(0);
    }

    /**
     * 修改电影
     */
    @Override
    public int updateMovie(Movies movie) {
        int count = 0;
        try {
            super.getConnection();
            String sql = "update movies set MovieName = ?,protagonist = ?,TypeId = ?,MovieTime = ?,description = ?,image = ?,price = ?,region = ?,director = ? where MovieId = ?";
            Object[] parames = {movie.getMovieName(), movie.getStardom(), movie.getTypeId(), movie.getShowtime(), movie.getDescription(), movie.getImage(), movie.getPrice(), movie.getRegion(), movie.getDirector(), movie.getMovieId()};
        count = super.update(sql, parames);

    }catch( Exception e)  {
        e.printStackTrace();
    }finally{
        CloseAll();
    }
    return count;
}

}
