package com.photify.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2015-06-22 21:52:03")
/** */
public final class ImageAlbumMeta extends org.slim3.datastore.ModelMeta<com.photify.model.ImageAlbum> {

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.photify.model.ImageAlbum, org.slim3.datastore.ModelRef<com.photify.model.Album>, com.photify.model.Album> albumRef = new org.slim3.datastore.ModelRefAttributeMeta<com.photify.model.ImageAlbum, org.slim3.datastore.ModelRef<com.photify.model.Album>, com.photify.model.Album>(this, "albumRef", "albumRef", org.slim3.datastore.ModelRef.class, com.photify.model.Album.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.photify.model.ImageAlbum, org.slim3.datastore.ModelRef<com.photify.model.Image>, com.photify.model.Image> imageRef = new org.slim3.datastore.ModelRefAttributeMeta<com.photify.model.ImageAlbum, org.slim3.datastore.ModelRef<com.photify.model.Image>, com.photify.model.Image>(this, "imageRef", "imageRef", org.slim3.datastore.ModelRef.class, com.photify.model.Image.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.photify.model.ImageAlbum, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.photify.model.ImageAlbum, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.photify.model.ImageAlbum, org.slim3.datastore.ModelRef<com.photify.model.User>, com.photify.model.User> shareeRef = new org.slim3.datastore.ModelRefAttributeMeta<com.photify.model.ImageAlbum, org.slim3.datastore.ModelRef<com.photify.model.User>, com.photify.model.User>(this, "shareeRef", "shareeRef", org.slim3.datastore.ModelRef.class, com.photify.model.User.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.photify.model.ImageAlbum, org.slim3.datastore.ModelRef<com.photify.model.User>, com.photify.model.User> userRef = new org.slim3.datastore.ModelRefAttributeMeta<com.photify.model.ImageAlbum, org.slim3.datastore.ModelRef<com.photify.model.User>, com.photify.model.User>(this, "userRef", "userRef", org.slim3.datastore.ModelRef.class, com.photify.model.User.class);

    private static final ImageAlbumMeta slim3_singleton = new ImageAlbumMeta();

    /**
     * @return the singleton
     */
    public static ImageAlbumMeta get() {
       return slim3_singleton;
    }

    /** */
    public ImageAlbumMeta() {
        super("ImageAlbum", com.photify.model.ImageAlbum.class);
    }

    @Override
    public com.photify.model.ImageAlbum entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.photify.model.ImageAlbum model = new com.photify.model.ImageAlbum();
        if (model.getAlbumRef() == null) {
            throw new NullPointerException("The property(albumRef) is null.");
        }
        model.getAlbumRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("albumRef"));
        if (model.getImageRef() == null) {
            throw new NullPointerException("The property(imageRef) is null.");
        }
        model.getImageRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("imageRef"));
        model.setKey(entity.getKey());
        if (model.getShareeRef() == null) {
            throw new NullPointerException("The property(shareeRef) is null.");
        }
        model.getShareeRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("shareeRef"));
        if (model.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) is null.");
        }
        model.getUserRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("userRef"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.photify.model.ImageAlbum m = (com.photify.model.ImageAlbum) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getAlbumRef() == null) {
            throw new NullPointerException("The property(albumRef) must not be null.");
        }
        entity.setProperty("albumRef", m.getAlbumRef().getKey());
        if (m.getImageRef() == null) {
            throw new NullPointerException("The property(imageRef) must not be null.");
        }
        entity.setProperty("imageRef", m.getImageRef().getKey());
        if (m.getShareeRef() == null) {
            throw new NullPointerException("The property(shareeRef) must not be null.");
        }
        entity.setProperty("shareeRef", m.getShareeRef().getKey());
        if (m.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) must not be null.");
        }
        entity.setProperty("userRef", m.getUserRef().getKey());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.photify.model.ImageAlbum m = (com.photify.model.ImageAlbum) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.photify.model.ImageAlbum m = (com.photify.model.ImageAlbum) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(com.photify.model.ImageAlbum) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.photify.model.ImageAlbum m = (com.photify.model.ImageAlbum) model;
        if (m.getAlbumRef() == null) {
            throw new NullPointerException("The property(albumRef) must not be null.");
        }
        m.getAlbumRef().assignKeyIfNecessary(ds);
        if (m.getImageRef() == null) {
            throw new NullPointerException("The property(imageRef) must not be null.");
        }
        m.getImageRef().assignKeyIfNecessary(ds);
        if (m.getShareeRef() == null) {
            throw new NullPointerException("The property(shareeRef) must not be null.");
        }
        m.getShareeRef().assignKeyIfNecessary(ds);
        if (m.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) must not be null.");
        }
        m.getUserRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        com.photify.model.ImageAlbum m = (com.photify.model.ImageAlbum) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getAlbumRef() != null && m.getAlbumRef().getKey() != null){
            writer.setNextPropertyName("albumRef");
            encoder0.encode(writer, m.getAlbumRef(), maxDepth, currentDepth);
        }
        if(m.getImageRef() != null && m.getImageRef().getKey() != null){
            writer.setNextPropertyName("imageRef");
            encoder0.encode(writer, m.getImageRef(), maxDepth, currentDepth);
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getShareeRef() != null && m.getShareeRef().getKey() != null){
            writer.setNextPropertyName("shareeRef");
            encoder0.encode(writer, m.getShareeRef(), maxDepth, currentDepth);
        }
        if(m.getUserRef() != null && m.getUserRef().getKey() != null){
            writer.setNextPropertyName("userRef");
            encoder0.encode(writer, m.getUserRef(), maxDepth, currentDepth);
        }
        writer.endObject();
    }

    @Override
    protected com.photify.model.ImageAlbum jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.photify.model.ImageAlbum m = new com.photify.model.ImageAlbum();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("albumRef");
        decoder0.decode(reader, m.getAlbumRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("imageRef");
        decoder0.decode(reader, m.getImageRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("shareeRef");
        decoder0.decode(reader, m.getShareeRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("userRef");
        decoder0.decode(reader, m.getUserRef(), maxDepth, currentDepth);
        return m;
    }
}