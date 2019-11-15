package com.JiangJiawei.dao;

import java.util.List;

import com.JiangJiawei.entity.BaseEntity;

/**
 * ����Dao�ӿ�
 */
public interface BaseDao<T extends BaseEntity>
{
	/**
     * ��ȡ�����ж�����б�
     */
    public abstract List<T> getAll();

     /**
      * ����ʵ��
      */	
    public abstract boolean insert(T t);

    /**
     * �޸�ʵ��
     */
    public abstract boolean update(T t);

    /**
     * ɾ��ʵ��
     */
    public abstract boolean delete(int id);
}
