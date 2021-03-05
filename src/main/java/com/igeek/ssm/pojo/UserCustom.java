package com.igeek.ssm.pojo;

import java.util.List;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/3/5 16:03
 */
public class UserCustom extends User {

    //一对多关联订单
    private List<Orders> orders;


    public UserCustom() {
    }

    public UserCustom(List<Orders> orders) {
        this.orders = orders;
    }

    /**
     * 获取
     * @return orders
     */
    public List<Orders> getOrders() {
        return orders;
    }

    /**
     * 设置
     * @param orders
     */
    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public String toString() {
        return "UserCustom{orders = " + orders + "}";
    }
}
