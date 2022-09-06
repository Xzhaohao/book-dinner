package org.kuro.dinner.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Address {

    // 用户
    private String name;

    // 手机号
    private String mobile;

    // 收货地址
    private String address;

    // 状态，true：默认地址，false：非默认地址
    private Boolean state;

    public Address() {
    }

    public Address(String name, String mobile, String address, Boolean state) {
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public static List<Address> list() {
        List<Address> list = new ArrayList<>();
        list.add(new Address(
                "李白", "13823532943",
                "山东省临沂市兰山区金雀山路与陶然路90号",
                true
        ));
        list.add(new Address(
                "李白", "13823532943",
                "山东省临沂市河东区沃尔沃路90号",
                false
        ));

        return list;
    }
}
