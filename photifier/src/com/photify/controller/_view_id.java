package com.photify.controller;

// Controller for com.photify.FrontPage#view
// @javax.annotation.Generated
public final class _view_id extends scenic3.ScenicController {

    private final com.photify.FrontPage page;

    public _view_id() {
        this.page = new com.photify.FrontPage();
    }

    @Override
    public final org.slim3.controller.Navigation setUp() {
        setupPage(page);
        return super.setUp();
    }

    @Override
    public final org.slim3.controller.Navigation run() throws Exception {
        return page.view(super.var("id"));
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
        return "view";
    }

}
