package com.JiangJiawei.controller;

import com.JiangJiawei.entity.Hero;
import com.JiangJiawei.service.HeroService;
import com.JiangJiawei.service.impl.HeroServiceImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping(value = "/hero")
public class HeroController
{
    @Resource
    private HeroService heroService;

    @RequestMapping("/getAll.do")
    public void getAll(HttpServletRequest request, HttpServletResponse response)
    {
    	response.setCharacterEncoding("UTF-8");
        response.setHeader("ContentType","text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
    	List<Hero> heroList=heroService.getAll();
        String result=heroList.toString();
        try
        {
            PrintWriter writer=response.getWriter();
            writer.write(result);
            writer.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
