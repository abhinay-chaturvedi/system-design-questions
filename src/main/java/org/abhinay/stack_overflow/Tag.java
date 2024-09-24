package org.abhinay.stack_overflow;

public class Tag {

    private final int id;
    private final String name;
    public Tag(String name) {
        this.id = generateId();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int generateId() {
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
