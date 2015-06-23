package com.photify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.ModelQuery;

import scenic3.ScenicPage;
import scenic3.annotation.ActionPath;
import scenic3.annotation.Default;
import scenic3.annotation.GET;
import scenic3.annotation.POST;
import scenic3.annotation.Page;
import scenic3.annotation.Var;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.photify.meta.AlbumMeta;
import com.photify.meta.ImageAlbumMeta;
import com.photify.meta.ImageMeta;
import com.photify.meta.UserMeta;
import com.photify.model.Album;
import com.photify.model.Image;
import com.photify.model.ImageAlbum;
import com.photify.model.User;

@Page("/image")
public class ImagePage extends ScenicPage {

    @POST
    @ActionPath("add")
    public Navigation add() throws IOException {

        HashMap<String, Object> map = new HashMap<String, Object>();

        try {
            String albumKey = "" + request.getAttribute("album_key");
            String userKey = "" + request.getAttribute("user_key");
            String imageName = "" + request.getAttribute("image_name");
            String imageUrl = "" + request.getAttribute("image_url");

            UserMeta USERMETA = UserMeta.get();
            User user =
                Datastore.get(USERMETA, KeyFactory.stringToKey(userKey));
            AlbumMeta ALBUMMETA = AlbumMeta.get();
            Album album =
                Datastore.get(ALBUMMETA, KeyFactory.stringToKey(albumKey));

            Image image = new Image();
            image.setName(imageName);
            image.setUrl(imageUrl);
            image.setOwner(user.getKey());

            ImageAlbum imageAlbum = new ImageAlbum();
            imageAlbum.getImageRef().setModel(image);
            imageAlbum.getAlbumRef().setModel(album);
            imageAlbum.getUserRef().setModel(user);

            Datastore.put(image, imageAlbum);
            map.put("status", 0);
        } catch (Exception e) {
            map.put("status", 1);
            map.put("message", e.getMessage());
        }
        return responseJson(map);
    }

    @POST
    @ActionPath("update")
    public Navigation update() throws IOException {

        HashMap<String, Object> map = new HashMap<String, Object>();

        try {
            String imageKey = "" + request.getAttribute("image_key");
            String imageName = "" + request.getAttribute("image_name");
            String imageUrl = "" + request.getAttribute("image_url");
            String userKey = "" + request.getAttribute("user_key");

            UserMeta USERMETA = UserMeta.get();
            User user =
                Datastore.get(USERMETA, KeyFactory.stringToKey(userKey));
            ImageMeta IMAGEMETA = ImageMeta.get();
            Image image =
                Datastore.get(IMAGEMETA, KeyFactory.stringToKey(imageKey));

            if (image.getOwner() != user.getKey()) {
                map.put("status", 2);
                map.put("message", "Permission denied");
                return responseJson(map);
            }
            image.setName(imageName);
            image.setUrl(imageUrl);
            Datastore.put(image.getKey());
            map.put("status", 0);
        } catch (Exception e) {
            map.put("status", 1);
            map.put("message", e.getMessage());
        }
        return responseJson(map);
    }

    @POST
    @ActionPath("delete")
    public Navigation delete() throws IOException {

        HashMap<String, Object> map = new HashMap<String, Object>();

        try {
            String imageKey = "" + request.getAttribute("image_key");
            String userKey = "" + request.getAttribute("user_key");

            UserMeta USERMETA = UserMeta.get();
            User user =
                Datastore.get(USERMETA, KeyFactory.stringToKey(userKey));
            ImageMeta IMAGEMETA = ImageMeta.get();
            Image image =
                Datastore.get(IMAGEMETA, KeyFactory.stringToKey(imageKey));

            if (image.getOwner() != user.getKey()) {
                map.put("status", 2);
                map.put("message", "Permission denied");
                return responseJson(map);
            }

            Datastore.delete(image.getKey());
            map.put("status", 0);
        } catch (Exception e) {
            map.put("status", 1);
            map.put("message", e.getMessage());
        }
        return responseJson(map);
    }

    @GET
    @ActionPath("list")
    public Navigation getImages() throws IllegalStateException,
            NullPointerException, IOException {
        ImageMeta IMAGEMETA = ImageMeta.get();
        return response(IMAGEMETA.modelsToJson(Datastore
            .query(IMAGEMETA)
            .asIterable()));
    }

    @ActionPath("get_image_by_id/{imagekey}")
    public Navigation getImagesById(@Var("imagekey") String imageKey)
            throws IOException {

        HashMap<String, Object> map = new HashMap<String, Object>();

        try {
            ImageMeta IMAGEMETA = ImageMeta.get();

            Key ikey =
                KeyFactory.stringToKey("agpwaG90aWZ5ZGV2cgwLEgVJbWFnZRjNAQw");
            // KeyFactory.stringToKey(imagekey);

            map.put(
                "images",
                IMAGEMETA.modelsToJson(Datastore
                    .query(IMAGEMETA)
                    .filter(IMAGEMETA.and(IMAGEMETA.key.in(ikey)))
                    .asList()));

        } catch (Exception e) {
            map.put("status", 1);
            map.put("message", e.getMessage());
        }

        return responseJson(map);
    }

    @ActionPath("get_image_by_album/{userkey}/{albumkey}")
    public Navigation getImagesByAlbum(@Var("userkey") String userKey,
            @Var("albumkey") String albumKey, @Var("imagekey") String imageKey)
            throws IOException {

        HashMap<String, Object> map = new HashMap<String, Object>();

            ImageAlbumMeta IMAGEALBUMMETA = new ImageAlbumMeta();
            ImageMeta IMAGEMETA = ImageMeta.get();

            Key akey =
                KeyFactory.stringToKey("agpwaG90aWZ5ZGV2cgwLEgVBbGJ1bRj_AQw");
            Key ukey =
                KeyFactory.stringToKey("agpwaG90aWZ5ZGV2cgsLEgRVc2VyGLECDA");
            // Key akey = KeyFactory.stringToKey(albumKey);

/*            ModelQuery<ImageAlbum> ialist =
                Datastore.query(IMAGEALBUMMETA).filter(
                    IMAGEALBUMMETA.and(IMAGEALBUMMETA.albumRef.equal(akey)),
                    IMAGEALBUMMETA.and(IMAGEALBUMMETA.shareeRef.equal(ukey)));
 */           ModelQuery<ImageAlbum> ialist =
                    Datastore.query(IMAGEALBUMMETA);

            List<Key> keys = new ArrayList<Key>();
            for (ImageAlbum ia : ialist.asIterable()) {
                keys.add(ia.getImageRef().getKey());
            }

            String str = IMAGEMETA.modelsToJson(Datastore
                    .query(IMAGEMETA)
                    .filter(IMAGEMETA.key.in(keys))
                    .asList());
            return response(str);

    }

    @ActionPath("get_image_by_album_json/{userkey}/{albumkey}")
    public Navigation getImagesByAlbumJson(@Var("userkey") String userKey,
            @Var("albumkey") String albumKey, @Var("imagekey") String imageKey)
            throws IOException {

        HashMap<String, Object> map = new HashMap<String, Object>();

        try {

            ImageAlbumMeta IMAGEALBUMMETA = new ImageAlbumMeta();
            ImageMeta IMAGEMETA = ImageMeta.get();

            Key akey =
                KeyFactory.stringToKey("agpwaG90aWZ5ZGV2cgwLEgVBbGJ1bRj_AQw");
            Key ukey =
                KeyFactory.stringToKey("agpwaG90aWZ5ZGV2cgsLEgRVc2VyGLECDA");
            // Key akey = KeyFactory.stringToKey(albumKey);

            ModelQuery<ImageAlbum> ialist =
                Datastore.query(IMAGEALBUMMETA).filter(
                    IMAGEALBUMMETA.and(IMAGEALBUMMETA.albumRef.equal(akey)),
                    IMAGEALBUMMETA.and(IMAGEALBUMMETA.shareeRef.equal(ukey)));

            List<Key> keys = new ArrayList<Key>();
            for (ImageAlbum ia : ialist.asIterable()) {
                keys.add(ia.getImageRef().getKey());
            }

            map.put(
                "images",
                IMAGEMETA.modelsToJson(Datastore
                    .query(IMAGEMETA)
                    .filter(IMAGEMETA.key.in(keys))
                    .asList()));

            map.put("status", 0);

        } catch (Exception e) {
            map.put("status", 1);
            map.put("message", e.getMessage());
        }

        return responseJson(map);
    }

    // @ActionPath("get_images2/{userkey}*/{albumkey}*/{imagekey}*")
    // public Navigation getImages2(@Var("userkey") String userKey,
    // @Var("albumkey") String albumKey, @Var("imagekey") String imageKey)
    // throws IOException {
    //
    // HashMap<String, Object> map = new HashMap<String, Object>();
    //
    // try {
    //
    // ImageAlbumMeta IMAGEALBUMMETA = new ImageAlbumMeta();
    // AlbumMeta ALBUMMETA = AlbumMeta.get();
    // ImageMeta IMAGEMETA = ImageMeta.get();
    // UserMeta USERMETA = UserMeta.get();
    //
    // Key akey = KeyFactory.stringToKey("agpwaG90aWZ5ZGV2cgwLEgVBbGJ1bRj_AQw");
    //
    // ModelQuery<ImageAlbum> ialist = Datastore.query(IMAGEALBUMMETA)
    // .filter(IMAGEALBUMMETA.albumRef.equal(akey));
    //
    // map.put("ialist",ialist);
    // List<Key> keys = new ArrayList<Key>();
    // for(ImageAlbum ia:ialist.asIterable()) {
    // keys.add(ia.getImageRef().getKey());
    // }
    // map.put("keys", keys);
    // map.put(
    // "images",
    // IMAGEMETA.modelsToJson(Datastore
    // .query(IMAGEMETA)
    // .filter(IMAGEMETA.key.in(keys))
    // .limit(5)
    // .asList()));
    //
    // map.put("status", 0);
    //
    // } catch (Exception e) {
    // map.put("status", 1);
    // map.put("message", e);
    // }
    //
    // return responseJson(map);
    // }

    @Default
    public Navigation index() {
        return forward("/index.jsp");
    }
}