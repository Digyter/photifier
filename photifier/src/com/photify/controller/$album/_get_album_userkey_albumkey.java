package com.photify.controller.$album;

// Controller for com.photify.AlbumPage#getAlbumByKey
// @javax.annotation.Generated
public final class _get_album_userkey_albumkey extends scenic3.ScenicController {

    private final com.photify.AlbumPage page;

    public _get_album_userkey_albumkey() {
        this.page = new com.photify.AlbumPage();
    }

    @Override
    public final org.slim3.controller.Navigation setUp() {
        setupPage(page);
        return super.setUp();
    }

    @Override
    public final org.slim3.controller.Navigation run() throws Exception {
        return page.getAlbumByKey(super.var("userkey"), super.var("albumkey"));
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
        return "getAlbumByKey";
    }

}
