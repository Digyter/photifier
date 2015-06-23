package com.photify.controller.matcher;

// @javax.annotation.Generated
public class ModalPageMatcher extends scenic3.UrlMatcherImpl {

    private static final ModalPageMatcher INSTANCE = new ModalPageMatcher();
    /**
     * get a instance of this class.
     */
    public static ModalPageMatcher get() {
        return INSTANCE;
    }

    // Constructor.
    private ModalPageMatcher() {
        super("com.photify.ModalPage", "/modals");
        super.add(new scenic3.UrlPattern("/modals", "album/*"), "com.photify.controller.$modals._album__ASTA");
        super.add(new scenic3.IndexUrlPattern("/modals"), "com.photify.controller.$modals.$Index");
    }


}
