angular.module('photify').service('imageService', [ '$http', imageService ]);

function imageService(http) {
	this.addImage = function(albumKey, userKey) {
		http.post('/addimage', {
			album_key : albumKey,
			user_key : userKey
		}).success(function(data, status, headers, config) {
			// this callback will be called asynchronously
			// when the response is available
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});
	}
	
	this.listImages = function(userkey, albumKey) {
		return http.get('/image/get_image_by_album/'+userkey+'/' + albumKey).success(
				function(data, status, headers, config) {
					return data;
				}).error(function(data, status, headers, config) {
			return "error";
		});
	}
}