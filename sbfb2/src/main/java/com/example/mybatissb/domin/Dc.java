package com.example.mybatissb.domin;

/**
 * 作者：17596
 * 时间：2023/5/209:52202305
 */
public class Dc {
    private String id;
    private String mean;

    private int rate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }


    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Dc{" +
                "id='" + id + '\'' +
                ", mean='" + mean + '\'' +
                ", rate=" + rate +
                '}';
    }



}
