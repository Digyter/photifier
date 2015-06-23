package com.photify.controller;

// Controller for com.photify.FrontPage#index
// @javax.annotation.Generated
public final class $Index extends scenic3.ScenicController {

    private final com.photify.FrontPage page;

    public $Index() {
        this.page = new com.photify.FrontPage();
    }

    @Override
    public final org.slim3.controller.Navigation setUp() {
        setupPage(page);
        return super.setUp();
    }

    @Override
    public final org.slim3.controller.Navigation run() throws Exception {
        return page.index();
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
        return "index";
    }

}
