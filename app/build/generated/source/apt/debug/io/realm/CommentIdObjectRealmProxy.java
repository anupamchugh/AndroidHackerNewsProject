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

public class CommentIdObjectRealmProxy extends com.anupamchugh.androidhackernewsproject.CommentIdObject
    implements RealmObjectProxy, CommentIdObjectRealmProxyInterface {

    static final class CommentIdObjectColumnInfo extends ColumnInfo {
        long commentIdIndex;

        CommentIdObjectColumnInfo(SharedRealm realm, Table table) {
            super(1);
            this.commentIdIndex = addColumnDetails(table, "commentId", RealmFieldType.INTEGER);
        }

        CommentIdObjectColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new CommentIdObjectColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final CommentIdObjectColumnInfo src = (CommentIdObjectColumnInfo) rawSrc;
            final CommentIdObjectColumnInfo dst = (CommentIdObjectColumnInfo) rawDst;
            dst.commentIdIndex = src.commentIdIndex;
        }
    }

    private CommentIdObjectColumnInfo columnInfo;
    private ProxyState<com.anupamchugh.androidhackernewsproject.CommentIdObject> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("commentId");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    CommentIdObjectRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CommentIdObjectColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.anupamchugh.androidhackernewsproject.CommentIdObject>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$commentId() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.commentIdIndex);
    }

    @Override
    public void realmSet$commentId(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.commentIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.commentIdIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("CommentIdObject")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("CommentIdObject");
            realmObjectSchema.add("commentId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("CommentIdObject");
    }

    public static CommentIdObjectColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_CommentIdObject")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'CommentIdObject' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_CommentIdObject");
        final long columnCount = table.getColumnCount();
        if (columnCount != 1) {
            if (columnCount < 1) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 1 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 1 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 1 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final CommentIdObjectColumnInfo columnInfo = new CommentIdObjectColumnInfo(sharedRealm, table);

        if (table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
        }

        if (!columnTypes.containsKey("commentId")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'commentId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("commentId") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'commentId' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.commentIdIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'commentId' does support null values in the existing Realm file. Use corresponding boxed type for field 'commentId' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_CommentIdObject";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.anupamchugh.androidhackernewsproject.CommentIdObject createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.anupamchugh.androidhackernewsproject.CommentIdObject obj = realm.createObjectInternal(com.anupamchugh.androidhackernewsproject.CommentIdObject.class, true, excludeFields);
        if (json.has("commentId")) {
            if (json.isNull("commentId")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'commentId' to null.");
            } else {
                ((CommentIdObjectRealmProxyInterface) obj).realmSet$commentId((long) json.getLong("commentId"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.anupamchugh.androidhackernewsproject.CommentIdObject createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.anupamchugh.androidhackernewsproject.CommentIdObject obj = new com.anupamchugh.androidhackernewsproject.CommentIdObject();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("commentId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'commentId' to null.");
                } else {
                    ((CommentIdObjectRealmProxyInterface) obj).realmSet$commentId((long) reader.nextLong());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.anupamchugh.androidhackernewsproject.CommentIdObject copyOrUpdate(Realm realm, com.anupamchugh.androidhackernewsproject.CommentIdObject object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.anupamchugh.androidhackernewsproject.CommentIdObject) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.anupamchugh.androidhackernewsproject.CommentIdObject copy(Realm realm, com.anupamchugh.androidhackernewsproject.CommentIdObject newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.anupamchugh.androidhackernewsproject.CommentIdObject) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.anupamchugh.androidhackernewsproject.CommentIdObject realmObject = realm.createObjectInternal(com.anupamchugh.androidhackernewsproject.CommentIdObject.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((CommentIdObjectRealmProxyInterface) realmObject).realmSet$commentId(((CommentIdObjectRealmProxyInterface) newObject).realmGet$commentId());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.anupamchugh.androidhackernewsproject.CommentIdObject object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.CommentIdObject.class);
        long tableNativePtr = table.getNativePtr();
        CommentIdObjectColumnInfo columnInfo = (CommentIdObjectColumnInfo) realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.CommentIdObject.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.commentIdIndex, rowIndex, ((CommentIdObjectRealmProxyInterface)object).realmGet$commentId(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.CommentIdObject.class);
        long tableNativePtr = table.getNativePtr();
        CommentIdObjectColumnInfo columnInfo = (CommentIdObjectColumnInfo) realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.CommentIdObject.class);
        com.anupamchugh.androidhackernewsproject.CommentIdObject object = null;
        while (objects.hasNext()) {
            object = (com.anupamchugh.androidhackernewsproject.CommentIdObject) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.commentIdIndex, rowIndex, ((CommentIdObjectRealmProxyInterface)object).realmGet$commentId(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.anupamchugh.androidhackernewsproject.CommentIdObject object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.CommentIdObject.class);
        long tableNativePtr = table.getNativePtr();
        CommentIdObjectColumnInfo columnInfo = (CommentIdObjectColumnInfo) realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.CommentIdObject.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.commentIdIndex, rowIndex, ((CommentIdObjectRealmProxyInterface)object).realmGet$commentId(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.CommentIdObject.class);
        long tableNativePtr = table.getNativePtr();
        CommentIdObjectColumnInfo columnInfo = (CommentIdObjectColumnInfo) realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.CommentIdObject.class);
        com.anupamchugh.androidhackernewsproject.CommentIdObject object = null;
        while (objects.hasNext()) {
            object = (com.anupamchugh.androidhackernewsproject.CommentIdObject) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.commentIdIndex, rowIndex, ((CommentIdObjectRealmProxyInterface)object).realmGet$commentId(), false);
            }
        }
    }

    public static com.anupamchugh.androidhackernewsproject.CommentIdObject createDetachedCopy(com.anupamchugh.androidhackernewsproject.CommentIdObject realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.anupamchugh.androidhackernewsproject.CommentIdObject unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.anupamchugh.androidhackernewsproject.CommentIdObject)cachedObject.object;
            } else {
                unmanagedObject = (com.anupamchugh.androidhackernewsproject.CommentIdObject)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.anupamchugh.androidhackernewsproject.CommentIdObject();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((CommentIdObjectRealmProxyInterface) unmanagedObject).realmSet$commentId(((CommentIdObjectRealmProxyInterface) realmObject).realmGet$commentId());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("CommentIdObject = proxy[");
        stringBuilder.append("{commentId:");
        stringBuilder.append(realmGet$commentId());
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
        CommentIdObjectRealmProxy aCommentIdObject = (CommentIdObjectRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCommentIdObject.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCommentIdObject.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCommentIdObject.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
