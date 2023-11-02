package com.song.entity;

public class Movies {

    /**
     * 电影实体类
     *
     */
    private int MovieId;
  
    private String MovieName;
  
    private String director;
    
    private int TypeId;
    
    private String stardom;

    private String region;
    private String showtime;
    private String description;
    private String image;
    private double price;
    public Movies() {
    }

    public Movies(int MovieId, String MovieName, String director, int TypeId, String stardom, String region,
            String showtime, String description, String image, double price) {
        this.MovieId = MovieId;
        this.MovieName = MovieName;
        this.director = director;
        this.TypeId = TypeId;
        this.stardom = stardom;
        this.region = region;
        this.showtime = showtime;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public Movies( String MovieName, String director, int TypeId, String stardom, String region,
            String showtime, String description, String image, double price) {
        this.MovieName = MovieName;
        this.director = director;
        this.TypeId = TypeId;
        this.stardom = stardom;
        this.region = region;
        this.showtime = showtime;
        this.description = description;
        this.image = image;
        this.price = price;
    }
    /**
     * 获取
     * 
     * @return MovieId
     */
    public int getMovieId() {
        return MovieId;
    }

    /**
     * 设置
     * 
     * @param MovieId
     */
    public void setMovieId(int MovieId) {
        this.MovieId = MovieId;
    }

    /**
     * 获取
     * 
     * @return MovieName
     */
    public String getMovieName() {
        return MovieName;
    }

    /**
     * 设置
     * 
     * @param MovieName
     */
    public void setMovieName(String MovieName) {
        this.MovieName = MovieName;
    }

    /**
     * 获取
     * 
     * @return director
     */
    public String getDirector() {
        return director;
    }

    /**
     * 设置
     * 
     * @param director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * 获取
     * 
     * @return TypeId
     */
    public int getTypeId() {
        return TypeId;
    }

    /**
     * 设置
     * 
     * @param TypeId
     */
    public void setTypeId(int TypeId) {
        this.TypeId = TypeId;
    }

    /**
     * 获取
     * 
     * @return stardom
     */
    public String getStardom() {
        return stardom;
    }

    /**
     * 设置
     * 
     * @param stardom
     */
    public void setStardom(String stardom) {
        this.stardom = stardom;
    }

    /**
     * 获取
     * 
     * @return region
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置
     * 
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * 获取
     * 
     * @return showtime
     */
    public String getShowtime() {
        return showtime;
    }

    /**
     * 设置
     * 
     * @param showtime
     */
    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    /**
     * 获取
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取
     * 
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置
     * 
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取
     * 
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * 
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Movies{MovieId = " + MovieId + ", MovieName = " + MovieName + ", director = " + director + ", TypeId = "
                + TypeId + ", stardom = " + stardom + ", region = " + region + ", showtime = " + showtime
                + ", description = " + description + ", image = " + image + ", price = " + price + "}";
    }
}
