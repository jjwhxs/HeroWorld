package com.JiangJiawei.dao.impl;

import com.JiangJiawei.dao.BaseDao;
import com.JiangJiawei.entity.BaseEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

import java.util.List;

/**
 * 基础Dao类(抽象类)
 * T:参数的数据类型(这里限制为实体类型),Hero:参数
 */
public abstract class BaseDaoImpl
{
	//这个修饰符可以让其子类直接引用
	protected SqlSession session=null;

    public BaseDaoImpl()
    {
        InputStream inputStream= BaseDaoImpl.class.getClassLoader().getResourceAsStream("config/mybatisConf.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        session=sessionFactory.openSession();
    }

    /**
     * 根据SQL语句的影响行数判断其是否执行成功了
     */
    protected boolean checkWhetherOperateIsSuccess(int effectedLines)
    {
        if(effectedLines==0)
        {
            return false;
        }
        return true;
    }
}
