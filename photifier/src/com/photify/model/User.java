package com.photify.model;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

@Model
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;
    
    private String name;
    private String email;
    
    @Attribute(persistent = false)
    private  InverseModelListRef<ImageAlbum, User>  imageAlbumListRef =
        new  InverseModelListRef<ImageAlbum, User>(ImageAlbum.class,  "userRef", this);

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Key getKey() {
        return key;
    }

    public InverseModelListRef<ImageAlbum, User> getImageAlbumListRef() {
        return imageAlbumListRef;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
