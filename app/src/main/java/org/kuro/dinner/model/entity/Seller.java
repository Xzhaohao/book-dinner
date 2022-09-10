package org.kuro.dinner.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Seller {

    private String name;
    private Integer startPrice;
    private Integer dispatching;
    private Integer sales;
    private String distance;
    private String score;

    public Seller(String name, Integer startPrice, Integer dispatching, Integer sales, String distance, String score) {
        this.name = name;
        this.startPrice = startPrice;
        this.dispatching = dispatching;
        this.sales = sales;
        this.distance = distance;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getDispatching() {
        return dispatching;
    }

    public void setDispatching(Integer dispatching) {
        this.dispatching = dispatching;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public static List<Seller> getList() {
        List<Seller> list = new ArrayList<>();
        list.add(new Seller("抹茶布丁", 20, 3, 135, "3.9km", "4.8"));
        list.add(new Seller("皇家圣代", 36, 3, 481, "5.3km", "4.9"));
        list.add(new Seller("白草莓", 18, 3, 67, "3.1km", "3.9"));
        list.add(new Seller("奶茶店", 7, 3, 67, "2.1km", "5.0"));

        return list;
    }
}
