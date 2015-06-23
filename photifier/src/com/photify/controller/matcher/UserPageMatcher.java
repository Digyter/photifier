package com.photify.controller.matcher;

// @javax.annotation.Generated
public class UserPageMatcher extends scenic3.UrlMatcherImpl {

    private static final UserPageMatcher INSTANCE = new UserPageMatcher();
    /**
     * get a instance of this class.
     */
    public static UserPageMatcher get() {
        return INSTANCE;
    }

    // Constructor.
    private UserPageMatcher() {
        super("com.photify.UserPage", "/user");
        super.add(new scenic3.UrlPattern("/user", "list", "GET"), "com.photify.controller.$user._list$$GET");
        super.add(new scenic3.UrlPattern("/user", "delete", "POST"), "com.photify.controller.$user._delete$$POST");
        super.add(new scenic3.UrlPattern("/user", "add", "POST"), "com.photify.controller.$user._add$$POST");
        super.add(new scenic3.IndexUrlPattern("/user"), "com.photify.controller.$user.$Index");
    }


}
