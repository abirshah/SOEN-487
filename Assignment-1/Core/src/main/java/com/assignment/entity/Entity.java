package com.assignment.entity;

import com.assignment.dbGateway.AlbumDBGateway;

public class Entity {

    public final String id;

    public Entity(String id) {
        this.id = id;
    }

    public int hashCode() {
        return id.hashCode();
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof Entity))
            return false;

        return ((Entity)obj).id.equals(id);
    }
}
