package com.JiangJiawei.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 英雄类
 * <ol><li>具有攻击的技能</li><li>具有治疗的功能</li><li>具有闪现的功能</li></ol>
 */
public class Hero extends BaseEntity implements Cloneable
{
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 等级
	 */
	private int level;
	/**
	 * 生命值
	 */
	private int health;
	/**
	 * 法术强度(蓝)
	 */
	private int magic;
	/**
	 * 技能栏(只需要生成get方法)
	 */
	private List<Skill> skillList=new ArrayList<Skill>();
	/**
	 * 无参构造
	 */
	public Hero()
	{

	}
	/**
	 * 实例化对象时初始化名字
	 */
	public Hero(int id,String name)
	{
		this.id=id;
		this.name=name;
		setLevel(1);
	}
	@Override
	public Object clone()
	{
		try
		{
			return super.clone();
		} 
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 英雄释放技能
	 */
	public void castSkill(int skillChoosen,Hero target)
	{
		Skill skill=skillList.get(skillChoosen);
		skill.cast(this, target);
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
	public int getLevel()
	{
		return level;
	}
	public void setLevel(int level)
	{
		this.level = level;
		setHealth(level*50+50);
		setMagic(level*50+50);
	}
	public int getHealth()
	{
		return health;
	}
	public void setHealth(int health)
	{
		if(health<0)
			health=0;
		this.health = health;
	}
	public int getMagic()
	{
		return magic;
	}
	public void setMagic(int magic)
	{
		if(magic<0)
		magic=0;
		this.magic = magic;
	}
	public void setSkillList(List<Skill> skillList)
	{
		this.skillList=skillList;
	}
	public List<Skill> getSkillList()
	{
		return skillList;
	}
	@Override
	public String toString()
	{
		return "{\"name\":\""+name+"\", \"level\":\""+level+"\", \"health\":\""+health+"\", \"magic\":\""+magic+"\",\"healthMax\":\""+health+"\",\"magicMax\":\""+magic+"\"}";
	}
}