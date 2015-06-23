angular
	.module('photify')
	.controller('albumModalController',['$scope', '$modalInstance', albumModalController]);

function albumModalController(scope, modalInstance){

	scope.cancel = function () {
		modalInstance.close();
	};
}