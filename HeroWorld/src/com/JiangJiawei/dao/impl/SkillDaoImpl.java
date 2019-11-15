package com.JiangJiawei.dao.impl;

import com.JiangJiawei.dao.SkillDao;
import com.JiangJiawei.dao.impl.BaseDaoImpl;
import com.JiangJiawei.entity.Skill;
import com.JiangJiawei.mapper.SkillMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 技能Dao类
 * 修饰符尽量用private
 * 出现三次及以上的要进行封装
 */
@Repository("skillDao")
public class SkillDaoImpl extends BaseDaoImpl implements SkillDao
{
    private SkillMapper skillMapper=null;

    public SkillDaoImpl()
    {
    	skillMapper=session.getMapper(SkillMapper.class);
    }
    public List<Skill> getAll()
    {
        return skillMapper.getAll();
    }

    public List<Skill> getByHeroId(int heroId)
    {
        return skillMapper.getByHeroId(heroId);
    }

    public boolean insert(Skill skill)
    {
    	int effectedLines=skillMapper.insert(skill);
    	session.commit();
	return checkWhetherOperateIsSuccess(effectedLines);
    }

    public boolean update(Skill skill)
    {
    	int effectedLines=skillMapper.update(skill);
    	session.commit();
    	return checkWhetherOperateIsSuccess(effectedLines);
    }

    public boolean delete(int id)
    {
    	int effectedLines=skillMapper.delete(id);
    	session.commit();
    	return checkWhetherOperateIsSuccess(effectedLines);
    }

}
