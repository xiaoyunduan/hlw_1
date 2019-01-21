$("#a4").click(function(e){
	            logout();
	         });
	         
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
	     
$(function userMsg(){
        $.ajax({
           url: "http://localhost:8080/hlw/backstage/getUserMsg",
           dataType:"json",
           success: function(result){       //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
            
            //  var tableInfos = document.getElementById('tab1');
            $("#userName").val(result.userName);
            $("#level").val(result.level);
            $("#email").val(result.email);
//            alert(result);
          },


     error : function() {
          alert("异常1！");
      }
       });
       
       
  })