package com.photify;

import java.io.IOException;
import java.util.HashMap;

import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import scenic3.ScenicPage;
import scenic3.annotation.ActionPath;
import scenic3.annotation.Default;
import scenic3.annotation.POST;
import scenic3.annotation.Page;
import scenic3.annotation.Var;

import com.google.appengine.api.datastore.KeyFactory;
import com.photify.meta.AlbumMeta;
import com.photify.meta.UserMeta;
import com.photify.model.Album;
import com.photify.model.Image;
import com.photify.model.ImageAlbum;
import com.photify.model.User;

@Page("/album")
public class AlbumPage extends ScenicPage {

    @POST
    @ActionPath("add")
    public Navigation add() throws IOException {

        HashMap<String, Object> map = new HashMap<String, Object>();

        try {
            String albumName = "" + request.getAttribute("album_name");
            String userKey = "" + request.getAttribute("user_key");

            UserMeta USERMETA = UserMeta.get();
            User user =
                Datastore.get(USERMETA, KeyFactory.stringToKey(userKey));

            Album album = new Album();
            album.setName(albumName);
            album.setOwner(user.getKey());

            ImageAlbum imageAlbum = new ImageAlbum();
            imageAlbum.getAlbumRef().setModel(album);
            imageAlbum.getUserRef().setModel(user);
            imageAlbum.getShareeRef().setModel(user);

            Datastore.put(album, imageAlbum);
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
            String albumKey = "" + request.getAttribute("album_key");
            String albumName = "" + request.getAttribute("album_name");
            String userKey = "" + request.getAttribute("user_key");

            UserMeta USERMETA = UserMeta.get();
            User user =
                Datastore.get(USERMETA, KeyFactory.stringToKey(userKey));
            AlbumMeta ALBUMMETA = AlbumMeta.get();
            Album album =
                Datastore.get(ALBUMMETA, KeyFactory.stringToKey(albumKey));

            if (album.getOwner() != user.getKey()) {
                map.put("status", 2);
                map.put("message", "Permission denied");
                return responseJson(map);
            }

            album.setName(albumName);
            Datastore.put(album.getKey());
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
            String albumKey = "" + request.getAttribute("album_key");
            String userKey = "" + request.getAttribute("user_key");

            UserMeta USERMETA = UserMeta.get();
            User user =
                Datastore.get(USERMETA, KeyFactory.stringToKey(userKey));
            AlbumMeta ALBUMMETA = AlbumMeta.get();
            Album album =
                Datastore.get(ALBUMMETA, KeyFactory.stringToKey(albumKey));

            if (album.getOwner() != user.getKey()) {
                map.put("status", 2);
                map.put("message", "Permission denied");
                return responseJson(map);
            }

            Datastore.delete(album.getKey());
            map.put("status", 0);
        } catch (Exception e) {
            map.put("status", 1);
            map.put("message", e.getMessage());
        }
        return responseJson(map);
    }

    @POST
    @ActionPath("share")
    public Navigation share() throws IOException {

        HashMap<String, Object> map = new HashMap<String, Object>();

        try {
            String albumKey = "" + request.getAttribute("album_key");
            String userKey = "" + request.getAttribute("user_key");
            String imageUrl = "" + request.getAttribute("image_url");
            String imageName = "" + request.getAttribute("image_name");
            String shareeKey = "" + request.getAttribute("sharee_key");

            UserMeta USERMETA = UserMeta.get();
            User user =
                Datastore.get(USERMETA, KeyFactory.stringToKey(userKey));
            UserMeta SHAREEMETA = UserMeta.get();
            User sharee =
                Datastore.get(SHAREEMETA, KeyFactory.stringToKey(shareeKey));
            AlbumMeta ALBUMMETA = AlbumMeta.get();
            Album album =
                Datastore.get(ALBUMMETA, KeyFactory.stringToKey(albumKey));

            Image image = new Image();
            image.setUrl(imageUrl);
            image.setName(imageName);
            image.setOwner(user.getKey());

            ImageAlbum imageAlbum = new ImageAlbum();
            imageAlbum.getImageRef().setModel(image);
            imageAlbum.getAlbumRef().setModel(album);
            imageAlbum.getUserRef().setModel(user);
            imageAlbum.getShareeRef().setModel(sharee);

            Datastore.put(imageAlbum);
            map.put("status", 0);
        } catch (Exception e) {
            map.put("status", 1);
            map.put("message", e.getMessage());
        }
        return responseJson(map);
    }

    @ActionPath("get_album/{userkey}/{albumkey}")
    public Navigation getAlbumByKey(@Var("userkey") String userKey,
            @Var("albumkey") String albumKey) throws IOException {
        HashMap<String, Object> map = new HashMap<String, Object>();
        AlbumMeta ALBUMMETA = AlbumMeta.get();

        try {
            if (!albumKey.equals("")) {
                map.put(
                    "albums",
                    ALBUMMETA.modelsToJson(Datastore.query(ALBUMMETA)
                    // .filter(
                    // ALBUMMETA.and(ALBUMMETA.key.equal(KeyFactory
                    // .stringToKey(albumKey))),
                    // ALBUMMETA.and(ALBUMMETA.owner.equal(KeyFactory
                    // .stringToKey(userKey))))
                        .asList()));
            } else {
                map.put("albums", ALBUMMETA.modelsToJson(Datastore
                    .query(ALBUMMETA)
                    .filter(
                        ALBUMMETA.owner.equal(KeyFactory.stringToKey(userKey)))
                    .asList()));
            }
            map.put("status", 0);
        } catch (Exception e) {
            map.put("status", 1);
            map.put("message", e.getMessage());
        }
        String str =
            ALBUMMETA.modelsToJson(Datastore.query(ALBUMMETA)
                .filter(
                    ALBUMMETA.and(ALBUMMETA.name.notEqual(null)))
                    .asList());
        return response(str);
    }

    @Default
    public Navigation index() {
        return forward("/index.jsp");
    }
}