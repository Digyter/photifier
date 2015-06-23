package com.photify.controller.$modals;

// Controller for com.photify.ModalPage#create_album
// @javax.annotation.Generated
public final class _album__ASTA extends scenic3.ScenicController {

    private final com.photify.ModalPage page;

    public _album__ASTA() {
        this.page = new com.photify.ModalPage();
    }

    @Override
    public final org.slim3.controller.Navigation setUp() {
        setupPage(page);
        return super.setUp();
    }

    @Override
    public final org.slim3.controller.Navigation run() throws Exception {
        return page.create_album();
    }

    @Override
    public final com.photify.ModalPage getPage() {
        return this.page;
    }

    @Override
    protected final org.slim3.controller.Navigation handleError(Throwable error) throws Throwable {
        return page.handleError(error);
    }

    @Override
    public final String getActionMethodName() {
        return "create_album";
    }

}
