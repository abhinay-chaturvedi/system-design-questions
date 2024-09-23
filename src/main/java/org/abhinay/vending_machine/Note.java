package org.abhinay.vending_machine;

public enum Note {
    ONE(1),
    FIVE(5),
    TEN(10),
    TWENTY(20);

    private final int value;
    Note(int value) {
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
}
