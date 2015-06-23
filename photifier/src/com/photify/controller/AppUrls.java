package com.photify.controller;

import scenic3.UrlsImpl;

import com.photify.controller.matcher.AlbumPageMatcher;
import com.photify.controller.matcher.FrontPageMatcher;
import com.photify.controller.matcher.ImagePageMatcher;

public class AppUrls extends UrlsImpl {

    public AppUrls() {
        excludes("/css/*","/lib/**","/components/**");
        excludes("/js/**","/images/**","/modals/album/*","/modals/image*");
        add(AlbumPageMatcher.get());
        add(ImagePageMatcher.get());
        add(FrontPageMatcher.get());
    }
}