package com.zone.modular.system.sysuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zone.modular.system.sysuser.entity.User;
import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ZoneWonderful
 * @since 2020-05-01
 */

public interface UserMapper extends BaseMapper<User> {
    /**
     * 获取用户列表
     * @return
     */
    List<User> getUserList();
}
