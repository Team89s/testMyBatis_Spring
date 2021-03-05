package com.igeek.ssm.mapper;

import com.igeek.ssm.pojo.UserCustom;

import java.util.List;

public interface UserAndOrdersMapper {

    public List<UserCustom> findUserAndOrders();

}
