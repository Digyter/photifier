<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<div class="album_list">
	<div class="leftBarHeader">
		<span class="title">Albums </span>
		<button type="button" class="btn btn-primary" ng-click="openCreateAlbumModal()">
	    	New
	    </button>
	</div>
	<span class="btn btn-default" ng-repeat="album in albumList">
		{{album.name}}
		<button type="button" class="close" aria-label="Close" ng-click="openDeleteAlbumModal(1,1)"><span aria-hidden="true">&times;</span></button>
	</span>
</div>