package com.photify.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2015-06-22 21:52:03")
/** */
public final class AlbumMeta extends org.slim3.datastore.ModelMeta<com.photify.model.Album> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.photify.model.Album, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.photify.model.Album, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.photify.model.Album> name = new org.slim3.datastore.StringAttributeMeta<com.photify.model.Album>(this, "name", "name");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.photify.model.Album, com.google.appengine.api.datastore.Key> owner = new org.slim3.datastore.CoreAttributeMeta<com.photify.model.Album, com.google.appengine.api.datastore.Key>(this, "owner", "owner", com.google.appengine.api.datastore.Key.class);

    private static final AlbumMeta slim3_singleton = new AlbumMeta();

    /**
     * @return the singleton
     */
    public static AlbumMeta get() {
       return slim3_singleton;
    }

    /** */
    public AlbumMeta() {
        super("Album", com.photify.model.Album.class);
    }

    @Override
    public com.photify.model.Album entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.photify.model.Album model = new com.photify.model.Album();
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setOwner((com.google.appengine.api.datastore.Key) entity.getProperty("owner"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.photify.model.Album m = (com.photify.model.Album) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("name", m.getName());
        entity.setProperty("owner", m.getOwner());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.photify.model.Album m = (com.photify.model.Album) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.photify.model.Album m = (com.photify.model.Album) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(com.photify.model.Album) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
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
        com.photify.model.Album m = (com.photify.model.Album) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder0.encode(writer, m.getName());
        }
        if(m.getOwner() != null){
            writer.setNextPropertyName("owner");
            encoder0.encode(writer, m.getOwner());
        }
        writer.endObject();
    }

    @Override
    protected com.photify.model.Album jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.photify.model.Album m = new com.photify.model.Album();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("owner");
        m.setOwner(decoder0.decode(reader, m.getOwner()));
        return m;
    }
}