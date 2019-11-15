getAllHero();
			
			function getAllHero() {
                $.ajax({
                    type:"POST",//Ajax请求的提交方式（GET或POST）
                    dataType:"text",//请求的类型
                    url:"http://localhost:8989/HeroWorld/hero/getAll.do",//发送的目标地址
                    async:true,
                    data:{operFlag:"getUserIP"},//发送的参数。JSON的格式
                    success:function(data){
                        var dataObj = JSON.parse(data);
                        console.log(dataObj);
						var heroName=dataObj[0].name;
						var enemyName=dataObj[1].name;
						document.getElementById("ourHeroName").innerText=heroName;
						document.getElementById("enemyHeroName").innerText=enemyName;
                    },
                    error:function(exception){
                        alert("网页出现了未知错误，请联系管理员！");
                    }
                });
            }