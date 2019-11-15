package com.JiangJiawei.dao.impl;

import com.JiangJiawei.dao.HeroDao;
import com.JiangJiawei.dao.impl.BaseDaoImpl;
import com.JiangJiawei.entity.Hero;
import com.JiangJiawei.mapper.HeroMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("heroDao")
public class HeroDaoImpl extends BaseDaoImpl implements HeroDao
{
    private HeroMapper heroMapper=null;

    public HeroDaoImpl()
    {
        heroMapper=session.getMapper(HeroMapper.class);
    }
    public List<Hero> getAll()
    {
        return heroMapper.getAll();
    }
    public boolean insert(Hero hero)
    {
        int effectedLines=heroMapper.insert(hero);
        session.commit();
        return super.checkWhetherOperateIsSuccess(effectedLines);
    }

    public boolean update(Hero hero)
    {
        int effectedLines=heroMapper.update(hero);
        session.commit();
        return super.checkWhetherOperateIsSuccess(effectedLines);
    }

    public boolean delete(int id)
    {
        int effectedLines=heroMapper.delete(id);
        session.commit();
        return super.checkWhetherOperateIsSuccess(effectedLines);
    }
}
