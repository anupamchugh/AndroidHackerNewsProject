package io.realm;


import android.util.JsonReader;
import io.realm.RealmObjectSchema;
import io.realm.internal.ColumnInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>();
        modelClasses.add(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class);
        modelClasses.add(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject.class);
        modelClasses.add(com.anupamchugh.androidhackernewsproject.realmPOJO.Posts.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);

        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class)) {
            return io.realm.PostIdRealmObjectRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject.class)) {
            return io.realm.CommentIdObjectRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.Posts.class)) {
            return io.realm.PostsRealmProxy.createRealmObjectSchema(realmSchema);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);

        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class)) {
            return io.realm.PostIdRealmObjectRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject.class)) {
            return io.realm.CommentIdObjectRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.Posts.class)) {
            return io.realm.PostsRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class)) {
            return io.realm.PostIdRealmObjectRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject.class)) {
            return io.realm.CommentIdObjectRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.Posts.class)) {
            return io.realm.PostsRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class)) {
            return io.realm.PostIdRealmObjectRealmProxy.getTableName();
        }
        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject.class)) {
            return io.realm.CommentIdObjectRealmProxy.getTableName();
        }
        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.Posts.class)) {
            return io.realm.PostsRealmProxy.getTableName();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class)) {
                return clazz.cast(new io.realm.PostIdRealmObjectRealmProxy());
            }
            if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject.class)) {
                return clazz.cast(new io.realm.CommentIdObjectRealmProxy());
            }
            if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.Posts.class)) {
                return clazz.cast(new io.realm.PostsRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class)) {
            return clazz.cast(io.realm.PostIdRealmObjectRealmProxy.copyOrUpdate(realm, (com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject) obj, update, cache));
        }
        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject.class)) {
            return clazz.cast(io.realm.CommentIdObjectRealmProxy.copyOrUpdate(realm, (com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject) obj, update, cache));
        }
        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.Posts.class)) {
            return clazz.cast(io.realm.PostsRealmProxy.copyOrUpdate(realm, (com.anupamchugh.androidhackernewsproject.realmPOJO.Posts) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class)) {
            io.realm.PostIdRealmObjectRealmProxy.insert(realm, (com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject) object, cache);
        } else if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject.class)) {
            io.realm.CommentIdObjectRealmProxy.insert(realm, (com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject) object, cache);
        } else if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.Posts.class)) {
            io.realm.PostsRealmProxy.insert(realm, (com.anupamchugh.androidhackernewsproject.realmPOJO.Posts) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class)) {
                io.realm.PostIdRealmObjectRealmProxy.insert(realm, (com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject) object, cache);
            } else if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject.class)) {
                io.realm.CommentIdObjectRealmProxy.insert(realm, (com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject) object, cache);
            } else if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.Posts.class)) {
                io.realm.PostsRealmProxy.insert(realm, (com.anupamchugh.androidhackernewsproject.realmPOJO.Posts) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class)) {
                    io.realm.PostIdRealmObjectRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject.class)) {
                    io.realm.CommentIdObjectRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.Posts.class)) {
                    io.realm.PostsRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class)) {
            io.realm.PostIdRealmObjectRealmProxy.insertOrUpdate(realm, (com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject) obj, cache);
        } else if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject.class)) {
            io.realm.CommentIdObjectRealmProxy.insertOrUpdate(realm, (com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject) obj, cache);
        } else if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.Posts.class)) {
            io.realm.PostsRealmProxy.insertOrUpdate(realm, (com.anupamchugh.androidhackernewsproject.realmPOJO.Posts) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class)) {
                io.realm.PostIdRealmObjectRealmProxy.insertOrUpdate(realm, (com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject) object, cache);
            } else if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject.class)) {
                io.realm.CommentIdObjectRealmProxy.insertOrUpdate(realm, (com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject) object, cache);
            } else if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.Posts.class)) {
                io.realm.PostsRealmProxy.insertOrUpdate(realm, (com.anupamchugh.androidhackernewsproject.realmPOJO.Posts) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class)) {
                    io.realm.PostIdRealmObjectRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject.class)) {
                    io.realm.CommentIdObjectRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.Posts.class)) {
                    io.realm.PostsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class)) {
            return clazz.cast(io.realm.PostIdRealmObjectRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject.class)) {
            return clazz.cast(io.realm.CommentIdObjectRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.Posts.class)) {
            return clazz.cast(io.realm.PostsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class)) {
            return clazz.cast(io.realm.PostIdRealmObjectRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject.class)) {
            return clazz.cast(io.realm.CommentIdObjectRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.Posts.class)) {
            return clazz.cast(io.realm.PostsRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject.class)) {
            return clazz.cast(io.realm.PostIdRealmObjectRealmProxy.createDetachedCopy((com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject.class)) {
            return clazz.cast(io.realm.CommentIdObjectRealmProxy.createDetachedCopy((com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.anupamchugh.androidhackernewsproject.realmPOJO.Posts.class)) {
            return clazz.cast(io.realm.PostsRealmProxy.createDetachedCopy((com.anupamchugh.androidhackernewsproject.realmPOJO.Posts) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
