Casot
=====

Small android database. Thread-safety. Simplicity. Hidden-slowness.

TODO

    Casot.context(AppContext)
        .path(String)
        .memory(limit)
        .init();
        
    Casot.db(Clazz.class[, id, version])
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
        
    class Clazz implements Marshalable { }
    
    public interface Marshalable {
        JSONObject murshal(Marshalable marshalable);
        Marshalable unmarshal(JSONObject json);
    }
  
