package com.photify.controller.$user;

// Controller for com.photify.UserPage#index
// @javax.annotation.Generated
public final class $Index extends scenic3.ScenicController {

    private final com.photify.UserPage page;

    public $Index() {
        this.page = new com.photify.UserPage();
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
    public final com.photify.UserPage getPage() {
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
