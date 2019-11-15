package com.JiangJiawei.service.impl;

import com.JiangJiawei.dao.HeroDao;
import com.JiangJiawei.entity.Hero;
import com.JiangJiawei.service.HeroService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("heroService")
public class HeroServiceImpl implements HeroService
{
    @Resource
    private HeroDao heroDao;

    public List<Hero> getAll()
    {
        return heroDao.getAll();
    }
}
