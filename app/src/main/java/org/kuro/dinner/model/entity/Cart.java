package org.kuro.dinner.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private String sellerName;
    private List<Food> foods;

    public Cart(String sellerName, List<Food> foods) {
        this.sellerName = sellerName;
        this.foods = foods;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public static class Food extends Order.Food {
        private String price;
        private String norms;

        public Food(String foodName, Integer number, String price, String norms) {
            super(foodName, number);
            this.price = price;
            this.norms = norms;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getNorms() {
            return norms;
        }

        public void setNorms(String norms) {
            this.norms = norms;
        }
    }

    public static List<Cart> list() {
        List<Cart> list = new ArrayList<>();
        List<Food> items1 = new ArrayList<>();
        List<Food> items2 = new ArrayList<>();
        List<Food> items3 = new ArrayList<>();

        items1.add(new Food("麻辣小龙虾", 1, "33.5", "微辣"));
        items1.add(new Food("圣女果", 1, "8", "无"));
        items1.add(new Food("果蔬", 1, "6", "无"));

        items2.add(new Food("鸭脖", 1, "16.5", "无"));

        items3.add(new Food("汉堡", 1, "9", "微辣"));

        list.add(new Cart("正宗龙虾", items1));
        list.add(new Cart("周小鸭", items2));
        list.add(new Cart("鸡公煲（人民广场店）", items3));

        return list;
    }
}
