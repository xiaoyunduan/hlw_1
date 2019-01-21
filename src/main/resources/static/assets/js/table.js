
$(function TorF(){
        $.ajax({
           url: "http://localhost:8080/hlw/backstage/emailRecording",
           dataType:"json",
           success: function(result){       //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
            
            //  var tableInfos = document.getElementById('tab1');
        
          for(var i in result){

                 $("#t1 tbody").append("<tr>"+
                      '<td>'+result[i].userId+'</td>'
                      +'<td>'+result[i].userName+'</td>'
                      +'<td>'+result[i].point+'</td>'
                      +'<td>'+result[i].reportTime+'</td>'
                      +'<td>'+result[i].email+'</td>'
                      +"</tr>");
        //  alert(str);
          }

          //   tableInfos.innerHTML = str+'</tbody>';
         



           },
     error : function() {
          alert("异常1！");
      }
       });
       
       
  })

$(function TorF2(){
        $.ajax({
           url: "http://localhost:8080/hlw/backstage/SMSRecording",
           dataType:"json",
           success: function(result){       //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
            //  var tableInfos = document.getElementById('tab2');
       
          for(var i in result){
                $("#t2 tbody").append("<tr>"+
                      '<td>'+result[i].userId+'</td>'
                      +'<td>'+result[i].userName+'</td>'
                      +'<td>'+result[i].point+'</td>'
                      +'<td>'+result[i].reportTime+'</td>'
                      +'<td>'+result[i].phone+'</td>'
                      +"</tr>");
        //  alert(str);
          }
          
        //    tableInfos.innerHTML = str+'</tbody>';
         



           },
     error : function() {
          alert("异常1！");
      }
       });
       
       
  })
  





demo = {
    
    
   

}
