function getDistanceFromLatLonInKm(lat1,lon1,lat2,lon2) {
  var R = 6371; // Radius of the earth in km
  var dLat = deg2rad(lat2-lat1);  // deg2rad below
  var dLon = deg2rad(lon2-lon1); 
  var a = 
    Math.sin(dLat/2) * Math.sin(dLat/2) +
    Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
    Math.sin(dLon/2) * Math.sin(dLon/2)
    ; 
  var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
  var d = R * c; // Distance in km
  return d;
}

function deg2rad(deg) {
  return deg * (Math.PI/180)
}

function getHTTPObject() {
  var xhr = false;
  if (window.XMLHttpRequest) {
    xhr = new XMLHttpRequest();
  } else if (window.ActiveXObject) {
    try {
      xhr = new ActiveXObject("Msxml2.XMLHTTP");
    } catch(e) {
      try {
        xhr = new ActiveXObject("Microsoft.XMLHTTP");
      } catch(e) {
        xhr = false;
      }
    }
  }
  return xhr;
}
function grabFile() {
  var request = getHTTPObject();
  if (request) {
    request.onreadystatechange = function() {
      parseResponse(request);
    };
	var city=document.getElementById("city").value;

	var URL="http://api.openweathermap.org/data/2.5/forecast/daily?q="+city+"&mode=xml&units=metric&cnt=7&appid=f82972d22dac9c1f4cc66685e2bc91ff"
    request.open("GET", URL, true);
    request.send(null);
  }
}
function parseResponse(request) {
	if (request.readyState == 4) {
    if (request.status == 200 || request.status == 304) {
      var data = request.responseXML;
      
	  var name = data.getElementsByTagName("name")[0].firstChild.nodeValue;
      var country = data.getElementsByTagName("country")[0].firstChild.nodeValue;
	  var lat1 = data.getElementsByTagName("location")[1].getAttribute("latitude"); 
	  var long1 = data.getElementsByTagName("location")[1].getAttribute("longitude"); 
      
	  var location = getDistanceFromLatLonInKm(lat1,long1,53.433331,-7.95);
	 
      
    var para = document.createElement("p");
	var parac = document.createElement("p");
	var paral = document.createElement("p");
	var currenttemp=document.createElement("p");
	var currentweather=document.createElement("p");

    var text = document.createTextNode(name+" "+" ( "+country+" )"); 
	var textl = document.createTextNode(parseFloat(location).toFixed(3)+"km");
		 
	
      para.appendChild(text);
	  paral.appendChild(textl);
	 
	  
	 
     var day1=[];var day2=[];var day3=[];var day4=[];var day5=[];var day6=[];var day7=[];
	 var max=[];
	 var min=[];
	 var hum=[];
	
	
   
    var x = data.getElementsByTagName("time");
 
	for (j = 0; j <x.length; j++) { 
    max[j]=x[j].getElementsByTagName("temperature")[0].getAttribute("max");
	min[j]=x[j].getElementsByTagName("temperature")[0].getAttribute("min");
	hum[j]=x[j].getElementsByTagName("humidity")[0].getAttribute("value");
  }
  
	var t1=max[0];var t2=max[1];var t3=max[2];var t4=max[3];var t5=max[4];var t6=max[5];var t7=max[6];
	var m1=min[0];var m2=min[1];var m3=min[2];var m4=min[3];var m5=min[4];var m6=min[5];var m7=min[6];
	var h1=hum[0];var h2=hum[1];var h3=hum[2];var h4=hum[3];var h5=hum[4];var h6=hum[5];var h7=hum[6];
	
     day1.push(x[0].getAttribute("day"));
	 day2.push(x[1].getAttribute("day"));
	 day3.push(x[2].getAttribute("day"));
	 day4.push(x[3].getAttribute("day"));
	 day5.push(x[4].getAttribute("day"));
	 day6.push(x[5].getAttribute("day"));
	 day7.push(x[6].getAttribute("day"));
	 
	var textcurrent=document.createTextNode( "Temperature:"+x[0].getElementsByTagName("temperature")[0].getAttribute("day")+" °C");
	var textcurrentweather=document.createTextNode( x[0].getElementsByTagName("symbol")[0].getAttribute("name"));

	 currenttemp.appendChild(textcurrent);
 	 currentweather.appendChild(textcurrentweather);

	 
	 
      var details = document.getElementById("para");
	  
      while (details.hasChildNodes()) {
        details.removeChild(details.lastChild);
      }
      details.appendChild(para);
	  details.appendChild(paral);
	  details.appendChild(currenttemp);
	  details.appendChild(currentweather);
	  
	  var imgdirection;
	  var direction=x[0].getElementsByTagName("windDirection")[0].getAttribute("name");
	  
	  if(direction=="West-southwest"){
		  imgdirection="<img src='images/sw.png' height='30' width='30' />";
	  }
	 
	  else if(direction=="West"){
		  imgdirection="<img src='images/w.png' height='30' width='30' />";
	  }
	  else if(direction=="North"){
		  imgdirection="<img src='images/n.png' height='30' width='30' />";
	  }
	  else if(direction=="North-northwest"){
		  imgdirection="<img src='images/nw.png' height='30' width='30' />";
	  }
	  else if(direction=="West-northwest"){
		  imgdirection="<img src='images/nw.png' height='30' width='30' />";
	  }
	  else if(direction=="South"){
		  imgdirection="<img src='images/s.png' height='30' width='30' />";
	  }
	  else if(direction=="SouthEast"){
		  imgdirection="<img src='images/se.png' height='30' width='30' />";
	  }
	  else if(direction=="East"){
		  imgdirection="<img src='images/e.png' height='30' width='30' />";
	  }
	  else if(direction=="NorthEast"){
		  imgdirection="<img src='images/ne.png' height='30' width='30' />";
	  }
	  else if(direction=="South-southwest"){
		  imgdirection="<img src='images/sw.png' height='30' width='30' />";
	  }
	  else if(direction=="South-southeast"){
		  imgdirection="<img src='images/se.png' height='30' width='30' />";
	  }
	  
	   var wind="<tr><th colspan ='2'>WIND DIRECTION</th></tr><tr><th>Name</th><th>Direction</th></tr>";
       wind+= "<tr><th>"+x[0].getElementsByTagName("windSpeed")[0].getAttribute("name")+"</th><th>"+
       imgdirection+"</th></tr>";
	
	 document.getElementById("table").innerHTML = wind; 
	 
	var cweather=x[0].getElementsByTagName("symbol")[0].getAttribute("name");
	var rain = cweather.indexOf("rain");
	var clearsky = cweather.indexOf("sky");
	var scattered = cweather.indexOf("scattered");
	var snow = cweather.indexOf("snow");
	var fewcloud = cweather.indexOf("few");
	
	if(rain> -1){
	document.body.style.background = "url('images/rain1.gif')";
	document.body.style.backgroundSize = "100% 100%";
	document.getElementById("weatherbutton").style.background="#333"
	document.getElementById("h2").style.color="#0033FF";
	}
	else if(clearsky> -1){
	document.body.style.background = "url('images/clearsky.gif')";
		 document.body.style.backgroundSize = "100% 100%";
		document.getElementById("weatherbutton").style.background="#0033FF";
		document.getElementById("h2").style.color="#0033FF";
	}
	else if(scattered> -1){
	document.body.style.background = "url('images/scattered.gif')";
		 document.body.style.backgroundSize = "100% 100%";
		 document.getElementById("weatherbutton").style.background="#333"
		 document.getElementById("h2").style.color="#0033FF";
		
	}   

		else if(snow> -1){
	document.body.style.background = "url('images/snow.gif')";
		 document.body.style.backgroundSize = "100% 100%";
		 document.getElementById("weatherbutton").style.background="#333"
		 document.getElementById("h2").style.color="#0033FF";
		
	}  
	
	else if(fewcloud> -1){
	document.body.style.background = "url('images/clearsky.gif')";
		 document.body.style.backgroundSize = "100% 100%";
		 document.getElementById("weatherbutton").style.background="#333"
		 document.getElementById("h2").style.color="#0033FF";
		
	}  
	else{
		document.body.style.background = "url('images/background.jpg')";
		document.getElementById("weatherbutton").style.background="#4CAF50"
		document.getElementById("h2").style.color="#0033FF";
	}
    }
	}
	
	
	/**
 * Dark theme for Highcharts JS
 * @author Torstein Honsi
 */

Highcharts.createElement('link', {
   href: '//fonts.googleapis.com/css?family=Unica+One',
   rel: 'stylesheet',
   type: 'text/css'
}, null, document.getElementsByTagName('head')[0]);

Highcharts.theme = {
   colors: ["#2b908f", "#90ee7e", "#f45b5b", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee",
      "#55BF3B", "#DF5353", "#7798BF", "#aaeeee","rgba(0, 0, 0, 0.6)"],
   chart: {
      backgroundColor: {
         linearGradient: { x1: 0, y1: 0, x2: 1, y2: 1 },
         stops: [
            [0, 'rgba(0, 0, 0, 0.6)'],
            [1, '#3e3e40']
         ]
      },
      style: {
         fontFamily: "'Unica One', sans-serif"
      },
      plotBorderColor: '#606063'
   },
   title: {
      style: {
         color: '#E0E0E3',
         textTransform: 'uppercase',
         fontSize: '20px'
      }
   },
   subtitle: {
      style: {
         color: '#E0E0E3',
         textTransform: 'uppercase'
      }
   },
   xAxis: {
      gridLineColor: '#707073',
      labels: {
         style: {
            color: '#E0E0E3'
         }
      },
      lineColor: '#707073',
      minorGridLineColor: '#505053',
      tickColor: '#707073',
      title: {
         style: {
            color: '#A0A0A3'

         }
      }
   },
   yAxis: {
      gridLineColor: '#707073',
      labels: {
         style: {
            color: '#E0E0E3'
         }
      },
      lineColor: '#707073',
      minorGridLineColor: '#505053',
      tickColor: '#707073',
      tickWidth: 1,
      title: {
         style: {
            color: '#A0A0A3'
         }
      }
   },
   tooltip: {
      backgroundColor: 'rgba(0, 0, 0, 0.85)',
      style: {
         color: '#F0F0F0'
      }
   },
   plotOptions: {
      series: {
         dataLabels: {
            color: '#B0B0B3'
         },
         marker: {
            lineColor: '#333'
         }
      },
      boxplot: {
         fillColor: '#505053'
      },
      candlestick: {
         lineColor: 'white'
      },
      errorbar: {
         color: 'white'
      }
   },
   legend: {
      itemStyle: {
         color: '#E0E0E3'
      },
      itemHoverStyle: {
         color: '#FFF'
      },
      itemHiddenStyle: {
         color: '#606063'
      }
   },
   credits: {
      style: {
         color: '#666'
      }
   },
   labels: {
      style: {
         color: '#707073'
      }
   },

   drilldown: {
      activeAxisLabelStyle: {
         color: '#F0F0F3'
      },
      activeDataLabelStyle: {
         color: '#F0F0F3'
      }
   },

   navigation: {
      buttonOptions: {
         symbolStroke: '#DDDDDD',
         theme: {
            fill: '#505053'
         }
      }
   },

   // scroll charts
   rangeSelector: {
      buttonTheme: {
         fill: '#505053',
         stroke: '#000000',
         style: {
            color: '#CCC'
         },
         states: {
            hover: {
               fill: '#707073',
               stroke: '#000000',
               style: {
                  color: 'white'
               }
            },
            select: {
               fill: '#000003',
               stroke: '#000000',
               style: {
                  color: 'white'
               }
            }
         }
      },
      inputBoxBorderColor: '#505053',
      inputStyle: {
         backgroundColor: '#333',
         color: 'silver'
      },
      labelStyle: {
         color: 'silver'
      }
   },

   navigator: {
      handles: {
         backgroundColor: '#666',
         borderColor: '#AAA'
      },
      outlineColor: '#CCC',
      maskFill: 'rgba(255,255,255,0.1)',
      series: {
         color: '#7798BF',
         lineColor: '#A6C7ED'
      },
      xAxis: {
         gridLineColor: '#505053'
      }
   },

   scrollbar: {
      barBackgroundColor: '#808083',
      barBorderColor: '#808083',
      buttonArrowColor: '#CCC',
      buttonBackgroundColor: '#606063',
      buttonBorderColor: '#606063',
      rifleColor: '#FFF',
      trackBackgroundColor: '#404043',
      trackBorderColor: '#404043'
   },

   // special colors for some of the
   legendBackgroundColor: 'rgba(0, 0, 0, 0.5)',
   background2: '#505053',
   dataLabelsColor: '#B0B0B3',
   textColor: '#C0C0C0',
   contrastTextColor: '#F0F0F3',
   maskColor: 'rgba(255,255,255,0.3)'
};

Highcharts.setOptions(Highcharts.theme);

	$(function () {
		
    $('#container').highcharts({
        chart: {
            type: 'spline'
			
        },
        title: {
            text: '7 Days Average Temperature'
        },
        
        xAxis: {
            categories:[day1,day2,day3,day4,day5,day6,day7]
        },
        yAxis: {
            title: {
                text: 'Temperature'
            },
            labels: {
                formatter: function () {
                    return this.value + '°';
                }
            }
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        plotOptions: {
            spline: {
                marker: {
                    radius: 4,
                    lineColor: '#666666',
                    lineWidth: 1
                }
            }
        },
        series: [{
            name: name +' Max Temperature',
            marker: {
                symbol: 'square'
            },
            data:[parseFloat(t1),parseFloat(t2), parseFloat(t3), parseFloat(t4), parseFloat(t5), parseFloat(t6), parseFloat(t7)]

				
        },
		{
            name: name+' Min Temperature',
            marker: {
                symbol: 'diamond'
            },
            data: [parseFloat(m1),
                
            parseFloat(m2),parseFloat(m3), parseFloat(m4), parseFloat(m5), parseFloat(m6), parseFloat(m7)]
        }
		]
    });
});

$(function () {
    $('#pie').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Rate of Humidity'
        },
		subtitle: {
            text: 'City: '+name,
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.y}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: Humidity : {point.y} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            name: 'City '+name,
            colorByPoint: true,
            data: [{
                name: day1,
                y: parseFloat(h1),
				sliced: true,
                selected: true
            }, {
                name: day2,
                y: parseFloat(h2),
                
            }, {
                name: day3,
                y: parseFloat(h3)
            }, {
                name: day4,
                y: parseFloat(h4)
            }, {
                name: day5,
                y: parseFloat(h5)
            }, {
                name: day6,
                y: parseFloat(h6)
            },
			{
                name: day7,
                y: parseFloat(h7)
            }]
        }]
    });
});

}