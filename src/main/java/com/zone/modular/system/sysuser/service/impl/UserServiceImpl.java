package com.zone.modular.system.sysuser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zone.modular.system.sysuser.entity.User;
import com.zone.modular.system.sysuser.mapper.UserMapper;
import com.zone.modular.system.sysuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ZoneWonderful
 * @since 2020-05-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> getUserList() {
        return this.baseMapper.getUserList();
    }
}
