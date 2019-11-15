package com.JiangJiawei.entity;

import com.JiangJiawei.entity.Hero;

/**
 * ������
 */
public class Skill extends BaseEntity
{
	/**
	 * ���
	 */
	private int id;
	/**
	 * ����
	 */
	private String name;
	/**
	 * �˺�
	 */
	private int damage;
	/**
	 * ����(��)
	 */
	private int consume;
	/**
	 * �޲ι���
	 */
	public Skill()
	{

	}
	/**
	 * ʵ��������ʱ��ʼ����������
	 */
	public Skill(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	/**
	 * �ҷ�Ӣ���ͷż��ܸ��з�Ӣ��
	 */
	public void cast(Hero caster,Hero target)
	{
		if(damage>0)
		{
			System.out.println(name+"�����"+damage+"���˺�ֵ");
			caster.setMagic(caster.getMagic()-consume);
			target.setHealth(target.getHealth()-damage);
		}
		else
		{
			System.out.println(name+"������"+(-damage)+"������ֵ");
			caster.setHealth(caster.getHealth()-damage);
		}
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getDamage()
	{
		return damage;
	}
	public void setDamage(int damage)
	{
		this.damage = damage;
	}
	public int getConsume()
	{
		return consume;
	}
	public void setConsume(int consume)
	{
		this.consume = consume;
	}
	@Override
	public String toString()
	{
		return name+"���˺�ֵΪ:"+damage+",��������ֵΪ:"+consume+"��";
	}
}