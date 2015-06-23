package com.photify.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2015-06-22 21:52:03")
/** */
public final class UploadedDataMeta extends org.slim3.datastore.ModelMeta<com.photify.model.UploadedData> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.photify.model.UploadedData> fileName = new org.slim3.datastore.StringAttributeMeta<com.photify.model.UploadedData>(this, "fileName", "fileName");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.photify.model.UploadedData, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.photify.model.UploadedData, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.photify.model.UploadedData, java.lang.Integer> length = new org.slim3.datastore.CoreAttributeMeta<com.photify.model.UploadedData, java.lang.Integer>(this, "length", "length", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.photify.model.UploadedData, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.photify.model.UploadedData, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final UploadedDataMeta slim3_singleton = new UploadedDataMeta();

    /**
     * @return the singleton
     */
    public static UploadedDataMeta get() {
       return slim3_singleton;
    }

    /** */
    public UploadedDataMeta() {
        super("UploadedData", com.photify.model.UploadedData.class);
    }

    @Override
    public com.photify.model.UploadedData entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.photify.model.UploadedData model = new com.photify.model.UploadedData();
        model.setFileName((java.lang.String) entity.getProperty("fileName"));
        model.setKey(entity.getKey());
        model.setLength(longToPrimitiveInt((java.lang.Long) entity.getProperty("length")));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.photify.model.UploadedData m = (com.photify.model.UploadedData) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("fileName", m.getFileName());
        entity.setProperty("length", m.getLength());
        entity.setProperty("version", m.getVersion());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.photify.model.UploadedData m = (com.photify.model.UploadedData) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.photify.model.UploadedData m = (com.photify.model.UploadedData) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.photify.model.UploadedData m = (com.photify.model.UploadedData) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        com.photify.model.UploadedData m = (com.photify.model.UploadedData) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
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
        com.photify.model.UploadedData m = (com.photify.model.UploadedData) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getFileName() != null){
            writer.setNextPropertyName("fileName");
            encoder0.encode(writer, m.getFileName());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        writer.setNextPropertyName("length");
        encoder0.encode(writer, m.getLength());
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.photify.model.UploadedData jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.photify.model.UploadedData m = new com.photify.model.UploadedData();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("fileName");
        m.setFileName(decoder0.decode(reader, m.getFileName()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("length");
        m.setLength(decoder0.decode(reader, m.getLength()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}