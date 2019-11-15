package com.JiangJiawei.mapper;

import com.JiangJiawei.entity.Hero;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface HeroMapper
{
    @Select("select * from hero")
    public List<Hero> getAll();

    @Insert("insert into hero(`name`,`level`) values(#{name},#{level})")
    public int insert(Hero hero);

    @Update("update hero set `name`=#{name},`level`=#{level} where `id`=#{id}")
    public int update(Hero hero);

    @Delete("delete from hero where `id`=#{id}")
    public int delete(int id);
}
