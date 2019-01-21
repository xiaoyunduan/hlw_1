 var dates=[];
 var sum=[];
 var areasData;
function TorF(){
	var data={};
        $.ajax({
            type: "POST",  
        	async: false,  
           url: "http://localhost:8080/hlw/backstage/statistics",
           dataType:"json",
           success: function(result){       //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中

             if(result.err!=null){
             	alert(result.err);
             }else{
             	data.dates=result.dates;
             data.sum=result.sum;
             data.areasData=result.areasData;
             data.p1=result.p1;
             data.p2=result.p2;
             }
             
//             alert(data.p1);
         
           },
     error : function() {
          alert("异常1！");
      }
       });
       return data;
       
  }
  



type = ['','info','success','warning','danger','diff'];

	 
demo = {

    initPickColor: function(){
        $('.pick-class-label').click(function(){
            var new_class = $(this).attr('new-class');
            var old_class = $('#display-buttons').attr('data-class');
            var display_div = $('#display-buttons');
            if(display_div.length) {
            var display_buttons = display_div.find('.btn');
            display_buttons.removeClass(old_class);
            display_buttons.addClass(new_class);
            display_div.attr('data-class', new_class);
            }
        });
    },
  
    initChartist: function(){
     var data=TorF();
      
//       alert(data.dates);
        var dataSales = {
          labels: data.dates,
          series: [
             data.sum,
           
          ]
        };

        var optionsSales = {
          lineSmooth: false,
          low: 0,
          high: 20,
          showArea: true,
          height: "245px",
          axisX: {
            showGrid: false,
          },
          lineSmooth: Chartist.Interpolation.simple({
            divisor: 3
          }),
          showLine: true,
          showPoint: false,
        };

        var responsiveSales = [
          ['screen and (max-width: 640px)', {
            axisX: {
              labelInterpolationFnc: function (value) {
                return value[0];
              }
            }
          }]
        ];

        Chartist.Line('#chartHours', dataSales, optionsSales, responsiveSales);


        var data = {
          labels: data.dates,
          series: data.areasData
        };
			
        var options = {
            seriesBarDistance: 10,
            high: 5,
            axisX: {
                showGrid: false
            },
            height: "245px"
        };

        var responsiveOptions = [
          ['screen and (max-width: 640px)', {
            seriesBarDistance: 5,
            axisX: {
              labelInterpolationFnc: function (value) {
                return value[0];
              }
            }
          }]
        ];
		
        Chartist.Line('#chartActivity', data, options, responsiveOptions);
        var data=TorF();
        var dataPreferences = {
            series: [
                 data.p1,
            ]
        };

        var optionsPreferences = {
            donut: true,
            donutWidth: 40,
            startAngle: 0,
            total: 100,
            showLabel: false,
            axisX: {
                showGrid: false
            }
        };

        Chartist.Pie('#chartPreferences', dataPreferences, optionsPreferences);
		
        Chartist.Pie('#chartPreferences', {
          labels: data.p2,
          series: data.p1
        });
    },

 

	showNotification: function(from, align){
    	color = Math.floor((Math.random() * 4) + 1);

    	$.notify({
        	icon: "ti-gift",
        	message: "近期数据统计"

        },{
            type: type[color],
            timer: 4000,
            placement: {
                from: from,
                align: align
            }
        });
	},
   

}
