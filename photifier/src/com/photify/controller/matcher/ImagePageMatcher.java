package com.photify.controller.matcher;

// @javax.annotation.Generated
public class ImagePageMatcher extends scenic3.UrlMatcherImpl {

    private static final ImagePageMatcher INSTANCE = new ImagePageMatcher();
    /**
     * get a instance of this class.
     */
    public static ImagePageMatcher get() {
        return INSTANCE;
    }

    // Constructor.
    private ImagePageMatcher() {
        super("com.photify.ImagePage", "/image");
        super.add(new scenic3.UrlPattern("/image", "get_image_by_album_json/{userkey}/{albumkey}"), "com.photify.controller.$image._get_image_by_album_json_userkey_albumkey");
        super.add(new scenic3.UrlPattern("/image", "get_image_by_album/{userkey}/{albumkey}"), "com.photify.controller.$image._get_image_by_album_userkey_albumkey");
        super.add(new scenic3.UrlPattern("/image", "get_image_by_id/{imagekey}"), "com.photify.controller.$image._get_image_by_id_imagekey");
        super.add(new scenic3.UrlPattern("/image", "update", "POST"), "com.photify.controller.$image._update$$POST");
        super.add(new scenic3.UrlPattern("/image", "list", "GET"), "com.photify.controller.$image._list$$GET");
        super.add(new scenic3.UrlPattern("/image", "delete", "POST"), "com.photify.controller.$image._delete$$POST");
        super.add(new scenic3.UrlPattern("/image", "add", "POST"), "com.photify.controller.$image._add$$POST");
        super.add(new scenic3.IndexUrlPattern("/image"), "com.photify.controller.$image.$Index");
    }


}
