package com.photify.controller.$image;

// Controller for com.photify.ImagePage#add
// @javax.annotation.Generated
public final class _add$$POST extends scenic3.ScenicController {

    private final com.photify.ImagePage page;

    public _add$$POST() {
        this.page = new com.photify.ImagePage();
    }

    @Override
    public final org.slim3.controller.Navigation setUp() {
        setupPage(page);
        return super.setUp();
    }

    @Override
    public final org.slim3.controller.Navigation run() throws Exception {
        return page.add();
    }

    @Override
    public final com.photify.ImagePage getPage() {
        return this.page;
    }

    @Override
    protected final org.slim3.controller.Navigation handleError(Throwable error) throws Throwable {
        return page.handleError(error);
    }

    @Override
    public final String getActionMethodName() {
        return "add";
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
