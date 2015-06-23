angular
	.module('photify')
	.controller('galleryController',['$scope', '$rootScope', '$modal', 'albumService', 'imageService', 'userService', galleryController]);

function galleryController(scope,rootScope,modal, albumService, imageService, userService){
	scope.albumList = [];
	scope.imageList = [];
	scope.currentImageUrl = '';
	scope.isLoggedIn = false;
	
	//get user details
	userService.getUserDetails().then(function(response){		
		if(response.data){			
			userDetails = response.data;
			if(false){
				scope.isLoggedIn = false;
				window.location.href = userDetails.signinUrl;	
			}else{
				scope.isLoggedIn = true;
				
				//retrieve albums
				albumService.listAlbums(1,1).then(function(response){
					scope.albumList = response.data;
				});
				
				//retrieve images
				imageService.listImages(1,1).then(function(response){
					scope.imageList = response.data;
				});
			}		
		}
	});

	
	scope.openCreateAlbumModal = function(){
		var modalInstance = modal.open({
			animation: scope.animationsEnabled,
			templateUrl: 'modals/album/create_album.html',
			controller: 'albumModalController'
		});
	}
	
	scope.openDeleteAlbumModal = function(){
		var modalInstance = modal.open({
			animation: scope.animationsEnabled,
			templateUrl: 'modals/album/delete_album.html',
			controller: 'albumModalController'
		});
	}
	
	scope.openAddImageModal = function(){
		var modalInstance = modal.open({
			animation: scope.animationsEnabled,
			templateUrl: 'modals/image/add_image.html',
			controller: 'imageModalController',
			resolve:{
				albumList: function(){
					return scope.albumList;
				}
			}
		});
	}
	
	scope.setPreviewImageUrl = function(image){
		scope.currentImageUrl = image.url;
	}
}