angular
    .module('photify')
    .service('albumService', ['$http',albumService]);

function albumService(http) {
	this.createAlbum = function(albumName, userKey){
		http.post('/addalbum', {album_name:albumName,user_key:userKey}).
		  success(function(data, status, headers, config) {
		    // this callback will be called asynchronously
		    // when the response is available
		  }).
		  error(function(data, status, headers, config) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
	}
	
	this.listAlbums = function(userKey){
		return http.get('/album/get_album/' + userKey+"/1").
		  success(function(data, status, headers, config) {
			  return data;
		  }).
		  error(function(data, status, headers, config) {
			  return "error";
		  });
	}
}