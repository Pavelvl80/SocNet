package com;

/**
 * Created by Edvard Piri on 19.10.2016.
 */
public class ID {
    private long id;

    public ID(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID{" +
                "id=" + id +
                '}';
    }
}
