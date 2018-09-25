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
        long linkIndex;
        long votesIndex;
        long commentsIndex;
        long idIndex;
        long timeStampIndex;
        long titleIndex;
        long authorIndex;
        long urlIndex;
        long scoreIndex;
        long commentIdObjectRealmListIndex;

        PostsColumnInfo(SharedRealm realm, Table table) {
            super(10);
            this.linkIndex = addColumnDetails(table, "link", RealmFieldType.STRING);
            this.votesIndex = addColumnDetails(table, "votes", RealmFieldType.STRING);
            this.commentsIndex = addColumnDetails(table, "comments", RealmFieldType.STRING);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.timeStampIndex = addColumnDetails(table, "timeStamp", RealmFieldType.INTEGER);
            this.titleIndex = addColumnDetails(table, "title", RealmFieldType.STRING);
            this.authorIndex = addColumnDetails(table, "author", RealmFieldType.STRING);
            this.urlIndex = addColumnDetails(table, "url", RealmFieldType.STRING);
            this.scoreIndex = addColumnDetails(table, "score", RealmFieldType.INTEGER);
            this.commentIdObjectRealmListIndex = addColumnDetails(table, "commentIdObjectRealmList", RealmFieldType.LIST);
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
            dst.linkIndex = src.linkIndex;
            dst.votesIndex = src.votesIndex;
            dst.commentsIndex = src.commentsIndex;
            dst.idIndex = src.idIndex;
            dst.timeStampIndex = src.timeStampIndex;
            dst.titleIndex = src.titleIndex;
            dst.authorIndex = src.authorIndex;
            dst.urlIndex = src.urlIndex;
            dst.scoreIndex = src.scoreIndex;
            dst.commentIdObjectRealmListIndex = src.commentIdObjectRealmListIndex;
        }
    }

    private PostsColumnInfo columnInfo;
    private ProxyState<com.anupamchugh.androidhackernewsproject.Posts> proxyState;
    private RealmList<com.anupamchugh.androidhackernewsproject.CommentIdObject> commentIdObjectRealmListRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("link");
        fieldNames.add("votes");
        fieldNames.add("comments");
        fieldNames.add("id");
        fieldNames.add("timeStamp");
        fieldNames.add("title");
        fieldNames.add("author");
        fieldNames.add("url");
        fieldNames.add("score");
        fieldNames.add("commentIdObjectRealmList");
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

    @Override
    @SuppressWarnings("cast")
    public long realmGet$timeStamp() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.timeStampIndex);
    }

    @Override
    public void realmSet$timeStamp(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.timeStampIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.timeStampIndex, value);
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
    public String realmGet$author() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.authorIndex);
    }

    @Override
    public void realmSet$author(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.authorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.authorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.authorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.authorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$url() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.urlIndex);
    }

    @Override
    public void realmSet$url(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.urlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.urlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.urlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.urlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$score() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.scoreIndex);
    }

    @Override
    public void realmSet$score(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.scoreIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.scoreIndex, value);
    }

    @Override
    public RealmList<com.anupamchugh.androidhackernewsproject.CommentIdObject> realmGet$commentIdObjectRealmList() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (commentIdObjectRealmListRealmList != null) {
            return commentIdObjectRealmListRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.commentIdObjectRealmListIndex);
            commentIdObjectRealmListRealmList = new RealmList<com.anupamchugh.androidhackernewsproject.CommentIdObject>(com.anupamchugh.androidhackernewsproject.CommentIdObject.class, linkView, proxyState.getRealm$realm());
            return commentIdObjectRealmListRealmList;
        }
    }

    @Override
    public void realmSet$commentIdObjectRealmList(RealmList<com.anupamchugh.androidhackernewsproject.CommentIdObject> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("commentIdObjectRealmList")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.anupamchugh.androidhackernewsproject.CommentIdObject> original = value;
                value = new RealmList<com.anupamchugh.androidhackernewsproject.CommentIdObject>();
                for (com.anupamchugh.androidhackernewsproject.CommentIdObject item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.commentIdObjectRealmListIndex);
        links.clear();
        if (value == null) {
            return;
        }
        for (RealmModel linkedObject : (RealmList<? extends RealmModel>) value) {
            if (!(RealmObject.isManaged(linkedObject) && RealmObject.isValid(linkedObject))) {
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
            if (((RealmObjectProxy)linkedObject).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
            }
            links.add(((RealmObjectProxy)linkedObject).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Posts")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Posts");
            realmObjectSchema.add("link", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("votes", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("comments", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("timeStamp", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("author", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("url", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("score", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            if (!realmSchema.contains("CommentIdObject")) {
                CommentIdObjectRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("commentIdObjectRealmList", RealmFieldType.LIST, realmSchema.get("CommentIdObject"));
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
        if (columnCount != 10) {
            if (columnCount < 10) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 10 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 10 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 10 but was " + columnCount);
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

        if (!columnTypes.containsKey("link")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'link' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("link") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'link' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.linkIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'link' is required. Either set @Required to field 'link' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("timeStamp")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'timeStamp' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("timeStamp") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'timeStamp' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.timeStampIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'timeStamp' does support null values in the existing Realm file. Use corresponding boxed type for field 'timeStamp' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("author")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'author' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("author") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'author' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.authorIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'author' is required. Either set @Required to field 'author' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("url")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'url' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("url") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'url' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.urlIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'url' is required. Either set @Required to field 'url' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("score")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'score' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("score") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'score' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.scoreIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'score' does support null values in the existing Realm file. Use corresponding boxed type for field 'score' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("commentIdObjectRealmList")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'commentIdObjectRealmList'");
        }
        if (columnTypes.get("commentIdObjectRealmList") != RealmFieldType.LIST) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'CommentIdObject' for field 'commentIdObjectRealmList'");
        }
        if (!sharedRealm.hasTable("class_CommentIdObject")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_CommentIdObject' for field 'commentIdObjectRealmList'");
        }
        Table table_9 = sharedRealm.getTable("class_CommentIdObject");
        if (!table.getLinkTarget(columnInfo.commentIdObjectRealmListIndex).hasSameSchema(table_9)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'commentIdObjectRealmList': '" + table.getLinkTarget(columnInfo.commentIdObjectRealmListIndex).getName() + "' expected - was '" + table_9.getName() + "'");
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
        final List<String> excludeFields = new ArrayList<String>(1);
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
            if (json.has("commentIdObjectRealmList")) {
                excludeFields.add("commentIdObjectRealmList");
            }
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
        if (json.has("link")) {
            if (json.isNull("link")) {
                ((PostsRealmProxyInterface) obj).realmSet$link(null);
            } else {
                ((PostsRealmProxyInterface) obj).realmSet$link((String) json.getString("link"));
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
        if (json.has("timeStamp")) {
            if (json.isNull("timeStamp")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'timeStamp' to null.");
            } else {
                ((PostsRealmProxyInterface) obj).realmSet$timeStamp((long) json.getLong("timeStamp"));
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                ((PostsRealmProxyInterface) obj).realmSet$title(null);
            } else {
                ((PostsRealmProxyInterface) obj).realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("author")) {
            if (json.isNull("author")) {
                ((PostsRealmProxyInterface) obj).realmSet$author(null);
            } else {
                ((PostsRealmProxyInterface) obj).realmSet$author((String) json.getString("author"));
            }
        }
        if (json.has("url")) {
            if (json.isNull("url")) {
                ((PostsRealmProxyInterface) obj).realmSet$url(null);
            } else {
                ((PostsRealmProxyInterface) obj).realmSet$url((String) json.getString("url"));
            }
        }
        if (json.has("score")) {
            if (json.isNull("score")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'score' to null.");
            } else {
                ((PostsRealmProxyInterface) obj).realmSet$score((int) json.getInt("score"));
            }
        }
        if (json.has("commentIdObjectRealmList")) {
            if (json.isNull("commentIdObjectRealmList")) {
                ((PostsRealmProxyInterface) obj).realmSet$commentIdObjectRealmList(null);
            } else {
                ((PostsRealmProxyInterface) obj).realmGet$commentIdObjectRealmList().clear();
                JSONArray array = json.getJSONArray("commentIdObjectRealmList");
                for (int i = 0; i < array.length(); i++) {
                    com.anupamchugh.androidhackernewsproject.CommentIdObject item = CommentIdObjectRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((PostsRealmProxyInterface) obj).realmGet$commentIdObjectRealmList().add(item);
                }
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
            } else if (name.equals("link")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PostsRealmProxyInterface) obj).realmSet$link(null);
                } else {
                    ((PostsRealmProxyInterface) obj).realmSet$link((String) reader.nextString());
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
            } else if (name.equals("timeStamp")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'timeStamp' to null.");
                } else {
                    ((PostsRealmProxyInterface) obj).realmSet$timeStamp((long) reader.nextLong());
                }
            } else if (name.equals("title")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PostsRealmProxyInterface) obj).realmSet$title(null);
                } else {
                    ((PostsRealmProxyInterface) obj).realmSet$title((String) reader.nextString());
                }
            } else if (name.equals("author")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PostsRealmProxyInterface) obj).realmSet$author(null);
                } else {
                    ((PostsRealmProxyInterface) obj).realmSet$author((String) reader.nextString());
                }
            } else if (name.equals("url")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PostsRealmProxyInterface) obj).realmSet$url(null);
                } else {
                    ((PostsRealmProxyInterface) obj).realmSet$url((String) reader.nextString());
                }
            } else if (name.equals("score")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'score' to null.");
                } else {
                    ((PostsRealmProxyInterface) obj).realmSet$score((int) reader.nextInt());
                }
            } else if (name.equals("commentIdObjectRealmList")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PostsRealmProxyInterface) obj).realmSet$commentIdObjectRealmList(null);
                } else {
                    ((PostsRealmProxyInterface) obj).realmSet$commentIdObjectRealmList(new RealmList<com.anupamchugh.androidhackernewsproject.CommentIdObject>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.anupamchugh.androidhackernewsproject.CommentIdObject item = CommentIdObjectRealmProxy.createUsingJsonStream(realm, reader);
                        ((PostsRealmProxyInterface) obj).realmGet$commentIdObjectRealmList().add(item);
                    }
                    reader.endArray();
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
            ((PostsRealmProxyInterface) realmObject).realmSet$link(((PostsRealmProxyInterface) newObject).realmGet$link());
            ((PostsRealmProxyInterface) realmObject).realmSet$votes(((PostsRealmProxyInterface) newObject).realmGet$votes());
            ((PostsRealmProxyInterface) realmObject).realmSet$comments(((PostsRealmProxyInterface) newObject).realmGet$comments());
            ((PostsRealmProxyInterface) realmObject).realmSet$timeStamp(((PostsRealmProxyInterface) newObject).realmGet$timeStamp());
            ((PostsRealmProxyInterface) realmObject).realmSet$title(((PostsRealmProxyInterface) newObject).realmGet$title());
            ((PostsRealmProxyInterface) realmObject).realmSet$author(((PostsRealmProxyInterface) newObject).realmGet$author());
            ((PostsRealmProxyInterface) realmObject).realmSet$url(((PostsRealmProxyInterface) newObject).realmGet$url());
            ((PostsRealmProxyInterface) realmObject).realmSet$score(((PostsRealmProxyInterface) newObject).realmGet$score());

            RealmList<com.anupamchugh.androidhackernewsproject.CommentIdObject> commentIdObjectRealmListList = ((PostsRealmProxyInterface) newObject).realmGet$commentIdObjectRealmList();
            if (commentIdObjectRealmListList != null) {
                RealmList<com.anupamchugh.androidhackernewsproject.CommentIdObject> commentIdObjectRealmListRealmList = ((PostsRealmProxyInterface) realmObject).realmGet$commentIdObjectRealmList();
                for (int i = 0; i < commentIdObjectRealmListList.size(); i++) {
                    com.anupamchugh.androidhackernewsproject.CommentIdObject commentIdObjectRealmListItem = commentIdObjectRealmListList.get(i);
                    com.anupamchugh.androidhackernewsproject.CommentIdObject cachecommentIdObjectRealmList = (com.anupamchugh.androidhackernewsproject.CommentIdObject) cache.get(commentIdObjectRealmListItem);
                    if (cachecommentIdObjectRealmList != null) {
                        commentIdObjectRealmListRealmList.add(cachecommentIdObjectRealmList);
                    } else {
                        commentIdObjectRealmListRealmList.add(CommentIdObjectRealmProxy.copyOrUpdate(realm, commentIdObjectRealmListList.get(i), update, cache));
                    }
                }
            }

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
        String realmGet$link = ((PostsRealmProxyInterface)object).realmGet$link();
        if (realmGet$link != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
        }
        String realmGet$votes = ((PostsRealmProxyInterface)object).realmGet$votes();
        if (realmGet$votes != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.votesIndex, rowIndex, realmGet$votes, false);
        }
        String realmGet$comments = ((PostsRealmProxyInterface)object).realmGet$comments();
        if (realmGet$comments != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.commentsIndex, rowIndex, realmGet$comments, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.timeStampIndex, rowIndex, ((PostsRealmProxyInterface)object).realmGet$timeStamp(), false);
        String realmGet$title = ((PostsRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$author = ((PostsRealmProxyInterface)object).realmGet$author();
        if (realmGet$author != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
        }
        String realmGet$url = ((PostsRealmProxyInterface)object).realmGet$url();
        if (realmGet$url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.scoreIndex, rowIndex, ((PostsRealmProxyInterface)object).realmGet$score(), false);

        RealmList<com.anupamchugh.androidhackernewsproject.CommentIdObject> commentIdObjectRealmListList = ((PostsRealmProxyInterface) object).realmGet$commentIdObjectRealmList();
        if (commentIdObjectRealmListList != null) {
            long commentIdObjectRealmListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.commentIdObjectRealmListIndex, rowIndex);
            for (com.anupamchugh.androidhackernewsproject.CommentIdObject commentIdObjectRealmListItem : commentIdObjectRealmListList) {
                Long cacheItemIndexcommentIdObjectRealmList = cache.get(commentIdObjectRealmListItem);
                if (cacheItemIndexcommentIdObjectRealmList == null) {
                    cacheItemIndexcommentIdObjectRealmList = CommentIdObjectRealmProxy.insert(realm, commentIdObjectRealmListItem, cache);
                }
                LinkView.nativeAdd(commentIdObjectRealmListNativeLinkViewPtr, cacheItemIndexcommentIdObjectRealmList);
            }
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
                String realmGet$link = ((PostsRealmProxyInterface)object).realmGet$link();
                if (realmGet$link != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
                }
                String realmGet$votes = ((PostsRealmProxyInterface)object).realmGet$votes();
                if (realmGet$votes != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.votesIndex, rowIndex, realmGet$votes, false);
                }
                String realmGet$comments = ((PostsRealmProxyInterface)object).realmGet$comments();
                if (realmGet$comments != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.commentsIndex, rowIndex, realmGet$comments, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.timeStampIndex, rowIndex, ((PostsRealmProxyInterface)object).realmGet$timeStamp(), false);
                String realmGet$title = ((PostsRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                }
                String realmGet$author = ((PostsRealmProxyInterface)object).realmGet$author();
                if (realmGet$author != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
                }
                String realmGet$url = ((PostsRealmProxyInterface)object).realmGet$url();
                if (realmGet$url != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.scoreIndex, rowIndex, ((PostsRealmProxyInterface)object).realmGet$score(), false);

                RealmList<com.anupamchugh.androidhackernewsproject.CommentIdObject> commentIdObjectRealmListList = ((PostsRealmProxyInterface) object).realmGet$commentIdObjectRealmList();
                if (commentIdObjectRealmListList != null) {
                    long commentIdObjectRealmListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.commentIdObjectRealmListIndex, rowIndex);
                    for (com.anupamchugh.androidhackernewsproject.CommentIdObject commentIdObjectRealmListItem : commentIdObjectRealmListList) {
                        Long cacheItemIndexcommentIdObjectRealmList = cache.get(commentIdObjectRealmListItem);
                        if (cacheItemIndexcommentIdObjectRealmList == null) {
                            cacheItemIndexcommentIdObjectRealmList = CommentIdObjectRealmProxy.insert(realm, commentIdObjectRealmListItem, cache);
                        }
                        LinkView.nativeAdd(commentIdObjectRealmListNativeLinkViewPtr, cacheItemIndexcommentIdObjectRealmList);
                    }
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
        String realmGet$link = ((PostsRealmProxyInterface)object).realmGet$link();
        if (realmGet$link != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.linkIndex, rowIndex, false);
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
        Table.nativeSetLong(tableNativePtr, columnInfo.timeStampIndex, rowIndex, ((PostsRealmProxyInterface)object).realmGet$timeStamp(), false);
        String realmGet$title = ((PostsRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$author = ((PostsRealmProxyInterface)object).realmGet$author();
        if (realmGet$author != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.authorIndex, rowIndex, false);
        }
        String realmGet$url = ((PostsRealmProxyInterface)object).realmGet$url();
        if (realmGet$url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.urlIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.scoreIndex, rowIndex, ((PostsRealmProxyInterface)object).realmGet$score(), false);

        long commentIdObjectRealmListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.commentIdObjectRealmListIndex, rowIndex);
        LinkView.nativeClear(commentIdObjectRealmListNativeLinkViewPtr);
        RealmList<com.anupamchugh.androidhackernewsproject.CommentIdObject> commentIdObjectRealmListList = ((PostsRealmProxyInterface) object).realmGet$commentIdObjectRealmList();
        if (commentIdObjectRealmListList != null) {
            for (com.anupamchugh.androidhackernewsproject.CommentIdObject commentIdObjectRealmListItem : commentIdObjectRealmListList) {
                Long cacheItemIndexcommentIdObjectRealmList = cache.get(commentIdObjectRealmListItem);
                if (cacheItemIndexcommentIdObjectRealmList == null) {
                    cacheItemIndexcommentIdObjectRealmList = CommentIdObjectRealmProxy.insertOrUpdate(realm, commentIdObjectRealmListItem, cache);
                }
                LinkView.nativeAdd(commentIdObjectRealmListNativeLinkViewPtr, cacheItemIndexcommentIdObjectRealmList);
            }
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
                String realmGet$link = ((PostsRealmProxyInterface)object).realmGet$link();
                if (realmGet$link != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.linkIndex, rowIndex, false);
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
                Table.nativeSetLong(tableNativePtr, columnInfo.timeStampIndex, rowIndex, ((PostsRealmProxyInterface)object).realmGet$timeStamp(), false);
                String realmGet$title = ((PostsRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
                }
                String realmGet$author = ((PostsRealmProxyInterface)object).realmGet$author();
                if (realmGet$author != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.authorIndex, rowIndex, false);
                }
                String realmGet$url = ((PostsRealmProxyInterface)object).realmGet$url();
                if (realmGet$url != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.urlIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.scoreIndex, rowIndex, ((PostsRealmProxyInterface)object).realmGet$score(), false);

                long commentIdObjectRealmListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.commentIdObjectRealmListIndex, rowIndex);
                LinkView.nativeClear(commentIdObjectRealmListNativeLinkViewPtr);
                RealmList<com.anupamchugh.androidhackernewsproject.CommentIdObject> commentIdObjectRealmListList = ((PostsRealmProxyInterface) object).realmGet$commentIdObjectRealmList();
                if (commentIdObjectRealmListList != null) {
                    for (com.anupamchugh.androidhackernewsproject.CommentIdObject commentIdObjectRealmListItem : commentIdObjectRealmListList) {
                        Long cacheItemIndexcommentIdObjectRealmList = cache.get(commentIdObjectRealmListItem);
                        if (cacheItemIndexcommentIdObjectRealmList == null) {
                            cacheItemIndexcommentIdObjectRealmList = CommentIdObjectRealmProxy.insertOrUpdate(realm, commentIdObjectRealmListItem, cache);
                        }
                        LinkView.nativeAdd(commentIdObjectRealmListNativeLinkViewPtr, cacheItemIndexcommentIdObjectRealmList);
                    }
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
        ((PostsRealmProxyInterface) unmanagedObject).realmSet$link(((PostsRealmProxyInterface) realmObject).realmGet$link());
        ((PostsRealmProxyInterface) unmanagedObject).realmSet$votes(((PostsRealmProxyInterface) realmObject).realmGet$votes());
        ((PostsRealmProxyInterface) unmanagedObject).realmSet$comments(((PostsRealmProxyInterface) realmObject).realmGet$comments());
        ((PostsRealmProxyInterface) unmanagedObject).realmSet$id(((PostsRealmProxyInterface) realmObject).realmGet$id());
        ((PostsRealmProxyInterface) unmanagedObject).realmSet$timeStamp(((PostsRealmProxyInterface) realmObject).realmGet$timeStamp());
        ((PostsRealmProxyInterface) unmanagedObject).realmSet$title(((PostsRealmProxyInterface) realmObject).realmGet$title());
        ((PostsRealmProxyInterface) unmanagedObject).realmSet$author(((PostsRealmProxyInterface) realmObject).realmGet$author());
        ((PostsRealmProxyInterface) unmanagedObject).realmSet$url(((PostsRealmProxyInterface) realmObject).realmGet$url());
        ((PostsRealmProxyInterface) unmanagedObject).realmSet$score(((PostsRealmProxyInterface) realmObject).realmGet$score());

        // Deep copy of commentIdObjectRealmList
        if (currentDepth == maxDepth) {
            ((PostsRealmProxyInterface) unmanagedObject).realmSet$commentIdObjectRealmList(null);
        } else {
            RealmList<com.anupamchugh.androidhackernewsproject.CommentIdObject> managedcommentIdObjectRealmListList = ((PostsRealmProxyInterface) realmObject).realmGet$commentIdObjectRealmList();
            RealmList<com.anupamchugh.androidhackernewsproject.CommentIdObject> unmanagedcommentIdObjectRealmListList = new RealmList<com.anupamchugh.androidhackernewsproject.CommentIdObject>();
            ((PostsRealmProxyInterface) unmanagedObject).realmSet$commentIdObjectRealmList(unmanagedcommentIdObjectRealmListList);
            int nextDepth = currentDepth + 1;
            int size = managedcommentIdObjectRealmListList.size();
            for (int i = 0; i < size; i++) {
                com.anupamchugh.androidhackernewsproject.CommentIdObject item = CommentIdObjectRealmProxy.createDetachedCopy(managedcommentIdObjectRealmListList.get(i), nextDepth, maxDepth, cache);
                unmanagedcommentIdObjectRealmListList.add(item);
            }
        }
        return unmanagedObject;
    }

    static com.anupamchugh.androidhackernewsproject.Posts update(Realm realm, com.anupamchugh.androidhackernewsproject.Posts realmObject, com.anupamchugh.androidhackernewsproject.Posts newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((PostsRealmProxyInterface) realmObject).realmSet$link(((PostsRealmProxyInterface) newObject).realmGet$link());
        ((PostsRealmProxyInterface) realmObject).realmSet$votes(((PostsRealmProxyInterface) newObject).realmGet$votes());
        ((PostsRealmProxyInterface) realmObject).realmSet$comments(((PostsRealmProxyInterface) newObject).realmGet$comments());
        ((PostsRealmProxyInterface) realmObject).realmSet$timeStamp(((PostsRealmProxyInterface) newObject).realmGet$timeStamp());
        ((PostsRealmProxyInterface) realmObject).realmSet$title(((PostsRealmProxyInterface) newObject).realmGet$title());
        ((PostsRealmProxyInterface) realmObject).realmSet$author(((PostsRealmProxyInterface) newObject).realmGet$author());
        ((PostsRealmProxyInterface) realmObject).realmSet$url(((PostsRealmProxyInterface) newObject).realmGet$url());
        ((PostsRealmProxyInterface) realmObject).realmSet$score(((PostsRealmProxyInterface) newObject).realmGet$score());
        RealmList<com.anupamchugh.androidhackernewsproject.CommentIdObject> commentIdObjectRealmListList = ((PostsRealmProxyInterface) newObject).realmGet$commentIdObjectRealmList();
        RealmList<com.anupamchugh.androidhackernewsproject.CommentIdObject> commentIdObjectRealmListRealmList = ((PostsRealmProxyInterface) realmObject).realmGet$commentIdObjectRealmList();
        commentIdObjectRealmListRealmList.clear();
        if (commentIdObjectRealmListList != null) {
            for (int i = 0; i < commentIdObjectRealmListList.size(); i++) {
                com.anupamchugh.androidhackernewsproject.CommentIdObject commentIdObjectRealmListItem = commentIdObjectRealmListList.get(i);
                com.anupamchugh.androidhackernewsproject.CommentIdObject cachecommentIdObjectRealmList = (com.anupamchugh.androidhackernewsproject.CommentIdObject) cache.get(commentIdObjectRealmListItem);
                if (cachecommentIdObjectRealmList != null) {
                    commentIdObjectRealmListRealmList.add(cachecommentIdObjectRealmList);
                } else {
                    commentIdObjectRealmListRealmList.add(CommentIdObjectRealmProxy.copyOrUpdate(realm, commentIdObjectRealmListList.get(i), true, cache));
                }
            }
        }
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Posts = proxy[");
        stringBuilder.append("{link:");
        stringBuilder.append(realmGet$link() != null ? realmGet$link() : "null");
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
        stringBuilder.append(",");
        stringBuilder.append("{timeStamp:");
        stringBuilder.append(realmGet$timeStamp());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{author:");
        stringBuilder.append(realmGet$author() != null ? realmGet$author() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{url:");
        stringBuilder.append(realmGet$url() != null ? realmGet$url() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{score:");
        stringBuilder.append(realmGet$score());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{commentIdObjectRealmList:");
        stringBuilder.append("RealmList<CommentIdObject>[").append(realmGet$commentIdObjectRealmList().size()).append("]");
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
