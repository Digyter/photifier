package com.photify.controller.$album;

// Controller for com.photify.AlbumPage#delete
// @javax.annotation.Generated
public final class _delete$$POST extends scenic3.ScenicController {

    private final com.photify.AlbumPage page;

    public _delete$$POST() {
        this.page = new com.photify.AlbumPage();
    }

    @Override
    public final org.slim3.controller.Navigation setUp() {
        setupPage(page);
        return super.setUp();
    }

    @Override
    public final org.slim3.controller.Navigation run() throws Exception {
        return page.delete();
    }

    @Override
    public final com.photify.AlbumPage getPage() {
        return this.page;
    }

    @Override
    protected final org.slim3.controller.Navigation handleError(Throwable error) throws Throwable {
        return page.handleError(error);
    }

    @Override
    public final String getActionMethodName() {
        return "delete";
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
