package com.zone.modular.system.sysuser.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zone.modular.system.sysuser.entity.User;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ZoneWonderful
 * @since 2020-05-01
 */
public interface UserService extends IService<User> {
    /**
     * 获取用户列表
     * @return
     */
    List<User> getUserList();
}
