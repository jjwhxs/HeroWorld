package com.JiangJiawei.entity;

import com.JiangJiawei.entity.Hero;

/**
 * 技能类
 */
public class Skill extends BaseEntity
{
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 伤害
	 */
	private int damage;
	/**
	 * 消耗(蓝)
	 */
	private int consume;
	/**
	 * 无参构造
	 */
	public Skill()
	{

	}
	/**
	 * 实例化对象时初始化三个条件
	 */
	public Skill(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	/**
	 * 我方英雄释放技能给敌方英雄
	 */
	public void cast(Hero caster,Hero target)
	{
		if(damage>0)
		{
			System.out.println(name+"造成了"+damage+"点伤害值");
			caster.setMagic(caster.getMagic()-consume);
			target.setHealth(target.getHealth()-damage);
		}
		else
		{
			System.out.println(name+"增加了"+(-damage)+"点生命值");
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
		return name+"的伤害值为:"+damage+",法力消耗值为:"+consume+"。";
	}
}