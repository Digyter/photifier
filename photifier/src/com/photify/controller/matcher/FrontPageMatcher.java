package com.photify.controller.matcher;

// @javax.annotation.Generated
public class FrontPageMatcher extends scenic3.UrlMatcherImpl {

    private static final FrontPageMatcher INSTANCE = new FrontPageMatcher();
    /**
     * get a instance of this class.
     */
    public static FrontPageMatcher get() {
        return INSTANCE;
    }

    // Constructor.
    private FrontPageMatcher() {
        super("com.photify.FrontPage", "/");
        super.add(new scenic3.UrlPattern("/", "view/{id}"), "com.photify.controller._view_id");
        super.add(new scenic3.UrlPattern("/", "test"), "com.photify.controller._test");
        super.add(new scenic3.UrlPattern("/", "share", "POST"), "com.photify.controller._share$$POST");
        super.add(new scenic3.UrlPattern("/", "addimage", "POST"), "com.photify.controller._addimage$$POST");
        super.add(new scenic3.UrlPattern("/", "addalbum", "POST"), "com.photify.controller._addalbum$$POST");
        super.add(new scenic3.UrlPattern("/", "add", "POST"), "com.photify.controller._add$$POST");
        super.add(new scenic3.IndexUrlPattern("/"), "com.photify.controller.$Index");
    }


}
