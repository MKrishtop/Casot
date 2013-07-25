Casot
=====

Small android database. Thread-safety. Simplicity. Hidden-slowness.

Initial objective:

    Casot.context(AppContext)
        .path(String)
        .log(boolean)
        .init();
        
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
        JSONObject murshal(Marshalable marshalable);
        Marshalable unmarshal(JSONObject json);
    }
  
