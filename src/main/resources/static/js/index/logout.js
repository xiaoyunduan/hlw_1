$(function TorF(){
        $.ajax({
	         url: "http://localhost:8080/hlw/backstage/index1",
	         dataType:"json",
	         success: function(result){       //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
	     
	       if(result.yon==1){ 
	         $('#log').attr('href','http://localhost:8080/hlw/index');
	         $("#log").text('注销');
	         $("#log").click(function(e){
	            logout();
	         })
	         }else{
	         $('#log').attr('href','http://localhost:8080/hlw/login');
             $("#log").text('登录');
	         }
	         },
	 	 error : function() {
          alert("异常1！");
      }
	     });
	     
	     
  })
  
     function logout(){
	          $.ajax({
	         url: "http://localhost:8080/hlw/backstage/index2",
	         
	         success: function(result){       //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
	          alert("注销成功");
	         },
	 	 error : function() {
          alert("异常2！");
           }
	     });
	     }