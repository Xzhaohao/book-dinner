package org.kuro.dinner.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String sellerName;
    // 订单状态，1待接单，2待配送，3待收货，4待评价，5交易成功，6退款中
    private Integer state;
    private Integer foodNum;
    private String price;
    private List<Food> foods;

    public Order(String sellerName, Integer state, Integer foodNum, String price, List<Food> foods) {
        this.sellerName = sellerName;
        this.state = state;
        this.foodNum = foodNum;
        this.price = price;
        this.foods = foods;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getFoodNum() {
        return foodNum;
    }

    public void setFoodNum(Integer foodNum) {
        this.foodNum = foodNum;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public static class Food {
        private String foodName;
        private Integer number;

        public Food(String foodName, Integer number) {
            this.foodName = foodName;
            this.number = number;
        }

        public String getFoodName() {
            return foodName;
        }

        public void setFoodName(String foodName) {
            this.foodName = foodName;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }
    }


    public static List<Order> getList() {
        List<Order> list = new ArrayList<>();
        List<Food> items = new ArrayList<>();
        List<Food> items2 = new ArrayList<>();
        List<Food> items3 = new ArrayList<>();

        items.add(new Food("麻辣小龙虾", 3));
        items.add(new Food("啤酒", 4));
        list.add(new Order("正宗小龙虾", 3, 7, "¥321.00", items));

        items2.add(new Food("香辣鸡排", 1));
        items2.add(new Food("鸡腿堡", 1));
        list.add(new Order("正新鸡排", 2, 2, "¥29.00", items2));

        items3.add(new Food("金丝鸡柳", 3));
        items3.add(new Food("炸鸡汉堡", 1));
        items3.add(new Food("黑椒鸡块", 1));
        list.add(new Order("金拱门", 1, 5, "¥65.50", items3));

        return list;
    }
}
