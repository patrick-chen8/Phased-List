package cs1302.p2;

import cs1302.adt.Node;
import cs1302.adt.StringList;

/**
 * A class that utilizes nodes and the methods from
 * {@code BaseStringList} to manipulate String data.
 */
public class LinkedStringList extends BaseStringList {

    Node head;

    /**
     * A constructor that creates a {@code LinkedStringList}
     * object.
     */
    public LinkedStringList () {
        head  = null;
    }

    /**
     * A method that adds a string to the linked list.
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, String item) {
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException("That index is out of bounds");
        } else if (item.length() == 0) {
            throw new IllegalArgumentException("The string cannot be empty");
        } else if (item == null) {
            throw new NullPointerException("The string cannot be null");
        } else {
            if (size == 0 && index == 0) {
                head = new Node(item);
            } else if (index == 0) {
                Node placeholder = head;
                head = new Node(item, placeholder);
            } else if (index == size) {
                int counter = 0;
                Node reference = head;
                while (counter < index - 1) {
                    reference = reference.getNext();
                    counter++;
                }
                reference.setNext(new Node(item));
            } else {
                int counter = 0;
                Node reference = head;
                Node firstCut = head;
                Node secondCut;
                while (counter < index) {
                    if (counter < index - 1) {
                        firstCut = firstCut.getNext();
                    }
                    reference = reference.getNext();
                    counter++;
                }
                secondCut = reference;
                reference = new Node(item, secondCut);
                firstCut.setNext(reference);
            }
            size++;
            return true;
        }
    } // add

    /**
     * A method that clears the linked list.
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        size = 0;
        head = null;
    } // clear

    /**
     * A method that returns the string at an index.
     * {@inheritDoc}
     */
    @Override
    public String get(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("The index is out of bounds");
        } else {
            Node placeholder = head;
            for (int i = 0; i < index; i++) {
                placeholder = placeholder.getNext();
            }
            return placeholder.getItem();
        }
    } // get

    /**
     * A method that removes an item from a list at an index.
     * {@inheritDoc}
     */
    @Override
    public String remove(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("The index is out of bounds");
        } else {
            String removed = "";
            if (index == 0) {
                removed = head.getItem();
                head =  head.getNext();
            } else {
                int counter = 0;
                Node firstCut = head;
                Node secondCut;
                while (counter < index - 1) {
                    firstCut = firstCut.getNext();
                    counter++;
                }
                removed = firstCut.getNext().getItem();
                secondCut = firstCut.getNext().getNext();
                firstCut.setNext(secondCut);
            }
            size--;
            return removed;
        }
    } // remove

    /**
     * A method that creates a {@code StringList} object that is
     * sliced from the original list.
     * {@inheritDoc}
     */
    @Override
    public StringList slice(int start, int stop) {
        StringList lsl = new LinkedStringList();
        if (start < 0 || stop > this.size() || start > stop) {
            throw new IndexOutOfBoundsException("The start or stop index is out of bounds");
        } else {
            int counter = 0;
            for (int i = start; i < stop; i++) {
                lsl.add(counter,this.get(i));
                counter++;
            }
            return lsl;
        }
    } // slice
}
