package org.kuro.dinner.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String menu;
    private List<CategoryItem> list;

    public Category(String menu, List<CategoryItem> list) {
        this.menu = menu;
        this.list = list;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public List<CategoryItem> getList() {
        return list;
    }

    public void setList(List<CategoryItem> list) {
        this.list = list;
    }

    public static class CategoryItem {
        private String img;
        private String name;

        public CategoryItem(String img, String name) {
            this.img = img;
            this.name = name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    public static List<Category> data() {
        List<Category> list = new ArrayList<>();
        List<CategoryItem> items = new ArrayList<>();

        items.add(new CategoryItem("", "麻辣小龙虾"));
        items.add(new CategoryItem("", "水果"));
        list.add(new Category("快餐", items));

        List<CategoryItem> items2 = new ArrayList<>();
        items2.add(new CategoryItem("", "水果"));
        items2.add(new CategoryItem("", "龙虾"));
        items2.add(new CategoryItem("", "果蔬"));
        items2.add(new CategoryItem("", "龙虾"));
        items2.add(new CategoryItem("", "果蔬"));
        list.add(new Category("早餐", items2));

        list.add(new Category("夜宵", items2));
        list.add(new Category("家常菜", items2));
        list.add(new Category("小吃馆", items));
        list.add(new Category("快食简餐", items));
        list.add(new Category("鲜花蛋糕", items));
        list.add(new Category("饮料臻品", items));

        return list;
    }
}
