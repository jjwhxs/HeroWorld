package com.JiangJiawei.mapper;

import com.JiangJiawei.entity.Skill;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface SkillMapper
{
    @Select("select * from skill")
    public List<Skill> getAll();

    @Select("select s.* from heroskill hs,skill s where hs.skillId=s.id and heroId=#{id}")
    public List<Skill> getByHeroId(int heroId);

    @Insert("insert into skill(`name`,`damage`,`consume`) values(#{name},#{damage},#{consume})")
    public int insert(Skill skill);

    @Update("update skill set `name`=#{name},`damage`=#{damage},`consume`=#{consume} where `id`=#{id}")
    public int update(Skill skill);

    @Delete("delete from skill where `id`=#{id}")
    public int delete(int id);
}
