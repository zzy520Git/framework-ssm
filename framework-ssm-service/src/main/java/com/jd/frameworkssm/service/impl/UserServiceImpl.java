package com.jd.frameworkssm.service.impl;

import com.jd.frameworkssm.dao.user.UserMapper;
import com.jd.frameworkssm.domain.user.User;
import com.jd.frameworkssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2019/3/10 12:55
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    @Transactional
    public int insertOne() {
        System.out.println("----------------------mmmmmmmmmmmmmmm-----------");
        User u = new User();
        u.setUsername("zzy");
        u.setPassword("root");
        u.setSex(0);
        userMapper.insertSelective(u);
        System.out.println("1-id=" + u.getId());
        u.setId(null);
        u.setSex(1);
        u.setUsername("root");
        userMapper.insertSelective(u);
        System.out.println("2-id=" + u.getId());
        return 0;
    }

    @Override
    public User selectById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
