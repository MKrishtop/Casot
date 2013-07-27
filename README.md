Casot
=====

Small android database. Thread-safety. Simplicity. Hidden-slowness.

Initial objective:

    Casot.path(String)
        .log(boolean)
        .init(AppContext);
        
    Casot.db(Clazz.class[, id, version])
    	.inMemory(limit)
        .add(Clazz)
        .remove(id)
        .remove(Clazz)
        .replace(Clazz)
        .get(id)
        .get(Casot.Filter<Clazz>, Casot.GetListener)
        .addAll(Iterable<Clazz>)
        .removeAll(Iterable<id>)
        .removeAll(Iterable<Clazz>)
        .replaceAll(Iterable<Clazz>)
        .getAll(Iterable<id>, Casot.GetListener)
        .getAll(Casot.Filter<Clazz>, Casot.GetListener)
        .destroy()
        .done(Casot.DoneListener)
        .commit();
        
        .info();
        
    class Clazz implements Marshalable { }
    
    public interface Marshalable {
        JSONObject marshal();
        void unmarshal(JSONObject json);
    }