package com.photify;

import org.slim3.controller.Navigation;

import scenic3.ScenicPage;
import scenic3.annotation.ActionPath;
import scenic3.annotation.Default;
import scenic3.annotation.Page;

@Page("/modals")
public class ModalPage extends ScenicPage {

    @ActionPath("album/*")
    public Navigation create_album() {
        return forward("/modals/album/create_album.jsp");
    }
       
    @Default
    public Navigation index() {
        return forward("/index.jsp");
    }
}