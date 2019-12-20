package com.jd.frameworkssm.service;

import com.jd.frameworkssm.domain.user.User;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2019/3/9 15:58
 */
public interface UserService {
    int insertOne();
    User selectById(Long id);
}
