package com.JiangJiawei.service;

import com.JiangJiawei.dao.HeroDao;
import com.JiangJiawei.dao.impl.HeroDaoImpl;
import com.JiangJiawei.entity.Hero;

import java.util.List;

/**
 * Ӣ�۷���ӿ�
 */
public interface HeroService
{
    public List<Hero> getAll();
}
