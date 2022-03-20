package com.assignment.persistence.inmemory;

import com.assignment.entity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class InMemoryDB {

    private ArrayList<Entity> memory = new ArrayList<>();
    private static InMemoryDB inMemoryDB;

    private InMemoryDB() {}

    public static InMemoryDB instance()
    {
        if(inMemoryDB==null)
            inMemoryDB = new InMemoryDB();

        return inMemoryDB;
    }



    public synchronized void save(Entity entity) {

        if(doesExistAlready(entity))
            throw new RuntimeException("entity with id "+entity.id+ " already exists!");

        memory.add(entity);
    }

    private boolean doesExistAlready(Entity entity)
    {
        return memory.stream().anyMatch(it->it.id.equals(entity.id));
    }

    public <T> List<T> filter(Class<T> entityClass, Predicate<? super T> predicate)
    {
        return findAll(entityClass)
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public <T> List<T> findAll(Class<T> entityClas) {
        return memory
                .stream()
                .filter(it->it.getClass().isAssignableFrom(entityClas))
                .map(it->((T)it))
                .collect(Collectors.toList());
    }

    public synchronized void update(Entity entity) {
        memory.remove(entity);
        memory.add(entity);
    }

    public synchronized void delete(Entity entity) {
        memory.remove(entity);
    }

    public Entity findById(String id)
    {
        var result = memory
                .stream()
                .filter(it->it.id.equals(id))
                .collect(Collectors.toList());

        if(result.isEmpty())
            return null;

        return result.get(0);
    }

    public void deleteWhereIdEquals(String id) {
        delete(findById(id));
    }
}
