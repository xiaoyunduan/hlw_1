
	$(function TorF(){
        $.ajax({
           url: "http://localhost:8080/hlw/backstage/judge",
           dataType:"json",
           success: function(result){       //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
            
         
           if(result.level_id!=0){
        	   $('#a1').attr('href','javascript:return false');
        	   $('#a2').attr('href','javascript:return false');
        	  	$("#a1").text('');
        	  	$("#a2").text('');
        	  	$("#a3").text('');
        	  	      	   
               }
              if(result.level_id==0){
               	$("#rHistory").text('');
               	getAllUser();
               	}
                if(result.level_id==1){
               		receivedReportHistory();
               	}
               	 if(result.level_id==2){
               		getReportHistory();  
               	}
               
         
          //   tableInfos.innerHTML = str+'</tbody>';
         



           },
     error : function() {
          alert("异常1！");
      }
       });
       
       
  })