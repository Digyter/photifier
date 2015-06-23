package com.photify.controller;

// Controller for com.photify.FrontPage#addAlbum
// @javax.annotation.Generated
public final class _addalbum$$POST extends scenic3.ScenicController {

    private final com.photify.FrontPage page;

    public _addalbum$$POST() {
        this.page = new com.photify.FrontPage();
    }

    @Override
    public final org.slim3.controller.Navigation setUp() {
        setupPage(page);
        return super.setUp();
    }

    @Override
    public final org.slim3.controller.Navigation run() throws Exception {
        return page.addAlbum();
    }

    @Override
    public final com.photify.FrontPage getPage() {
        return this.page;
    }

    @Override
    protected final org.slim3.controller.Navigation handleError(Throwable error) throws Throwable {
        return page.handleError(error);
    }

    @Override
    public final String getActionMethodName() {
        return "addAlbum";
    }

    // Override for REST
    @Override
    protected boolean isGet() {
        return false;
    }

    // Override for REST
    @Override
    protected boolean isPost() {
        return true;
    }

    // Override for REST
    @Override
    protected boolean isPut() {
        return false;
    }

    // Override for REST
    @Override
    protected boolean isDelete() {
        return false;
    }

}
