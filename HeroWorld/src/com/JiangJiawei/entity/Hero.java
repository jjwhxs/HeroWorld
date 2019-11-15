package com.JiangJiawei.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Ӣ����
 * <ol><li>���й����ļ���</li><li>�������ƵĹ���</li><li>�������ֵĹ���</li></ol>
 */
public class Hero extends BaseEntity implements Cloneable
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
	 * �ȼ�
	 */
	private int level;
	/**
	 * ����ֵ
	 */
	private int health;
	/**
	 * ����ǿ��(��)
	 */
	private int magic;
	/**
	 * ������(ֻ��Ҫ����get����)
	 */
	private List<Skill> skillList=new ArrayList<Skill>();
	/**
	 * �޲ι���
	 */
	public Hero()
	{

	}
	/**
	 * ʵ��������ʱ��ʼ������
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
	 * Ӣ���ͷż���
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