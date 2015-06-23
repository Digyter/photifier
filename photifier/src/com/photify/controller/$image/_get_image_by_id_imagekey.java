package com.photify.controller.$image;

// Controller for com.photify.ImagePage#getImagesById
// @javax.annotation.Generated
public final class _get_image_by_id_imagekey extends scenic3.ScenicController {

    private final com.photify.ImagePage page;

    public _get_image_by_id_imagekey() {
        this.page = new com.photify.ImagePage();
    }

    @Override
    public final org.slim3.controller.Navigation setUp() {
        setupPage(page);
        return super.setUp();
    }

    @Override
    public final org.slim3.controller.Navigation run() throws Exception {
        return page.getImagesById(super.var("imagekey"));
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
        return "getImagesById";
    }

}
