package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//construction -> getter and setter, constructor
@Document("movies")
public class Movie {
    //POJO
    @Id
  private Integer id;
    private String title;
    private String price;
    private String description;
    private boolean isMovie;
    private String smallPoster;
    private String largePoster;
    private String priceRent;
    private String pricePurchase;
    private boolean isFeatured;


//    public Movie(){
//
//    }
    public Movie(Integer id, String title, String price, String description, boolean isMovie, String smallPoster, String largePoster, String priceRent, String pricePurchase, boolean isFeatured) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.description = description;
        this.isMovie = isMovie;
        this.smallPoster = smallPoster;
        this.largePoster = largePoster;
        this.priceRent = priceRent;
        this.pricePurchase = pricePurchase;
        this.isFeatured = isFeatured;
    }

    public boolean getMovie() {
        return isMovie;
    }

    public void setMovie(boolean movie) {
        isMovie = movie;
    }

    public String getSmallPoster() {
        return smallPoster;
    }

    public void setSmallPoster(String smallPoster) {
        this.smallPoster = smallPoster;
    }

    public String getLargePoster() {
        return largePoster;
    }

    public void setLargePoster(String largePoster) {
        this.largePoster = largePoster;
    }

    public String getPriceRent() {
        return priceRent;
    }

    public void setPriceRent(String priceRent) {
        this.priceRent = priceRent;
    }

    public String getPricePurchase() {
        return pricePurchase;
    }

    public void setPricePurchase(String pricePurchase) {
        this.pricePurchase = pricePurchase;
    }

    public boolean getFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }
    public String getTitle() {
        return title;

    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", is Movie = '"+ isMovie + '\'' +
                ", smallPoster = '"+ smallPoster + '\'' +
                ", largePoster = '"+ largePoster + '\'' +
                ", priceRent = '"+ priceRent + '\'' +
                ", pricePurchase = '"+ pricePurchase + '\'' +
                ", is Featured = '"+ isFeatured + '\'' +
                '}';
    }



}
