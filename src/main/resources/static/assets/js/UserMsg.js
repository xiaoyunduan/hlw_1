
	     
$(function userMsg(){
        $.ajax({
        	type: "POST", 
        	
           url: "http://localhost:8080/hlw/backstage/getUserMsg",
           dataType:"json",
           success: function(result){       //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
            
            //  var tableInfos = document.getElementById('tab1');
            $("#userName").val(result.userName);
            $("#level").val(result.level);
            $("#email").val(result.email);
            $("#homeAddress").val(result.homeAddress);
            $("#aboutMe").val(result.aboutMe);
//            alert(result);
          },


     error : function() {
          alert("异常1！");
      }
       });            
  })
  
 
function getReportHistory(){
        $.ajax({
           url: "http://localhost:8080/hlw/backstage/getReportHistory",
           dataType:"json",
           success: function(result){       //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
            
            //  var tableInfos = document.getElementById('tab1');
        
          for(var i in result){

                 $("#t1 tbody").append("<tr>"+
                      '<td>'+result[i].reportWay+'</td>'
                      +'<td>'+result[i].point+'</td>'
                      +'<td>'+result[i].reportTime+'</td>'
                      +'<td>'+result[i].headName+'</td>'
                      +'<td>'+result[i].isResolve+'</td>'
                      +"</tr>");
                   
        //  alert(str);
          }

           },
     error : function() {
          alert("异常1！");
      }
       });     
       
  }
  
  
  
  function getAllUser(){
        $.ajax({
           url: "http://localhost:8080/hlw/backstage/getAllUser",
           dataType:"json",
           success: function(result){       //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
            
            //  var tableInfos = document.getElementById('tab1');
        
          for(var i in result){
                     
                 $("#t1 tbody").append("<tr>"+
                      '<td>'+result[i].userId+'</td>'
                      +'<td>'+result[i].userName+'</td>'
                      +'<td>'+result[i].passWord+'</td>'
                      +'<td>'+result[i].email+'</td>'
                      +'<td>'+'<input type="button" class="btn btn-info btn-fill btn-wd" value="删除" onclick="deleteUser('+result[i].userId+')"/>'+'</td>'
                     
                      +"</tr>");
                   
//         
          }
//	alert($("#t1 tbody").html());
           },
     error : function() {
          alert("异常1！");
      }
       });     
       
  }
  
  
  
  function receivedReportHistory(){
        $.ajax({
           url: "http://localhost:8080/hlw/backstage/receivedReportHistory",
           dataType:"json",
           success: function(result){       //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
            
            //  var tableInfos = document.getElementById('tab1');
             $("#h4").html("所收举报历史");
        			 $("#th4").html("举报用户");
          for(var i in result){

                 $("#t1 tbody").append("<tr>"+
                      '<td>'+result[i].reportWay+'</td>'
                      +'<td>'+result[i].point+'</td>'
                      +'<td>'+result[i].reportTime+'</td>'
                      +'<td>'+result[i].userName+'</td>'
                      +'<td>'+result[i].isResolve+'</td>'
                      +"</tr>");
                   
        //  alert(str);
          }

           },
     error : function() {
          alert("异常1！");
      }
       });     
       
  }
 
 function deleteUser(i){
 	var userId=i;
// 	alert(userId);
 	 $.ajax({
           url: "http://localhost:8080/hlw/backstage/deleteUser",
           dataType:"text",
           data:{"Id":userId},
           success: function(result){       //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
            
            //  var tableInfos = document.getElementById('tab1');
            alert(result);
            window.location.reload();

           },
     error : function() {
          alert("异常1！");
      }
       }); 
 	
 	
 	
 }
 
  
  function updateUserMsg(){
  $.ajax({
           url: "http://localhost:8080/hlw/backstage/updateUserMsg",
           type: "POST", 
           dataType:"text",
           
           data: $('#userMsg').serialize(),
           
//           serialize() 方法正确获取数据需要注意一下几点：

//			1.只会将“成功的控件”序列化为字符串。

//			2.如果不使用按钮来提交表单，则不对提交按钮的值序列化。

//			3.如果要表单元素的值包含到序列字符串中，元素必须使用 name 属性。
           success: function(result){     
//            alert($('#userMsg').serialize());
            //  var tableInfos = document.getElementById('tab1');
            alert(result);
//            alert(result);
          },


     error : function() {
          alert("异常！!");
      }
       });     
}

   

