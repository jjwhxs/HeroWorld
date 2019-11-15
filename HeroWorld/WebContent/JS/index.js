$(document).ready(function(){
	
	var hero=null;
	var enemy=null;
				
	var heroAttack=20;
	var enemyAttack=30;
	var heroHeal=50;
	var consume=5;
	
	getAllHero();
				
	function getAllHero() 
	{
	    $.ajax({
	    	type:"POST",//Ajax请求的提交方式（GET或POST）
	    	dataType:"text",//请求的类型
	    	url:"http://localhost:8989/HeroWorld/hero/getAll.do",//发送的目标地址
	    	async:true,
	    	data:{operFlag:"getUserIP"},//发送的参数。JSON的格式
	    	success:function(data){
	    		var dataObj = JSON.parse(data);
	    		console.log(dataObj);
	    		hero=dataObj[0];
	    		enemy=dataObj[1];
	    		$("#ourHeroName").html(hero.name);
	    		$("#enemyHeroName").html(enemy.name);
		
	    		refreshStatusBar();
	    		
	    	},
	    	error:function(exception){
	    		alert("网页出现了未知错误，请联系管理员！");
			}
	    });
	}
	
	//刷新状态条，第一次为初始化
	function refreshStatusBar()
	{
		//刷新数值
		$("#heroHP").html(hero.health);
		$("#heroMaxHP").html(hero.healthMax);
		$("#enemyHP").html(enemy.health);
		$("#enemyMaxHP").html(enemy.healthMax);
		$("#heroMP").html(hero.magic);
		$("#heroMaxMP").html(hero.magicMax);
		$("#enemyMP").html(enemy.magic);
		$("#enemyMaxMP").html(enemy.magicMax);
					
		//刷新状态条
		refreshStatusBarWidth("heroHPBar",hero.health,hero.healthMax);
		refreshStatusBarWidth("enemyHPBar",enemy.health,enemy.healthMax);
		refreshStatusBarWidth("heroMPBar",hero.magic,hero.magicMax)
		refreshStatusBarWidth("enemyMPBar",enemy.magic,enemy.magicMax)
	}
				
	//刷新状态条的宽度
	function refreshStatusBarWidth(elementId,valueNow,valueMax)
	{
		$("#"+elementId).animate({"width":valueNow/valueMax*300+"px"},2000);
	}
	
	$("#holyStrike").click(function(){
		doHolyStrike();
	})
	
	$("#heal").click(function(){
		doHeal();
	})
	
	//我方英雄释放惩击技能
	function doHolyStrike()
	{
		//这样的英雄对战游戏规则更合理一些
		if(hero.magic<consume)
		{
			alert("您现在无法释放技能了");
			if(enemy.magic>=consume)
			{
				hero.health=hero.health-enemyAttack;
				enemy.magic=enemy.magic-consume;
			}
		}
		else
		{
			hero.magic=hero.magic-consume;
			enemy.health=enemy.health-heroAttack;
			if(enemy.magic<consume)
			{
				alert("敌方已经无法释放技能了");
			}
			else
			{
				enemy.magic=enemy.magic-consume;
				hero.health=hero.health-enemyAttack;
			}
		}
					
		afterCalculate();
	}
				
	//我方英雄使用了治疗术技能
	function doHeal()
	{
		hero.health=hero.health+heroHeal-enemyAttack;
					
		enemy.magic=enemy.magic-consume;
					
		afterCalculate();
	}

	//数值计算过后的善值代码
	function afterCalculate()
	{
		formatStatus();
		refreshStatusBar();
		checkWinOrLoose();
	}
				
	//格式化双方英雄状态数据
	function formatStatus()
	{
		//最大值判断
		if(hero.health>hero.healthMax)
		{
			hero.health=hero.healthMax;
		}
		if(enemy.health>enemy.healthMax)
		{
			enemy.health=enemy.healthMax;
		}
		if(hero.magic>hero.magicMax)
		{
			hero.magic=hero.magicMax;
		}
		if(enemy.magic>enemy.magicMax)
		{
			enemy.magic=enemy.magicMax;
		}
					
		//最小值判断
		if(hero.health<0)
		{
			hero.health=0;
		}
		if(enemy.health<0)
		{
			enemy.health=0;
		}
		if(hero.magic<0)
		{
			hero.magic=0;
		}
		if(enemy.magic<0)
		{
			enemy.magic=0;
		}
	}
				
	//英雄对战结果
	function checkWinOrLoose()
	{
		if(hero.health==0)
		{
			alert("你被击败了");
		}
		else
		{
			if(enemy.health==0)
			{
				alert("你胜利了！");
			}
		}
	}
	
})