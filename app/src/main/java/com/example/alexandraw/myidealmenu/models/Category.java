package com.example.alexandraw.myidealmenu.models;

/**
 * Created by RENATO on 12/10/2015.
 */
public class Category {
    String category, genere, imgUrl;
    float score;

    public Category() {
    }

    public Category(String category, String genere, String imgUrl, float score) {
        this.category = category;
        this.genere = genere;
        this.imgUrl = imgUrl;
        this.score = score;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
