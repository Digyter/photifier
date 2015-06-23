package com.photify.model;

import org.slim3.datastore.Datastore;

public class Test1 {

    public static void main(String[] args) {
        Image image1 = new Image();
        Image image2 =  new Image();

        Album album1 =  new Album();
        Album album2 =  new Album();

        ImageAlbum imageAlbum11 = new ImageAlbum();
        imageAlbum11.getImageRef().setModel(image1);
        //imageAlbum11.getAlbumRef().setModel(album1);

        ImageAlbum  imageAlbum12 = new
        ImageAlbum();
        imageAlbum12.getImageRef().setModel(image1);
        //imageAlbum12.getAlbumRef().setModel(album2);

        ImageAlbum  imageAlbum21 = new ImageAlbum();
        imageAlbum21.getImageRef().setModel(image2);
        //imageAlbum21.getAlbumRef().setModel(album1);
         
        ImageAlbum  imageAlbum22 = new ImageAlbum();
        imageAlbum22.getImageRef().setModel(image2);
        //imageAlbum22.getAlbumRef().setModel(album2);

        Datastore.put(image1, image2, album1, album2,
            imageAlbum11, imageAlbum12, imageAlbum21, imageAlbum22);

    }

}
