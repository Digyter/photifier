<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<div class="album_info">
	<span class="title">Album 1</span>
	<button type="button" class="btn btn-primary" ng-click="openShareModal()">
		Share
	</button>
</div>
<div class="image_list">
	<img src="/images/blue_plus.png" alt="140x140" class="img-thumbnail" ng-click="openAddImageModal()" />
	<img class="img-thumbnail" ng-repeat="image in imageList" src="{{image.url}}" ng-click="setPreviewImageUrl(image)" />
</div>