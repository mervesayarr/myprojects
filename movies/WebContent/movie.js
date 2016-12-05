function getHTTPObject() {
	var xhr = false;
	if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		try {
			xhr = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				xhr = false;
			}
		}
	}
	return xhr;
}

function grabFile(id) {

	// Construct an XMLHttpRequest object
	var request = getHTTPObject();

	// If object creation was successful, set up and make request
	if (request) {
		request.onreadystatechange = function() {
			parseResponse1(request);
		};
		var URL = "https://api.themoviedb.org/3/movie/"
				+ id
				+ "?api_key=9aa93528488a5a99362cf43c3dc0f933&language=en-US&append_to_response=images&include_image_language=en,null";
		// var URL="
		// https://api.themoviedb.org/3/search/movie?api_key=9aa93528488a5a99362cf43c3dc0f933&language=en-US&query="+id;
		request.open("GET", URL, true);
		request.setRequestHeader('Accept', 'application/json');

		request.send(null);
	}
}
function grabFileNowPlaying() {

	// Construct an XMLHttpRequest object
	var request = getHTTPObject();

	// If object creation was successful, set up and make request
	if (request) {
		request.onreadystatechange = function() {
			parseResponseNowPlaying(request);
		};
		var URL = "  https://api.themoviedb.org/3/movie/now_playing?api_key=9aa93528488a5a99362cf43c3dc0f933&language=en-US&page=1";
		// var URL="
		// https://api.themoviedb.org/3/search/movie?api_key=9aa93528488a5a99362cf43c3dc0f933&language=en-US&query="+id;
		request.open("GET", URL, true);
		request.setRequestHeader('Accept', 'application/json');

		request.send(null);
	}
}

//1. set ul width 
//2. image when click prev/next button
var ul;
var li_items;
var imageNumber;
var imageWidth;
var prev, next;
var currentPostion = 0;
var currentImage = 0;

function grabFileRecommender(filename) {

	// Construct an XMLHttpRequest object
	var request = getHTTPObject();

	// If object creation was successful, set up and make request
	if (request) {
		request.onreadystatechange = function() {
			parseResponse(request);
		};
		request.open("GET", filename, true);
		request.setRequestHeader('Accept', 'application/json');

		request.send(null);
	}
}
function parseResponseNowPlaying(request) {
	if (request.readyState == 4) {
		if (request.status == 200 || request.status == 304) {
			data = JSON.parse(request.responseText);
			console.log(data);
			var img=[];
			var result=[];
			var li=[];

			for (var i = 0; i < data.results.length; i++) {
				
				result[i] = data.results[i].poster_path;
				img[i]= document.createElement("img");
				li[i]= document.createElement("li");


			
			img[i].setAttribute("src", "https://image.tmdb.org/t/p/w160/"	+ result[i]);
			img[i].style.height = '350px';
			img[i].style.width = '300px';
			
			
			
			li[i].appendChild(img[i]);
			//var section = document.getElementById("nowplaying");

			
			
			//section.appendChild(img[i]);
			
			ul = document.getElementById('image_slider');
			
		//	li_items = ul.children;
			ul.appendChild(li[i]);
			imageNumber = li.length;
			imageWidth = li[0].children[0].clientWidth;
			ul.style.width = parseInt(imageWidth * imageNumber) + 'px';
			prev = document.getElementById("prev");
			next = document.getElementById("next");
			//.onclike = slide(-1) will be fired when onload;
			/*
			prev.onclick = function(){slide(-1);};
			next.onclick = function(){slide(1);};*/
			prev.onclick = function(){ onClickPrev();};
			next.onclick = function(){ onClickNext();};
			
			
			

			
			
			}
			

			
		}
	}
}




function animate(opts){
	var start = new Date;
	var id = setInterval(function(){
		var timePassed = new Date - start;
		var progress = timePassed / opts.duration;
		if (progress > 1){
			progress = 1;
		}
		var delta = opts.delta(progress);
		opts.step(delta);
		if (progress == 1){
			clearInterval(id);
			opts.callback();
		}
	}, opts.delay || 17);
	//return id;
}

function slideTo(imageToGo){
	var direction;
	var numOfImageToGo = Math.abs(imageToGo - currentImage);
	// slide toward left

	direction = currentImage > imageToGo ? 1 : -1;
	currentPostion = -1 * currentImage * imageWidth;
	var opts = {
		duration:1000,
		delta:function(p){return p;},
		step:function(delta){
			ul.style.left = parseInt(currentPostion + direction * delta * imageWidth * numOfImageToGo) + 'px';
		},
		callback:function(){currentImage = imageToGo;}	
	};
	animate(opts);
}

function onClickPrev(){
	if (currentImage == 0){
		slideTo(imageNumber - 1);
	} 		
	else{
		slideTo(currentImage - 1);
	}		
}

function onClickNext(){
	if (currentImage == imageNumber - 1){
		slideTo(0);
	}		
	else{
		slideTo(currentImage + 1);
	}		
}

function parseResponse1(request) {
	if (request.readyState == 4) {
		if (request.status == 200 || request.status == 304) {
			data = JSON.parse(request.responseText);

			console.log(data);
			var genre = [];
			var name;

			var img1 = document.createElement("img");

			img1.setAttribute("src", "https://image.tmdb.org/t/p/w160/"
					+ data.poster_path);
			img1.id = "resim";

			name = data.title;
			var overview = data.overview;
			var releasedate = data.release_date;

			img1.onclick = function() {

				// var section = document.getElementById("recommender");
				var poster = document.getElementById("poster");
				var genres = document.getElementById("genres");

				while (poster.firstChild) {
					poster.removeChild(poster.firstChild);
				}
				while (genres.firstChild) {
					genres.removeChild(genres.firstChild);
				}

				// section.innerHTML=name;
				poster.appendChild(this);
				this.style.height = '400px';
				this.style.width = '300px';

				var genretitle = "Film Türü  <br/>";
				for (var i = 0; i < data.genres.length; i++) {

					genre[i] = data.genres[i].name;

					genretitle += "<ul><li>" + genre[i] + "</li></ul>";
					genres.innerHTML = "Filmin Adı: " + name + "<br/>"
							+ "Yayınlanma Tarihi: " + releasedate + "<br/>"
							+ genretitle + "<br/>" + "Filmin Konusu: "
							+ overview;

				}
			};

			var section = document.getElementById("poster");

			section.appendChild(img1);

		}
	}
}
function parseResponse(request) {
	if (request.readyState == 4) {
		if (request.status == 200 || request.status == 304) {
			data = JSON.parse(request.responseText);

			var movieid = [];
			var moviename = [];
			var tmdb = [];

			console.log(data);
			//
			// for (var i = 0; i < data.posters.length; i++) {
			//					
			// movie[i]=data.posters[i].file_path;
			// var element=document.getElementById("deneme");
			// element.innerHTML=movie[i];
			// }

			// var m = data.title;
			// var element=document.getElementById("recommender");
			// element.innerHTML=m;

			var satir = 0;
			var print = "Film Tavsiyeleri <br/>"

			// var table="<tr><th colspan='4'>Film Tavsiyeleri
			// </th><tr><th>Satır</th><th>Film ID</th><th>Film Adı</th></tr>";

			for (var i = 0; i < data.movie.length; i++) {

				movieid[i] = data.movie[i].movieId;
				moviename[i] = data.movie[i].name;
				tmdb[i] = data.movie[i].tmdb;

				satir++;

				// table += "<tr><td>" +satir +"</td><td>" + movieid[i]
				// +"</td><td>" + moviename[i] +"</td></tr>"

				// print +="<ul><li><a href='#'
				// onClick='grabFile("+tmdb[i]+")'>"+data.movie[i].name+"</a></li></ul>"

				var element = document.getElementById("poster");
				// element.innerHTML=print;

				grabFile(tmdb[i]);

				while (element.hasChildNodes()) {
					element.removeChild(element.firstChild);
				}

			}

		}

	}
}

function showmovies() {
	var section = document.getElementById("poster");
	var genres = document.getElementById("genres");

	document.body.style.background = "url('images/içerik.jpg')";

	// document.body.style.backgroundColor = "black";
	document.body.style.backgroundSize = "100% 100%";

	document.body.style.opacity = "0.9";

	while (section.firstChild) {
		section.removeChild(section.firstChild);
	}
	while (genres.firstChild) {
		genres.removeChild(genres.firstChild);
	}
	var id = document.getElementById('userid').value;

	// grabFile(id);

	grabFileRecommender("/movies/rest/movies/" + id);
	// grabFileRecommender("/movies/rest/movies/m/1","moviename") ;

	// while(section.hasChildNodes() && genres.hasChildNodes())
	// {
	// section.removeChild(section.firstChild);
	// genres.removeChild(genres.firstChild);
	//
	// }

}
function searchmovie() {
	var section = document.getElementById("poster");
	var genres = document.getElementById("genres");

	// document.body.style.backgroundColor = "black";
	document.body.style.background = "url('images/searchback.jpg')";
	document.body.style.backgroundSize = "100% 100%";

	document.body.style.opacity = "0.9";

	while (section.firstChild) {
		section.removeChild(section.firstChild);
	}
	while (genres.firstChild) {
		genres.removeChild(genres.firstChild);
	}
	var title = document.getElementById('searchname').value;
	grabFileRecommender("/movies/rest/movies/title/" + title);

}

window.onload = function() {
	grabFileNowPlaying();
}
