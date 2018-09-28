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

public class CommentObjectRealmProxy extends com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject
    implements RealmObjectProxy, CommentObjectRealmProxyInterface {

    static final class CommentObjectColumnInfo extends ColumnInfo {
        long idIndex;
        long timeIndex;
        long titleIndex;
        long byIndex;
        long textIndex;
        long typeIndex;

        CommentObjectColumnInfo(SharedRealm realm, Table table) {
            super(6);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.timeIndex = addColumnDetails(table, "time", RealmFieldType.INTEGER);
            this.titleIndex = addColumnDetails(table, "title", RealmFieldType.STRING);
            this.byIndex = addColumnDetails(table, "by", RealmFieldType.STRING);
            this.textIndex = addColumnDetails(table, "text", RealmFieldType.STRING);
            this.typeIndex = addColumnDetails(table, "type", RealmFieldType.STRING);
        }

        CommentObjectColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new CommentObjectColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final CommentObjectColumnInfo src = (CommentObjectColumnInfo) rawSrc;
            final CommentObjectColumnInfo dst = (CommentObjectColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.timeIndex = src.timeIndex;
            dst.titleIndex = src.titleIndex;
            dst.byIndex = src.byIndex;
            dst.textIndex = src.textIndex;
            dst.typeIndex = src.typeIndex;
        }
    }

    private CommentObjectColumnInfo columnInfo;
    private ProxyState<com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("time");
        fieldNames.add("title");
        fieldNames.add("by");
        fieldNames.add("text");
        fieldNames.add("type");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    CommentObjectRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CommentObjectColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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

    @Override
    @SuppressWarnings("cast")
    public long realmGet$time() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.timeIndex);
    }

    @Override
    public void realmSet$time(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.timeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.timeIndex, value);
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
    public String realmGet$by() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.byIndex);
    }

    @Override
    public void realmSet$by(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.byIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.byIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.byIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.byIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$text() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.textIndex);
    }

    @Override
    public void realmSet$text(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.textIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.textIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.textIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.textIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$type() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.typeIndex);
    }

    @Override
    public void realmSet$type(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.typeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.typeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.typeIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("CommentObject")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("CommentObject");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("time", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("by", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("text", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("CommentObject");
    }

    public static CommentObjectColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_CommentObject")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'CommentObject' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_CommentObject");
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

        final CommentObjectColumnInfo columnInfo = new CommentObjectColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.idIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
            }
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
        if (!columnTypes.containsKey("time")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'time' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("time") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'time' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.timeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'time' does support null values in the existing Realm file. Use corresponding boxed type for field 'time' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("by")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'by' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("by") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'by' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.byIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'by' is required. Either set @Required to field 'by' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("text")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'text' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("text") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'text' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.textIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'text' is required. Either set @Required to field 'text' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("type")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'type' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("type") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'type' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.typeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'type' is required. Either set @Required to field 'type' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_CommentObject";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject obj = null;
        if (update) {
            Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject.class), false, Collections.<String> emptyList());
                    obj = new io.realm.CommentObjectRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.CommentObjectRealmProxy) realm.createObjectInternal(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.CommentObjectRealmProxy) realm.createObjectInternal(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("time")) {
            if (json.isNull("time")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'time' to null.");
            } else {
                ((CommentObjectRealmProxyInterface) obj).realmSet$time((long) json.getLong("time"));
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                ((CommentObjectRealmProxyInterface) obj).realmSet$title(null);
            } else {
                ((CommentObjectRealmProxyInterface) obj).realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("by")) {
            if (json.isNull("by")) {
                ((CommentObjectRealmProxyInterface) obj).realmSet$by(null);
            } else {
                ((CommentObjectRealmProxyInterface) obj).realmSet$by((String) json.getString("by"));
            }
        }
        if (json.has("text")) {
            if (json.isNull("text")) {
                ((CommentObjectRealmProxyInterface) obj).realmSet$text(null);
            } else {
                ((CommentObjectRealmProxyInterface) obj).realmSet$text((String) json.getString("text"));
            }
        }
        if (json.has("type")) {
            if (json.isNull("type")) {
                ((CommentObjectRealmProxyInterface) obj).realmSet$type(null);
            } else {
                ((CommentObjectRealmProxyInterface) obj).realmSet$type((String) json.getString("type"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject obj = new com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((CommentObjectRealmProxyInterface) obj).realmSet$id((long) reader.nextLong());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("time")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'time' to null.");
                } else {
                    ((CommentObjectRealmProxyInterface) obj).realmSet$time((long) reader.nextLong());
                }
            } else if (name.equals("title")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CommentObjectRealmProxyInterface) obj).realmSet$title(null);
                } else {
                    ((CommentObjectRealmProxyInterface) obj).realmSet$title((String) reader.nextString());
                }
            } else if (name.equals("by")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CommentObjectRealmProxyInterface) obj).realmSet$by(null);
                } else {
                    ((CommentObjectRealmProxyInterface) obj).realmSet$by((String) reader.nextString());
                }
            } else if (name.equals("text")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CommentObjectRealmProxyInterface) obj).realmSet$text(null);
                } else {
                    ((CommentObjectRealmProxyInterface) obj).realmSet$text((String) reader.nextString());
                }
            } else if (name.equals("type")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CommentObjectRealmProxyInterface) obj).realmSet$type(null);
                } else {
                    ((CommentObjectRealmProxyInterface) obj).realmSet$type((String) reader.nextString());
                }
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

    public static com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject copyOrUpdate(Realm realm, com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject) cachedRealmObject;
        } else {
            com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((CommentObjectRealmProxyInterface) object).realmGet$id());
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.CommentObjectRealmProxy();
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

    public static com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject copy(Realm realm, com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject realmObject = realm.createObjectInternal(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject.class, ((CommentObjectRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((CommentObjectRealmProxyInterface) realmObject).realmSet$time(((CommentObjectRealmProxyInterface) newObject).realmGet$time());
            ((CommentObjectRealmProxyInterface) realmObject).realmSet$title(((CommentObjectRealmProxyInterface) newObject).realmGet$title());
            ((CommentObjectRealmProxyInterface) realmObject).realmSet$by(((CommentObjectRealmProxyInterface) newObject).realmGet$by());
            ((CommentObjectRealmProxyInterface) realmObject).realmSet$text(((CommentObjectRealmProxyInterface) newObject).realmGet$text());
            ((CommentObjectRealmProxyInterface) realmObject).realmSet$type(((CommentObjectRealmProxyInterface) newObject).realmGet$type());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject.class);
        long tableNativePtr = table.getNativePtr();
        CommentObjectColumnInfo columnInfo = (CommentObjectColumnInfo) realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((CommentObjectRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CommentObjectRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((CommentObjectRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.timeIndex, rowIndex, ((CommentObjectRealmProxyInterface)object).realmGet$time(), false);
        String realmGet$title = ((CommentObjectRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$by = ((CommentObjectRealmProxyInterface)object).realmGet$by();
        if (realmGet$by != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.byIndex, rowIndex, realmGet$by, false);
        }
        String realmGet$text = ((CommentObjectRealmProxyInterface)object).realmGet$text();
        if (realmGet$text != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.textIndex, rowIndex, realmGet$text, false);
        }
        String realmGet$type = ((CommentObjectRealmProxyInterface)object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject.class);
        long tableNativePtr = table.getNativePtr();
        CommentObjectColumnInfo columnInfo = (CommentObjectColumnInfo) realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject object = null;
        while (objects.hasNext()) {
            object = (com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((CommentObjectRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CommentObjectRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((CommentObjectRealmProxyInterface) object).realmGet$id());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.timeIndex, rowIndex, ((CommentObjectRealmProxyInterface)object).realmGet$time(), false);
                String realmGet$title = ((CommentObjectRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                }
                String realmGet$by = ((CommentObjectRealmProxyInterface)object).realmGet$by();
                if (realmGet$by != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.byIndex, rowIndex, realmGet$by, false);
                }
                String realmGet$text = ((CommentObjectRealmProxyInterface)object).realmGet$text();
                if (realmGet$text != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.textIndex, rowIndex, realmGet$text, false);
                }
                String realmGet$type = ((CommentObjectRealmProxyInterface)object).realmGet$type();
                if (realmGet$type != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject.class);
        long tableNativePtr = table.getNativePtr();
        CommentObjectColumnInfo columnInfo = (CommentObjectColumnInfo) realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((CommentObjectRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CommentObjectRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((CommentObjectRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.timeIndex, rowIndex, ((CommentObjectRealmProxyInterface)object).realmGet$time(), false);
        String realmGet$title = ((CommentObjectRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$by = ((CommentObjectRealmProxyInterface)object).realmGet$by();
        if (realmGet$by != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.byIndex, rowIndex, realmGet$by, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.byIndex, rowIndex, false);
        }
        String realmGet$text = ((CommentObjectRealmProxyInterface)object).realmGet$text();
        if (realmGet$text != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.textIndex, rowIndex, realmGet$text, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.textIndex, rowIndex, false);
        }
        String realmGet$type = ((CommentObjectRealmProxyInterface)object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject.class);
        long tableNativePtr = table.getNativePtr();
        CommentObjectColumnInfo columnInfo = (CommentObjectColumnInfo) realm.schema.getColumnInfo(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject object = null;
        while (objects.hasNext()) {
            object = (com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((CommentObjectRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CommentObjectRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((CommentObjectRealmProxyInterface) object).realmGet$id());
                }
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.timeIndex, rowIndex, ((CommentObjectRealmProxyInterface)object).realmGet$time(), false);
                String realmGet$title = ((CommentObjectRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
                }
                String realmGet$by = ((CommentObjectRealmProxyInterface)object).realmGet$by();
                if (realmGet$by != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.byIndex, rowIndex, realmGet$by, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.byIndex, rowIndex, false);
                }
                String realmGet$text = ((CommentObjectRealmProxyInterface)object).realmGet$text();
                if (realmGet$text != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.textIndex, rowIndex, realmGet$text, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.textIndex, rowIndex, false);
                }
                String realmGet$type = ((CommentObjectRealmProxyInterface)object).realmGet$type();
                if (realmGet$type != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject createDetachedCopy(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject)cachedObject.object;
            } else {
                unmanagedObject = (com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((CommentObjectRealmProxyInterface) unmanagedObject).realmSet$id(((CommentObjectRealmProxyInterface) realmObject).realmGet$id());
        ((CommentObjectRealmProxyInterface) unmanagedObject).realmSet$time(((CommentObjectRealmProxyInterface) realmObject).realmGet$time());
        ((CommentObjectRealmProxyInterface) unmanagedObject).realmSet$title(((CommentObjectRealmProxyInterface) realmObject).realmGet$title());
        ((CommentObjectRealmProxyInterface) unmanagedObject).realmSet$by(((CommentObjectRealmProxyInterface) realmObject).realmGet$by());
        ((CommentObjectRealmProxyInterface) unmanagedObject).realmSet$text(((CommentObjectRealmProxyInterface) realmObject).realmGet$text());
        ((CommentObjectRealmProxyInterface) unmanagedObject).realmSet$type(((CommentObjectRealmProxyInterface) realmObject).realmGet$type());
        return unmanagedObject;
    }

    static com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject update(Realm realm, com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject realmObject, com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((CommentObjectRealmProxyInterface) realmObject).realmSet$time(((CommentObjectRealmProxyInterface) newObject).realmGet$time());
        ((CommentObjectRealmProxyInterface) realmObject).realmSet$title(((CommentObjectRealmProxyInterface) newObject).realmGet$title());
        ((CommentObjectRealmProxyInterface) realmObject).realmSet$by(((CommentObjectRealmProxyInterface) newObject).realmGet$by());
        ((CommentObjectRealmProxyInterface) realmObject).realmSet$text(((CommentObjectRealmProxyInterface) newObject).realmGet$text());
        ((CommentObjectRealmProxyInterface) realmObject).realmSet$type(((CommentObjectRealmProxyInterface) newObject).realmGet$type());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("CommentObject = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{time:");
        stringBuilder.append(realmGet$time());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{by:");
        stringBuilder.append(realmGet$by() != null ? realmGet$by() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{text:");
        stringBuilder.append(realmGet$text() != null ? realmGet$text() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type() != null ? realmGet$type() : "null");
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
        CommentObjectRealmProxy aCommentObject = (CommentObjectRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCommentObject.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCommentObject.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCommentObject.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
