angular
	.module('photify')
	.controller('imageModalController',['$scope', '$modalInstance', 'albumList', imageModalController]);

function imageModalController(scope, modalInstance, albumList){
	scope.albumList = albumList;
	
	scope.cancel = function () {
		modalInstance.close();
	};
}