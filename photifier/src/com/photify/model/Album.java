package com.photify.model;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

@Model
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;
    
    private String name;
    private Key owner;
    
    @Attribute(persistent = false)
    private  InverseModelListRef<ImageAlbum, Album>  imageAlbumListRef =
        new  InverseModelListRef<ImageAlbum, Album>(ImageAlbum.class,  "albumRef", this);

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Key getKey() {
        return key;
    }

    public InverseModelListRef<ImageAlbum, Album> getImageAlbumListRef() {
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

    public Key getOwner() {
        return owner;
    }

    public void setOwner(Key owner) {
        this.owner = owner;
    }
}
