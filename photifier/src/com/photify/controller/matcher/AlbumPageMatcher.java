package com.photify.controller.matcher;

// @javax.annotation.Generated
public class AlbumPageMatcher extends scenic3.UrlMatcherImpl {

    private static final AlbumPageMatcher INSTANCE = new AlbumPageMatcher();
    /**
     * get a instance of this class.
     */
    public static AlbumPageMatcher get() {
        return INSTANCE;
    }

    // Constructor.
    private AlbumPageMatcher() {
        super("com.photify.AlbumPage", "/album");
        super.add(new scenic3.UrlPattern("/album", "get_album/{userkey}/{albumkey}"), "com.photify.controller.$album._get_album_userkey_albumkey");
        super.add(new scenic3.UrlPattern("/album", "update", "POST"), "com.photify.controller.$album._update$$POST");
        super.add(new scenic3.UrlPattern("/album", "share", "POST"), "com.photify.controller.$album._share$$POST");
        super.add(new scenic3.UrlPattern("/album", "delete", "POST"), "com.photify.controller.$album._delete$$POST");
        super.add(new scenic3.UrlPattern("/album", "add", "POST"), "com.photify.controller.$album._add$$POST");
        super.add(new scenic3.IndexUrlPattern("/album"), "com.photify.controller.$album.$Index");
    }


}
