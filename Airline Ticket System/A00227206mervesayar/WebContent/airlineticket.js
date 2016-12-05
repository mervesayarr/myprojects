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

function grabFile(filename,type) {
	
	//Construct an XMLHttpRequest object	
	var request = getHTTPObject();
	
	//If object creation was successful, set up and make request
	if (request) {
		request.onreadystatechange = function() {
			parseResponse(request,type);
		};
		request.open("GET", filename, true);
		request.setRequestHeader('Accept','application/json');
		request.send(null);
	}
	
}
function grabFileDelete(filename) {
	
	//Construct an XMLHttpRequest object	
	var request = getHTTPObject();
	
	//If object creation was successful, set up and make request
	if (request) {
		
		request.open("DELETE", filename, true);
		request.setRequestHeader('Accept','application/json');
		request.send(null);
		
	}
	alert ("Cancelled" );
}		
var seatno=[]; 
function parseResponse(request,type) {
	if (request.readyState == 4) {
		if (request.status == 200 || request.status == 304) {
			
			var data = JSON.parse(request.responseText);
			
			
			 var table="<tr><th colspan='6'>Customer Information </th><tr><th>ID</th><th>First Name</th><th>Last Name</th><th>From</th><th>To</th><th>Date</th></tr>";

			
			var customerid=document.getElementById('customerid');
			var fid=document.getElementById('fid');
			
			if(type=="showcustomer"){
				var cid=data.customer.id;
				customerid.value=cid;
				var fid=data.customer.flight.fid;
				fid.value=data.customer.flight.fid;
				
				var fname=data.customer.fname;
				var lname=data.customer.lname;
				var from=data.customer.flight.from;
				var to=data.customer.flight.to;
				var date=data.customer.flight.date;
				console.log(data);
				
				table += "<tr><td>" + cid +"</td><td>" + fname + "</td><td>" + lname + 
				"</td><td>"+ from +"</td><td>"+ to +"</td><td>" +date +"</td></tr>"
				
				
				var element=document.getElementById("showcustomertable");
				element.innerHTML=table;
			}
			
			if(type=="searchcustomer"){
			var cid=data.customer.id;
			customerid.value=cid;
			
			
			}
			
			if(type=="flightid")
			{
			fid.value=data.flight.fid;
			console.log(data.flight.fid);
			console.log(fid.value);
			
			}
			
			if(type=="showflights"){
				var flightid=[];
				var flightfrom=[];
				var flightto=[];
				var flightdate=[];
				var flighttext;
				
		 var table="<tr><th colspan='4'>Flights </th><tr><th>ID</th><th>From</th><th>To</th><th>Date</th></tr>";
			
		 for (var i = 0; i < data.flight.length; i++) {
				
				flightid[i]=data.flight[i].fid;
				flightfrom[i]=data.flight[i].from;
				flightto[i]=data.flight[i].to;
				flightdate[i]=data.flight[i].date;
				
				 flightidtext=document.createTextNode("ID: :"+flightid[i]);
				 flightfromtext=document.createTextNode("From:"+flightfrom[i]);
				 flighttotext=document.createTextNode("To:"+flightto[i]);
				 flightdatetext=document.createTextNode("Date:"+flightdate[i]);
				 
				
				 table += "<tr><td>" + flightid[i] +"</td><td>" + flightfrom[i] + "</td><td>"+
				 flightto[i] +"</td><td>"+
				 flightdate[i] +"</td></tr>"
				
				var element=document.getElementById("table");
				element.innerHTML=table;
				
			
			
				 
			}
			
			}
			
				
			
			
		}
	}
}


function seat(){
	
	
	var seattext=document.getElementById('seatno');
	var cabintext=document.getElementById('cabintype');
	var pricetext=document.getElementById('price');
	
	if(document.getElementById('1A').checked){
		seattext.value="1A";
		cabintext.value="Business";
		pricetext.value="500";
		
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	
	else if(document.getElementById('1B').checked){
		seattext.value="1B";
		cabintext.value="Business";
		pricetext.value="500";
		document.getElementById('1A').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
		
		
	}
	
	 else  if(document.getElementById('1C').checked){
		seattext.value="1C";
		cabintext.value="Business";
		pricetext.value="500";
		document.getElementById('1A').checked=false;
		document.getElementById('1B').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	
	  else	 if(document.getElementById('1D').checked){
		seattext.value="1D";
		cabintext.value="Business";
		pricetext.value="500";
		document.getElementById('1A').checked=false;
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	 else if(document.getElementById('1E').checked){
		seattext.value="1E";
		cabintext.value="Business";
		pricetext.value="500";
		document.getElementById('1A').checked=false;
		document.getElementById('1B').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	
	 else if(document.getElementById('1F').checked){
		seattext.value="1F";
		cabintext.value="Business";
		pricetext.value="500";
		document.getElementById('1A').checked=false;
		document.getElementById('1B').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	else if(document.getElementById('2A').checked){
		seattext.value="2A";
		cabintext.value="Business";
		pricetext.value="500";
		document.getElementById('1B').checked=false;
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('1A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	
	else if(document.getElementById('2B').checked){
		seattext.value="2B";
		cabintext.value="Business";
		pricetext.value="500";
		document.getElementById('1A').checked=false;
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		
		document.getElementById('2A').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	
	else if(document.getElementById('2C').checked){
		seattext.value="2C";
		cabintext.value="Business";
		pricetext.value="500";
		document.getElementById('1A').checked=false;
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	
	 else	 if(document.getElementById('2D').checked){
		seattext.value="2D";
		cabintext.value="Business";
		pricetext.value="500";
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('1A').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	 else if(document.getElementById('2E').checked){
		seattext.value="2E";
		cabintext.value="Business";
		pricetext.value="500";
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('1A').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	
	 else if(document.getElementById('2F').checked){
		seattext.value="2F";
		cabintext.value="Business";
		pricetext.value="500";
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('1A').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	 else if(document.getElementById('3A').checked){
		seattext.value="3A";
		cabintext.value="Economy";
		pricetext.value="100";
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('1A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
		
	}
	
	 else if(document.getElementById('3B').checked){
		seattext.value="3B";
		cabintext.value="Economy";
		pricetext.value="100";
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('1A').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	
	 else if(document.getElementById('3C').checked){
		seattext.value="3C";
		cabintext.value="Economy";
		pricetext.value="100";
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('1A').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
		
	}
	
	 else if(document.getElementById('3D').checked){
		seattext.value="3D";
		cabintext.value="Economy";
		pricetext.value="100";
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('1A').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	 else if(document.getElementById('3E').checked){
		seattext.value="3E";
		cabintext.value="Economy";
		pricetext.value="100";
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('1A').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	
	 else if(document.getElementById('3F').checked){
		seattext.value="3F";
		cabintext.value="Economy";
		pricetext.value="100";
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('1A').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	 else if(document.getElementById('4A').checked){
		seattext.value="4A";
		cabintext.value="Economy";
		pricetext.value="100";
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('1A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
	}
		

	 else if(document.getElementById('4B').checked){
		seattext.value="4B";
		cabintext.value="Economy";
		pricetext.value="100";
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('1A').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	
	 else if(document.getElementById('4C').checked){
		seattext.value="4C";
		cabintext.value="Economy";
		pricetext.value="100";
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('1A').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	
	 else if(document.getElementById('4D').checked){
		seattext.value="4D";
		cabintext.value="Economy";
		pricetext.value="100";
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('1A').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	 else if(document.getElementById('4E').checked){
		seattext.value="4E";
		cabintext.value="Economy";
		pricetext.value="100";
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('1A').checked=false;
		document.getElementById('4F').checked=false;
		
	}
	
	 else if(document.getElementById('4F').checked){
		seattext.value="4F";
		cabintext.value="Economy";
		pricetext.value="100";
		document.getElementById('1B').checked=false;
		document.getElementById('1C').checked=false;
		document.getElementById('1D').checked=false;
		document.getElementById('1E').checked=false;
		document.getElementById('1F').checked=false;
		document.getElementById('2A').checked=false;
		document.getElementById('2B').checked=false;
		document.getElementById('2C').checked=false;
		document.getElementById('2D').checked=false;
		document.getElementById('2E').checked=false;
		document.getElementById('2F').checked=false;
		document.getElementById('3A').checked=false;
		document.getElementById('3B').checked=false;
		document.getElementById('3C').checked=false;
		document.getElementById('3D').checked=false;
		document.getElementById('3E').checked=false;
		document.getElementById('3F').checked=false;
		document.getElementById('4A').checked=false;
		document.getElementById('4B').checked=false;
		document.getElementById('4C').checked=false;
		document.getElementById('4D').checked=false;
		document.getElementById('4E').checked=false;
		document.getElementById('1A').checked=false;
		
	}
	 else{
		 seattext.value="";
			cabintext.value="";
			pricetext.value="";
	 }
		 
	
}


function showflights()
{
	grabFile("/A00227206mervesayar/rest/flights","showflights");
	
			
		
    
}
function searchcustomer()
{
	var firstname=document.getElementById('fname');
	var fname=firstname.value;
	var lastname=document.getElementById('lname');
	var lname=lastname.value;
	
	
grabFile("/A00227206mervesayar/rest/customers/"+fname+"/"+lname,"searchcustomer");
	
    
}
function searchcustomer2()
{
	var firstname=document.getElementById('firstname');
	var fname=firstname.value;
	var lastname=document.getElementById('lastname');
	var lname=lastname.value;
	
	
grabFile("/A00227206mervesayar/rest/customers/"+fname+"/"+lname,"searchcustomer");
	
    
}
function calldelete()
{

	var firstname=document.getElementById('fname').value;
	
	var lastname=document.getElementById('lname').value;
	
	
		grabFile("/A00227206mervesayar/rest/customers/"+firstname+"/"+lastname,"searchcustomer");
		var cid=document.getElementById('customerid').value;
		
			grabFileDelete("/A00227206mervesayar/rest/customers/"+cid);
			return false;

		
    
}

function showcustomer()
{

	var firstname=document.getElementById('firstname').value;
	
	var lastname=document.getElementById('lastname').value;
	
	
		
		grabFile("/A00227206mervesayar/rest/customers/"+firstname+"/"+lastname,"showcustomer");
		
	
		
    
}
function deleteflight()
{
	var fid=document.getElementById('flightId').value;
	
	grabFileDelete("/A00227206mervesayar/rest/flights/"+fid);

			return false;
 
}
function getDate() {
   
   
    document.getElementById("date").value;
    document.getElementById('from').style.display="block";
    document.getElementById('to').style.display="block";
}
function OnSelectionChange (select) {
	var date=document.getElementById('date').value;
	var from=document.getElementById('from').value;
	
    var selectedOption = select.options[select.selectedIndex];
    
    grabFile("/A00227206mervesayar/rest/flights/"+from+"/"+selectedOption.value+"/"+date,"flightid");
    
    var fid=document.getElementById('fid').value;
    document.getElementById('form').style.display="block";
  // alert ("The selected option is " + selectedOption.value);
}
function showseat() {
	 document.getElementById('showseat');
	    document.getElementById('plane').style.display="block";
	 
	   
	 
}

function calander() {
    var day = new Date();
    var d= day.toDateString();
   
    document.getElementById("calander").innerHTML = d;
}
//function prepareLinks()
//{
//	var links = document.getElementById("myclick");
//	
//    for (var i=0; i<links.length; i++){
//		links[i].onclick=function(){
//			grabFile("/A00227206mervesayar/rest/flights","link");
//
//			return false;
//		}
//    }
//}
window.onload=function(){

	//prepareLinks();
	

	
	calander();
}
