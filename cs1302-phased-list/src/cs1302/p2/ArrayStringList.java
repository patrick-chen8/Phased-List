package cs1302.p2;

import cs1302.adt.StringList;

/**
 * A class that uses String arrays and is the child of
 * {@code BaseStringList}.
 */
public class ArrayStringList extends BaseStringList {

    private String [] list;
    private int arraySize;

    /**
     * A constructor that creates a {@code ArrayStringList} object.
     */
    public ArrayStringList () {
        arraySize = 1;
        list = new String [arraySize];
    }

    /**
     * A private method that resizes the array when the size of the
     * list is almost as large as the array.
     */
    private void resizeArray() {

        if (size == 0) {
            arraySize = 2;
            list = new String [arraySize];
        } else {
            String [] tempList =  new String [size];
            for (int i = 0; i < tempList.length; i++) {
                tempList[i] = list [i];
            }
            arraySize = arraySize + 1 + size / 2;
            list = new String [arraySize];
            for (int i = 0; i < list.length; i++) {
                if (i < tempList.length) {
                    list [i] = tempList[i];
                } else {
                    list [i] = null;
                }
            }
        }
    }

    /**
     * A method that adds a string at the specified index.
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, String item) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("The index is out of bounds");
        } else if (item.length() == 0) {
            throw new IllegalArgumentException("The string cannot be empty");
        } else if (item == null) {
            throw new NullPointerException("The string cannot be null");
        } else {
            while (size + 1 >= arraySize) {
                resizeArray();
            }
            if (list [index] == null) {
                list [index] = item;
            } else {
                String [] tempList =  new String [size];
                for (int i = 0; i < size; i++) {
                    tempList [i] = list [i];
                }
                for (int i = index; i < size; i++) {
                    list [i + 1] = tempList [i];

                }
                list [index] = item;
            }
            size++;
            return true;
        }
    }

    /**
     * Clears the list of strings in the array.
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        list = new String [1];
        arraySize = list.length;
        size = 0;
    }

    /**
     * Returns the item at a specified index position
     * in the list.
     * {@inheritDoc}
     */
    @Override
    public String get(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("The index is out of bounds");
        } else {
            return list[index];
        }
    }

    /**
     * Removes a string from the list at a certain index and shifts
     * the remaining indicies accordingly.
     * {@inheritDoc}
     */
    @Override
    public String remove(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("The index is out of bounds");
        } else {
            String item = list [index];
            String [] tempList =  new String [list.length];
            for (int i = 0; i < tempList.length; i++) {
                tempList [i] = list [i];
            }
            for (int i = index; i < list.length; i++) {
                if (i < list.length - 1) {
                    list [i] = tempList [i + 1];
                } else {
                    list [i] = null;
                }
            }
            size--;
            return item;
        }
    }

    /**
     * A method that slices the original list to create a
     * {@code StringList} object.
     * {@inheritDoc}
     */
    @Override
    public StringList slice(int start, int stop) {
        if (start < 0 || stop > this.size() || start > stop) {
            throw new IndexOutOfBoundsException("The start or stop index is out of bounds");
        } else {
            StringList asl = new ArrayStringList();
            int counter = 0;
            for (int i = start; i < stop; i ++) {
                asl.add(counter, this.get(i));
                counter++;
            }
            return asl;
        }
    } // slice
}
