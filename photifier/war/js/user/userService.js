angular
    .module('photify')
    .service('userService', ['$http',userService]);

function userService(http) {
	var userDetails = {
			user : {},
			signinUrl : ""			
	};	
	this.getUserDetails = function(){	
		return http.get('/login').
		  success(function(data, status, headers, config) {			  
			  if(data.user){				  
				  userDetails.user =  data.user;
				  userDetails.signinUrl = null;
			  }else{
				  userDetails.signinUrl = data.signinUrl;
			  }	  
			  return userDetails;
		  }).
		  error(function(data, status, headers, config) {
			  return "error";
		  });
	}
}