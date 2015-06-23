package com.photify.model;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;

@Model
public class ImageAlbum implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    private ModelRef<Image> imageRef = new ModelRef<Image>(Image.class);
    private ModelRef<Album> albumRef = new ModelRef<Album>(Album.class);
    private ModelRef<User> userRef = new ModelRef<User>(User.class);
    private ModelRef<User> shareeRef = new ModelRef<User>(User.class);
            
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public Key getKey() {
        return key;
    }
    public ModelRef<Image> getImageRef() {
        return imageRef;
    }
    public ModelRef<Album> getAlbumRef() {
        return albumRef;
    }
    public void setKey(Key key) {
        this.key = key;
    }
    public ModelRef<User> getUserRef() {
        return userRef;
    }
    public ModelRef<User> getShareeRef() {
        return shareeRef;
    }
}
