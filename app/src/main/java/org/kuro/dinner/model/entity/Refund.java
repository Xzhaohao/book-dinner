package org.kuro.dinner.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Refund {

    private String title;
    private String content;
    private String time;

    public Refund(String title, String content, String time) {
        this.title = title;
        this.content = content;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static List<Refund> list() {
        List<Refund> list = new ArrayList<>();

        list.add(new Refund("退款成功", "【￥20.5】将退至您的支付宝账户，详情请查询", "2022-6-29 19:13:02"));
        list.add(new Refund("退款中", "您的退款将会在1-7个工作日退回您的支付账户", "2022-6-29 15:15:02"));
        list.add(new Refund("审核已通过", "已为您取消订单并退款", "2022-6-28 15:53:04"));
        list.add(new Refund("已申请退款", "您已申请退款，系统审核通过后将为您退款", "2022-6-27 17:13:02"));

        return list;
    }
}
