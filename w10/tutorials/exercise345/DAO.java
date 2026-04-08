package w10.tutorials.exercise345;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class DAO<T extends Identifiable> {
    private final List<T> list = new ArrayList<>();

    public void add(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot add a null object.");
        }
        if (find(obj.getId()) != null) {
            throw new IllegalStateException(
                    "An object with ID " + obj.getId() + " already exists.");
        }
        list.add(obj);
    }

    public void remove(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot remove a null object.");
        }
        T existing = find(obj.getId());
        if (existing == null) {
            throw new IllegalStateException(
                    "No object with ID " + obj.getId() + " found for removal.");
        }
        list.remove(existing);
    }

    public List<T> getList() {
        return Collections.unmodifiableList(list);
    }

    public abstract void update(T obj);

    public abstract T find(int id);
}