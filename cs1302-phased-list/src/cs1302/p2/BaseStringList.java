package cs1302.p2;

import cs1302.adt.StringList;

/**
 * An abstract class that implements {@code StringList} so that its
 * child classes can use the methods from StringList.
 */
public abstract class BaseStringList implements StringList {

    protected int size; // variable that stores the size

    /**
     * A constructor that creates a {@code BaseStringList} object.
     */
    public BaseStringList() {
        size = 0;
    }

    /**
     * A method that adds an item to the end of the list.
     * {@inheritDoc}
     */
    @Override
    public boolean append(String item) {
        if (item.length() == 0) {
            throw new IllegalArgumentException("The string cannot be empty");
        } else if (item == null) {
            throw new NullPointerException("The string cannot be null");
        } else {
            this.add(this.size(),item);
            return true;
        }
    }

    /**
     * A method that checks if a list is empty.
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * A method that creates a String representation of the list.
     * {@inheritDoc}
     */
    @Override
    public String makeString(String start, String sep, String end) {
        String result = start;
        if (size > 0) {
            for (int i = 0; i < size - 1; i++) {
                result = result + this.get(i) + sep;
            }
            result = result + this.get(size - 1) + end;
        } else {
            result = result + end;
        }
        return result;
    }

    /**
     * A method that adds an item to the beginning of a list.
     * {@inheritDoc}
     */
    @Override
    public boolean prepend(String item) {
        if (item.length() == 0) {
            throw new IllegalArgumentException("The string cannot be empty");
        } else if (item == null) {
            throw new NullPointerException("The string cannot be null");
        } else {
            this.add(0,item);
            return true;
        }
    }

    /**
     * A method that returns the size of the list.
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * A method that creates a string representation of the list.
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return makeString("[", ", ", "]");
    }

}
