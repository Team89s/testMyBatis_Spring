package com.igeek.ssm.mapper;

import com.igeek.ssm.pojo.Orders;
import com.igeek.ssm.pojo.UserCustom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(locations = "classpath:spring/applicationContext.xml")
class UserAndOrdersMapperTest {

    @Autowired
    private UserAndOrdersMapper mapper;

    @Test
    void findUserAndOrders() {
        List<UserCustom> userAndOrders = mapper.findUserAndOrders();
        for (UserCustom userCustom : userAndOrders) {
            System.out.println(userCustom.getUsername());

            List<Orders> orders = userCustom.getOrders();
            for (Orders order : orders) {
                System.out.println(order.getNumber());
            }
        }
    }
}