package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.OsObject;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PostsRealmProxy extends com.anupamchugh.androidhackernewsproject.Posts
    implements RealmObjectProxy, PostsRealmProxyInterface {

    static final class PostsColumnInfo extends ColumnInfo {
        long titleIndex;
        long linkIndex;
        long timeStampIndex;
        long votesIndex;
        long commentsIndex;
        long idIndex;

        PostsColumnInfo(SharedRealm realm, Table table) {
            super(6);
            this.titleIndex = addColumnDetails(table, "title", RealmFieldType.STRING);
            this.linkIndex = addColumnDetails(table, "link", RealmFieldType.STRING);
            this.timeStampIndex = addColumnDetails(table, "timeStamp", RealmFieldType.STRING);
            this.votesIndex = addColumnDetails(table, "votes", RealmFieldType.STRING);
            this.commentsIndex = addColumnDetails(table, "comments", RealmFieldType.STRING);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
        }

        PostsColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PostsColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PostsColumnInfo src = (PostsColumnInfo) rawSrc;
            final PostsColumnInfo dst = (PostsColumnInfo) rawDst;
            dst.titleIndex = src.titleIndex;
            dst.linkIndex = src.linkIndex;
            dst.timeStampIndex = src.timeStampIndex;
            dst.votesIndex = src.votesIndex;
            dst.commentsIndex = src.commentsIndex;
            dst.idIndex = src.idIndex;
        }
    }

    private PostsColumnInfo columnInfo;
    private ProxyState<com.anupamchugh.androidhackernewsproject.Posts> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("title");
        fieldNames.add("link");
        fieldNames.add("timeStamp");
        fieldNames.add("votes");
        fieldNames.add("comments");
        fieldNames.add("id");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    PostsRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PostsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.anupamchugh.androidhackernewsproject.Posts>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$title() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleIndex);
    }

    @Override
    public void realmSet$title(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.titleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.titleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.titleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.titleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$link() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.linkIndex);
    }

    @Override
    public void realmSet$link(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.linkIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.linkIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.linkIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.linkIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$timeStamp() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.timeStampIndex);
    }

    @Override
    public void realmSet$timeStamp(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.timeStampIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.timeStampIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.timeStampIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.timeStampIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$votes() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.votesIndex);
    }

    @Override
    public void realmSet$votes(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.votesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.votesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.votesIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.votesIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$comments() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.commentsIndex);
    }

    @Override
    public void realmSet$comments(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.commentsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.commentsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.commentsIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.commentsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(long value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Posts")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Posts");
            realmObjectSchema.add("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("link", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("timeStamp", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("votes", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("comments", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Posts");
    }

    public static PostsColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Posts")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Posts' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Posts");
        final long columnCount = table.getColumnCount();
        if (columnCount != 6) {
            if (columnCount < 6) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 6 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 6 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 6 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final PostsColumnInfo columnInfo = new PostsColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.idIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
            }
        }

        if (!columnTypes.containsKey("title")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'title' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("title") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'title' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.titleIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'title' is required. Either set @Required to field 'title' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("link")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'link' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("link") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'link' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.linkIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'link' is required. Either set @Required to field 'link' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("timeStamp")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'timeStamp' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("timeStamp") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'timeStamp' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.timeStampIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'timeStamp' is required. Either set @Required to field 'timeStamp' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("votes")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'votes' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("votes") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'votes' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.votesIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'votes' is required. Either set @Required to field 'votes' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("comments")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'comments' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("comments") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'comments' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.commentsIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'comments' is required. Either set @Required to field 'comments' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("id")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("id") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'id' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.idIndex) && table.findFirstNull(columnInfo.idIndex) != Table.NO_MATCH) {
            throw new IllegalStateException("Cannot migrate an object with null value in field 'id'. Either maintain the same type for primary key field 'id', or remove the object with null value before migration.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Posts";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.anupamchugh.androidhackernewsproject.Posts createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.anupamchugh.androidhackernewsproject.Posts obj = null;
        if (update) {
            Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.Posts.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.Posts.class), false, Collections.<String> emptyList());
                    obj = new io.realm.PostsRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.PostsRealmProxy) realm.createObjectInternal(com.anupamchugh.androidhackernewsproject.Posts.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.PostsRealmProxy) realm.createObjectInternal(com.anupamchugh.androidhackernewsproject.Posts.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                ((PostsRealmProxyInterface) obj).realmSet$title(null);
            } else {
                ((PostsRealmProxyInterface) obj).realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("link")) {
            if (json.isNull("link")) {
                ((PostsRealmProxyInterface) obj).realmSet$link(null);
            } else {
                ((PostsRealmProxyInterface) obj).realmSet$link((String) json.getString("link"));
            }
        }
        if (json.has("timeStamp")) {
            if (json.isNull("timeStamp")) {
                ((PostsRealmProxyInterface) obj).realmSet$timeStamp(null);
            } else {
                ((PostsRealmProxyInterface) obj).realmSet$timeStamp((String) json.getString("timeStamp"));
            }
        }
        if (json.has("votes")) {
            if (json.isNull("votes")) {
                ((PostsRealmProxyInterface) obj).realmSet$votes(null);
            } else {
                ((PostsRealmProxyInterface) obj).realmSet$votes((String) json.getString("votes"));
            }
        }
        if (json.has("comments")) {
            if (json.isNull("comments")) {
                ((PostsRealmProxyInterface) obj).realmSet$comments(null);
            } else {
                ((PostsRealmProxyInterface) obj).realmSet$comments((String) json.getString("comments"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.anupamchugh.androidhackernewsproject.Posts createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.anupamchugh.androidhackernewsproject.Posts obj = new com.anupamchugh.androidhackernewsproject.Posts();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("title")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PostsRealmProxyInterface) obj).realmSet$title(null);
                } else {
                    ((PostsRealmProxyInterface) obj).realmSet$title((String) reader.nextString());
                }
            } else if (name.equals("link")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PostsRealmProxyInterface) obj).realmSet$link(null);
                } else {
                    ((PostsRealmProxyInterface) obj).realmSet$link((String) reader.nextString());
                }
            } else if (name.equals("timeStamp")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PostsRealmProxyInterface) obj).realmSet$timeStamp(null);
                } else {
                    ((PostsRealmProxyInterface) obj).realmSet$timeStamp((String) reader.nextString());
                }
            } else if (name.equals("votes")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PostsRealmProxyInterface) obj).realmSet$votes(null);
                } else {
                    ((PostsRealmProxyInterface) obj).realmSet$votes((String) reader.nextString());
                }
            } else if (name.equals("comments")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PostsRealmProxyInterface) obj).realmSet$comments(null);
                } else {
                    ((PostsRealmProxyInterface) obj).realmSet$comments((String) reader.nextString());
                }
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((PostsRealmProxyInterface) obj).realmSet$id((long) reader.nextLong());
                }
                jsonHasPrimaryKey = true;
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.anupamchugh.androidhackernewsproject.Posts copyOrUpdate(Realm realm, com.anupamchugh.androidhackernewsproject.Posts object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.anupamchugh.androidhackernewsproject.Posts) cachedRealmObject;
        } else {
            com.anupamchugh.androidhackernewsproject.Posts realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.Posts.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((PostsRealmProxyInterface) object).realmGet$id());
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.Posts.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.PostsRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static com.anupamchugh.androidhackernewsproject.Posts copy(Realm realm, com.anupamchugh.androidhackernewsproject.Posts newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.anupamchugh.androidhackernewsproject.Posts) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.anupamchugh.androidhackernewsproject.Posts realmObject = realm.createObjectInternal(com.anupamchugh.androidhackernewsproject.Posts.class, ((PostsRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((PostsRealmProxyInterface) realmObject).realmSet$title(((PostsRealmProxyInterface) newObject).realmGet$title());
            ((PostsRealmProxyInterface) realmObject).realmSet$link(((PostsRealmProxyInterface) newObject).realmGet$link());
            ((PostsRealmProxyInterface) realmObject).realmSet$timeStamp(((PostsRealmProxyInterface) newObject).realmGet$timeStamp());
            ((PostsRealmProxyInterface) realmObject).realmSet$votes(((PostsRealmProxyInterface) newObject).realmGet$votes());
            ((PostsRealmProxyInterface) realmObject).realmSet$comments(((PostsRealmProxyInterface) newObject).realmGet$comments());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.anupamchugh.androidhackernewsproject.Posts object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.Posts.class);
        long tableNativePtr = table.getNativePtr();
        PostsColumnInfo columnInfo = (PostsColumnInfo) realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.Posts.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((PostsRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PostsRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((PostsRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$title = ((PostsRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$link = ((PostsRealmProxyInterface)object).realmGet$link();
        if (realmGet$link != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
        }
        String realmGet$timeStamp = ((PostsRealmProxyInterface)object).realmGet$timeStamp();
        if (realmGet$timeStamp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.timeStampIndex, rowIndex, realmGet$timeStamp, false);
        }
        String realmGet$votes = ((PostsRealmProxyInterface)object).realmGet$votes();
        if (realmGet$votes != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.votesIndex, rowIndex, realmGet$votes, false);
        }
        String realmGet$comments = ((PostsRealmProxyInterface)object).realmGet$comments();
        if (realmGet$comments != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.commentsIndex, rowIndex, realmGet$comments, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.Posts.class);
        long tableNativePtr = table.getNativePtr();
        PostsColumnInfo columnInfo = (PostsColumnInfo) realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.Posts.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.anupamchugh.androidhackernewsproject.Posts object = null;
        while (objects.hasNext()) {
            object = (com.anupamchugh.androidhackernewsproject.Posts) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((PostsRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PostsRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((PostsRealmProxyInterface) object).realmGet$id());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$title = ((PostsRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                }
                String realmGet$link = ((PostsRealmProxyInterface)object).realmGet$link();
                if (realmGet$link != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
                }
                String realmGet$timeStamp = ((PostsRealmProxyInterface)object).realmGet$timeStamp();
                if (realmGet$timeStamp != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.timeStampIndex, rowIndex, realmGet$timeStamp, false);
                }
                String realmGet$votes = ((PostsRealmProxyInterface)object).realmGet$votes();
                if (realmGet$votes != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.votesIndex, rowIndex, realmGet$votes, false);
                }
                String realmGet$comments = ((PostsRealmProxyInterface)object).realmGet$comments();
                if (realmGet$comments != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.commentsIndex, rowIndex, realmGet$comments, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.anupamchugh.androidhackernewsproject.Posts object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.Posts.class);
        long tableNativePtr = table.getNativePtr();
        PostsColumnInfo columnInfo = (PostsColumnInfo) realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.Posts.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((PostsRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PostsRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((PostsRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$title = ((PostsRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$link = ((PostsRealmProxyInterface)object).realmGet$link();
        if (realmGet$link != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.linkIndex, rowIndex, false);
        }
        String realmGet$timeStamp = ((PostsRealmProxyInterface)object).realmGet$timeStamp();
        if (realmGet$timeStamp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.timeStampIndex, rowIndex, realmGet$timeStamp, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.timeStampIndex, rowIndex, false);
        }
        String realmGet$votes = ((PostsRealmProxyInterface)object).realmGet$votes();
        if (realmGet$votes != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.votesIndex, rowIndex, realmGet$votes, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.votesIndex, rowIndex, false);
        }
        String realmGet$comments = ((PostsRealmProxyInterface)object).realmGet$comments();
        if (realmGet$comments != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.commentsIndex, rowIndex, realmGet$comments, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.commentsIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.Posts.class);
        long tableNativePtr = table.getNativePtr();
        PostsColumnInfo columnInfo = (PostsColumnInfo) realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.Posts.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.anupamchugh.androidhackernewsproject.Posts object = null;
        while (objects.hasNext()) {
            object = (com.anupamchugh.androidhackernewsproject.Posts) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((PostsRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PostsRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((PostsRealmProxyInterface) object).realmGet$id());
                }
                cache.put(object, rowIndex);
                String realmGet$title = ((PostsRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
                }
                String realmGet$link = ((PostsRealmProxyInterface)object).realmGet$link();
                if (realmGet$link != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.linkIndex, rowIndex, false);
                }
                String realmGet$timeStamp = ((PostsRealmProxyInterface)object).realmGet$timeStamp();
                if (realmGet$timeStamp != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.timeStampIndex, rowIndex, realmGet$timeStamp, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.timeStampIndex, rowIndex, false);
                }
                String realmGet$votes = ((PostsRealmProxyInterface)object).realmGet$votes();
                if (realmGet$votes != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.votesIndex, rowIndex, realmGet$votes, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.votesIndex, rowIndex, false);
                }
                String realmGet$comments = ((PostsRealmProxyInterface)object).realmGet$comments();
                if (realmGet$comments != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.commentsIndex, rowIndex, realmGet$comments, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.commentsIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.anupamchugh.androidhackernewsproject.Posts createDetachedCopy(com.anupamchugh.androidhackernewsproject.Posts realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.anupamchugh.androidhackernewsproject.Posts unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.anupamchugh.androidhackernewsproject.Posts)cachedObject.object;
            } else {
                unmanagedObject = (com.anupamchugh.androidhackernewsproject.Posts)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.anupamchugh.androidhackernewsproject.Posts();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((PostsRealmProxyInterface) unmanagedObject).realmSet$title(((PostsRealmProxyInterface) realmObject).realmGet$title());
        ((PostsRealmProxyInterface) unmanagedObject).realmSet$link(((PostsRealmProxyInterface) realmObject).realmGet$link());
        ((PostsRealmProxyInterface) unmanagedObject).realmSet$timeStamp(((PostsRealmProxyInterface) realmObject).realmGet$timeStamp());
        ((PostsRealmProxyInterface) unmanagedObject).realmSet$votes(((PostsRealmProxyInterface) realmObject).realmGet$votes());
        ((PostsRealmProxyInterface) unmanagedObject).realmSet$comments(((PostsRealmProxyInterface) realmObject).realmGet$comments());
        ((PostsRealmProxyInterface) unmanagedObject).realmSet$id(((PostsRealmProxyInterface) realmObject).realmGet$id());
        return unmanagedObject;
    }

    static com.anupamchugh.androidhackernewsproject.Posts update(Realm realm, com.anupamchugh.androidhackernewsproject.Posts realmObject, com.anupamchugh.androidhackernewsproject.Posts newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((PostsRealmProxyInterface) realmObject).realmSet$title(((PostsRealmProxyInterface) newObject).realmGet$title());
        ((PostsRealmProxyInterface) realmObject).realmSet$link(((PostsRealmProxyInterface) newObject).realmGet$link());
        ((PostsRealmProxyInterface) realmObject).realmSet$timeStamp(((PostsRealmProxyInterface) newObject).realmGet$timeStamp());
        ((PostsRealmProxyInterface) realmObject).realmSet$votes(((PostsRealmProxyInterface) newObject).realmGet$votes());
        ((PostsRealmProxyInterface) realmObject).realmSet$comments(((PostsRealmProxyInterface) newObject).realmGet$comments());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Posts = proxy[");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{link:");
        stringBuilder.append(realmGet$link() != null ? realmGet$link() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{timeStamp:");
        stringBuilder.append(realmGet$timeStamp() != null ? realmGet$timeStamp() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{votes:");
        stringBuilder.append(realmGet$votes() != null ? realmGet$votes() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{comments:");
        stringBuilder.append(realmGet$comments() != null ? realmGet$comments() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostsRealmProxy aPosts = (PostsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPosts.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPosts.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPosts.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
