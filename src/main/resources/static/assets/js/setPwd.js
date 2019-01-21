

 
function setPwd(){
 
 $.ajax({
           url: "http://localhost:8080/hlw/backstage/setPwd",
           type: "POST", 
           dataType:"text",
           
           data: $('#f1').serialize(),
           
//        
           success: function(result){     
//          
            alert(result);
//     
          },


     error : function() {
          alert("异常！!");
      }
       });     
} 
  
 
   

