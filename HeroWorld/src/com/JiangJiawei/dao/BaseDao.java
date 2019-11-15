package com.JiangJiawei.dao;

import java.util.List;

import com.JiangJiawei.entity.BaseEntity;

/**
 * 基础Dao接口
 */
public interface BaseDao<T extends BaseEntity>
{
	/**
     * 获取到所有对象的列表
     */
    public abstract List<T> getAll();

     /**
      * 新增实体
      */	
    public abstract boolean insert(T t);

    /**
     * 修改实体
     */
    public abstract boolean update(T t);

    /**
     * 删除实体
     */
    public abstract boolean delete(int id);
}
