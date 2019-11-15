package com.JiangJiawei.service;

import com.JiangJiawei.dao.HeroDao;
import com.JiangJiawei.dao.impl.HeroDaoImpl;
import com.JiangJiawei.entity.Hero;

import java.util.List;

/**
 * 英雄服务接口
 */
public interface HeroService
{
    public List<Hero> getAll();
}
