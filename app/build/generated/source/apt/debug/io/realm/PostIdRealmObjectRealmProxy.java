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

public class PostIdRealmObjectRealmProxy extends com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject
    implements RealmObjectProxy, PostIdRealmObjectRealmProxyInterface {

    static final class PostIdRealmObjectColumnInfo extends ColumnInfo {
        long postIdIndex;
        long isCachedIndex;

        PostIdRealmObjectColumnInfo(SharedRealm realm, Table table) {
            super(2);
            this.postIdIndex = addColumnDetails(table, "postId", RealmFieldType.INTEGER);
            this.isCachedIndex = addColumnDetails(table, "isCached", RealmFieldType.BOOLEAN);
        }

        PostIdRealmObjectColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PostIdRealmObjectColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PostIdRealmObjectColumnInfo src = (PostIdRealmObjectColumnInfo) rawSrc;
            final PostIdRealmObjectColumnInfo dst = (PostIdRealmObjectColumnInfo) rawDst;
            dst.postIdIndex = src.postIdIndex;
            dst.isCachedIndex = src.isCachedIndex;
        }
    }

    private PostIdRealmObjectColumnInfo columnInfo;
    private ProxyState<com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("postId");
        fieldNames.add("isCached");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    PostIdRealmObjectRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PostIdRealmObjectColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$postId() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.postIdIndex);
    }

    @Override
    public void realmSet$postId(long value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'postId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isCached() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isCachedIndex);
    }

    @Override
    public void realmSet$isCached(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isCachedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isCachedIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("PostIdRealmObject")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("PostIdRealmObject");
            realmObjectSchema.add("postId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("isCached", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("PostIdRealmObject");
    }

    public static PostIdRealmObjectColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_PostIdRealmObject")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'PostIdRealmObject' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_PostIdRealmObject");
        final long columnCount = table.getColumnCount();
        if (columnCount != 2) {
            if (columnCount < 2) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 2 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 2 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 2 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final PostIdRealmObjectColumnInfo columnInfo = new PostIdRealmObjectColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'postId' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.postIdIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field postId");
            }
        }

        if (!columnTypes.containsKey("postId")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'postId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("postId") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'postId' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.postIdIndex) && table.findFirstNull(columnInfo.postIdIndex) != Table.NO_MATCH) {
            throw new IllegalStateException("Cannot migrate an object with null value in field 'postId'. Either maintain the same type for primary key field 'postId', or remove the object with null value before migration.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("postId"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'postId' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }
        if (!columnTypes.containsKey("isCached")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isCached' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("isCached") != RealmFieldType.BOOLEAN) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'isCached' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.isCachedIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'isCached' does support null values in the existing Realm file. Use corresponding boxed type for field 'isCached' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_PostIdRealmObject";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject obj = null;
        if (update) {
            Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("postId")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("postId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class), false, Collections.<String> emptyList());
                    obj = new io.realm.PostIdRealmObjectRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("postId")) {
                if (json.isNull("postId")) {
                    obj = (io.realm.PostIdRealmObjectRealmProxy) realm.createObjectInternal(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.PostIdRealmObjectRealmProxy) realm.createObjectInternal(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class, json.getLong("postId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'postId'.");
            }
        }
        if (json.has("isCached")) {
            if (json.isNull("isCached")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isCached' to null.");
            } else {
                ((PostIdRealmObjectRealmProxyInterface) obj).realmSet$isCached((boolean) json.getBoolean("isCached"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject obj = new com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("postId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'postId' to null.");
                } else {
                    ((PostIdRealmObjectRealmProxyInterface) obj).realmSet$postId((long) reader.nextLong());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("isCached")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isCached' to null.");
                } else {
                    ((PostIdRealmObjectRealmProxyInterface) obj).realmSet$isCached((boolean) reader.nextBoolean());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'postId'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject copyOrUpdate(Realm realm, com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject) cachedRealmObject;
        } else {
            com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((PostIdRealmObjectRealmProxyInterface) object).realmGet$postId());
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.PostIdRealmObjectRealmProxy();
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

    public static com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject copy(Realm realm, com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject realmObject = realm.createObjectInternal(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class, ((PostIdRealmObjectRealmProxyInterface) newObject).realmGet$postId(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((PostIdRealmObjectRealmProxyInterface) realmObject).realmSet$isCached(((PostIdRealmObjectRealmProxyInterface) newObject).realmGet$isCached());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class);
        long tableNativePtr = table.getNativePtr();
        PostIdRealmObjectColumnInfo columnInfo = (PostIdRealmObjectColumnInfo) realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((PostIdRealmObjectRealmProxyInterface) object).realmGet$postId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PostIdRealmObjectRealmProxyInterface) object).realmGet$postId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((PostIdRealmObjectRealmProxyInterface) object).realmGet$postId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isCachedIndex, rowIndex, ((PostIdRealmObjectRealmProxyInterface)object).realmGet$isCached(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class);
        long tableNativePtr = table.getNativePtr();
        PostIdRealmObjectColumnInfo columnInfo = (PostIdRealmObjectColumnInfo) realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject object = null;
        while (objects.hasNext()) {
            object = (com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((PostIdRealmObjectRealmProxyInterface) object).realmGet$postId();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PostIdRealmObjectRealmProxyInterface) object).realmGet$postId());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((PostIdRealmObjectRealmProxyInterface) object).realmGet$postId());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isCachedIndex, rowIndex, ((PostIdRealmObjectRealmProxyInterface)object).realmGet$isCached(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class);
        long tableNativePtr = table.getNativePtr();
        PostIdRealmObjectColumnInfo columnInfo = (PostIdRealmObjectColumnInfo) realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((PostIdRealmObjectRealmProxyInterface) object).realmGet$postId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PostIdRealmObjectRealmProxyInterface) object).realmGet$postId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((PostIdRealmObjectRealmProxyInterface) object).realmGet$postId());
        }
        cache.put(object, rowIndex);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isCachedIndex, rowIndex, ((PostIdRealmObjectRealmProxyInterface)object).realmGet$isCached(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class);
        long tableNativePtr = table.getNativePtr();
        PostIdRealmObjectColumnInfo columnInfo = (PostIdRealmObjectColumnInfo) realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject object = null;
        while (objects.hasNext()) {
            object = (com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((PostIdRealmObjectRealmProxyInterface) object).realmGet$postId();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PostIdRealmObjectRealmProxyInterface) object).realmGet$postId());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((PostIdRealmObjectRealmProxyInterface) object).realmGet$postId());
                }
                cache.put(object, rowIndex);
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isCachedIndex, rowIndex, ((PostIdRealmObjectRealmProxyInterface)object).realmGet$isCached(), false);
            }
        }
    }

    public static com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject createDetachedCopy(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject)cachedObject.object;
            } else {
                unmanagedObject = (com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((PostIdRealmObjectRealmProxyInterface) unmanagedObject).realmSet$postId(((PostIdRealmObjectRealmProxyInterface) realmObject).realmGet$postId());
        ((PostIdRealmObjectRealmProxyInterface) unmanagedObject).realmSet$isCached(((PostIdRealmObjectRealmProxyInterface) realmObject).realmGet$isCached());
        return unmanagedObject;
    }

    static com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject update(Realm realm, com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject realmObject, com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((PostIdRealmObjectRealmProxyInterface) realmObject).realmSet$isCached(((PostIdRealmObjectRealmProxyInterface) newObject).realmGet$isCached());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PostIdRealmObject = proxy[");
        stringBuilder.append("{postId:");
        stringBuilder.append(realmGet$postId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isCached:");
        stringBuilder.append(realmGet$isCached());
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
        PostIdRealmObjectRealmProxy aPostIdRealmObject = (PostIdRealmObjectRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPostIdRealmObject.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPostIdRealmObject.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPostIdRealmObject.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
