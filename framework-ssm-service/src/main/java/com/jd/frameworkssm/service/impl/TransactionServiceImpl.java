package com.jd.frameworkssm.service.impl;

import com.jd.frameworkssm.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2019/3/9 15:39
 */
@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionTemplate transactionTemplate;

    /**
     * 测试使用编程式事务
     */
    @Override
    public String templateSql() {
        //建议使用lambda表达式，而不是匿名内部类
        return this.transactionTemplate.execute(transactionStatus -> {
            try {
                //todo 数据库操作
                return "success";
            } catch (Exception e) {
                transactionStatus.setRollbackOnly();
                System.out.println("事务回滚啦：" + e.getMessage());
            }
            return "fail";
        });
    }

    /**
     * 编程式事务
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testTransaction() {
        //todo 数据库操作

    }
}
