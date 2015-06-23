package com.photify;

import java.io.IOException;

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

@Page("/")
public class FrontPage extends ScenicPage {
    // /view/100 /view/200
    @ActionPath("view/{id}")
    public Navigation view(@Var("id") String id) {
        super.request.setAttribute("id", id);
        return forward("/view.jsp");
    }

    @ActionPath("test")
    public Navigation test() {
        // ImageMeta IMAGEMETA = ImageMeta.get();
        // AlbumMeta ALBUMMETA = AlbumMeta.get();
        // ImageAlbumMeta IMAGEALBUMMETA = ImageAlbumMeta.get();

        Image image1 = new Image();
        Image image2 = new Image();

        Album album1 = new Album();
        Album album2 = new Album();
        album1.setName("Album1");
        album1.setName("Album2");

        User user1 = new User();
        User user2 = new User();

        ImageAlbum imageAlbum11 = new ImageAlbum();
        imageAlbum11.getImageRef().setModel(image1);
        imageAlbum11.getAlbumRef().setModel(album1);
        imageAlbum11.getUserRef().setModel(user1);

        ImageAlbum imageAlbum12 = new ImageAlbum();
        imageAlbum12.getImageRef().setModel(image1);
        imageAlbum12.getAlbumRef().setModel(album2);
        imageAlbum12.getUserRef().setModel(user2);

        ImageAlbum imageAlbum21 = new ImageAlbum();
        imageAlbum21.getImageRef().setModel(image2);
        imageAlbum21.getAlbumRef().setModel(album1);
        imageAlbum21.getUserRef().setModel(user1);

        ImageAlbum imageAlbum22 = new ImageAlbum();
        imageAlbum22.getImageRef().setModel(image2);
        imageAlbum22.getAlbumRef().setModel(album2);
        imageAlbum22.getUserRef().setModel(user2);

        Datastore.put(
            image1,
            image2,
            album1,
            album2,
            user1,
            user2,
            imageAlbum11,
            imageAlbum12,
            imageAlbum21,
            imageAlbum22);
        return null;
    }

    @ActionPath("add")
    @POST
    public Navigation add() {

        Image image1 = new Image();
        Image image2 = new Image();
        image1.setName("Kape");
        image2.setName("Bhong");
        image1
            .setUrl("https://lh3.googleusercontent.com/ds90DkWCZQ9yst1egWgDvZk5R1LTrgmklmPFFWbmJa8=s658-no");
        image2
            .setUrl("https://lh3.googleusercontent.com/MYK8YPQz6yLqg0jNtwiwDJ7VgubzFkajHlM307zYqtE=w878-h658-no");

        Album album1 = new Album();
        Album album2 = new Album();
        album1.setName("Album1");
        album1.setName("Album2");

        User user1 = new User();
        User user2 = new User();
        user1.setName("Bhong");
        user2.setName("Mark");
        user1.setEmail("bhong@yahoo.com");
        user2.setEmail("mark@yahoo.com");

        ImageAlbum imageAlbum11 = new ImageAlbum();
        imageAlbum11.getImageRef().setModel(image1);
        imageAlbum11.getAlbumRef().setModel(album1);
        imageAlbum11.getUserRef().setModel(user1);
        imageAlbum11.getShareeRef().setModel(user1);

        ImageAlbum imageAlbum12 = new ImageAlbum();
        imageAlbum12.getImageRef().setModel(image1);
        imageAlbum12.getAlbumRef().setModel(album2);
        imageAlbum12.getUserRef().setModel(user2);
        imageAlbum12.getShareeRef().setModel(user2);

        ImageAlbum imageAlbum21 = new ImageAlbum();
        imageAlbum21.getImageRef().setModel(image2);
        imageAlbum21.getAlbumRef().setModel(album1);
        imageAlbum21.getUserRef().setModel(user1);
        imageAlbum21.getShareeRef().setModel(user1);

        ImageAlbum imageAlbum22 = new ImageAlbum();
        imageAlbum22.getImageRef().setModel(image2);
        imageAlbum22.getAlbumRef().setModel(album2);
        imageAlbum22.getUserRef().setModel(user2);
        imageAlbum22.getShareeRef().setModel(user2);

        Datastore.put(
            image1,
            image2,
            album1,
            album2,
            user1,
            user2,
            imageAlbum11,
            imageAlbum12,
            imageAlbum21,
            imageAlbum22);
        return null;
    }

    @POST
    @ActionPath("addalbum")
    public Navigation addAlbum() throws IOException {

        String albumName = "" + request.getAttribute("album_name");
        String userKey = "" + request.getAttribute("user_key");

        UserMeta USERMETA = UserMeta.get();
        User user = Datastore.get(USERMETA, KeyFactory.stringToKey(userKey));

        Album album = new Album();
        album.setName(albumName);
        album.setOwner(user.getKey());

        ImageAlbum imageAlbum = new ImageAlbum();
        imageAlbum.getAlbumRef().setModel(album);
        imageAlbum.getUserRef().setModel(user);
        imageAlbum.getShareeRef().setModel(user);

        Datastore.put(album, imageAlbum);
        return response("00");
    }

    @POST
    @ActionPath("addimage")
    public Navigation addImage() throws IOException {
        String albumKey = "" + request.getAttribute("album_key");
        String userKey = "" + request.getAttribute("user_key");
        String imageUrl = "" + request.getAttribute("image_url");
        String imageName = "" + request.getAttribute("image_name");

        UserMeta USERMETA = UserMeta.get();
        User user = Datastore.get(USERMETA, KeyFactory.stringToKey(userKey));
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

        Datastore.put(image, imageAlbum);
        return response("00");
    }

    @POST
    @ActionPath("share")
    public Navigation share() throws IOException {
        String albumKey = "" + request.getAttribute("album_key");
        String userKey = "" + request.getAttribute("user_key");
        String imageUrl = "" + request.getAttribute("image_url");
        String imageName = "" + request.getAttribute("image_name");
        String shareeKey = "" + request.getAttribute("sharee_key");

        UserMeta USERMETA = UserMeta.get();
        User user = Datastore.get(USERMETA, KeyFactory.stringToKey(userKey));
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
        return response("00");
    }

    @Default
    public Navigation index() throws IOException {
        
        return forward("/index.jsp");
    }
}