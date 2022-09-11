package org.kuro.dinner.model;

public class Dict {

    public static String OrderState(Integer state) {
        switch (state) {
            case 1:
                return "待接单";
            case 2:
                return "待配送";
            case 3:
                return "待收货";
            case 4:
                return "待评价";
            case 5:
                return "交易成功";
            case 6:
                return "退款中";
            default:
                return "交易取消";
        }
    }
}
