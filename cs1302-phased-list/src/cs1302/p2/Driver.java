package cs1302.p2;

import cs1302.adt.Node;
import cs1302.adt.StringList;
import cs1302.oracle.OracleStringList;

/**
 * A Class that tests the functionality of the {@code ArrayStringList}
 * and {@code LinkedStringList}.
 */
public class Driver {

    public static void main(String[] args) {
        StringList sl;

        sl = new OracleStringList();
        //sl = new LinkedStringList();
        //sl = new ArrayStringList();

        testIsEmpty(sl);
        testSize(sl);
        testAdd(sl);
        sl.add(0,"bruh");
        testAdd(sl);
        sl.add(1,"test");
        sl.add(1,"middle");
        testAddNegative(sl);
        System.out.println(sl);
        testRemove(sl);
        System.out.println(sl);
        testRemoveNegative(sl);
        testGet(sl);
        testGetNegative(sl);
        testClear(sl);
        testIsEmpty(sl);
        testSize(sl);
        testAppend(sl);
        testPrepend(sl);
        sl.add(1,"filler");
        sl.add(1,"hello");
        sl.add(1,"world");
        sl.add(1,"pog");
        System.out.println(sl);
        testSlice(sl);
        System.out.println(sl.slice(1,5));


    } // main

    /**
     * A static method that tests the isEmpty() method.
     * @param list a Stringlist
     */
    public static void testIsEmpty(StringList list) {
        System.out.print("testIsEmpty: ");
        if (list.isEmpty()) {
            System.out.println("PASS: StringList is empty");
        } else {
            System.out.println("FAIL: StringList should start empty");
        } // if
    } // testIsEmpty

    /**
     * A static method that tests the size() method.
     * @param list a Stringlist
     */
    public static void testSize(StringList list) {
        System.out.print("testSize : ");
        if (list.size() == 0) {
            System.out.println("PASS: StringList has size 0");
        } else {
            System.out.println("FAIL: StringList should have size 0");
        } // if
    } // testSize

    /**
     * A static method that tests the add() method.
     * @param list a Stringlist
     */
    public static void testAdd(StringList list) {
        System.out.print("testAdd: ");
        try {
            list.add(0, "hello");    // replace "hello" with empty and null to test other cases
            System.out.println("PASS: no exception was encountered");
        } catch (IndexOutOfBoundsException ioob) {
            System.out.println("FAIL: IOOB was encountered: " + ioob.getMessage());
        } catch (NullPointerException npe) {
            System.out.println("FAIL: NPE was encountered: " + npe.getMessage());
        } catch (IllegalArgumentException iae) {
            System.out.println("FAIL: IAE was encountered: " + iae.getMessage());
        } // try
    } // testAdd

    /**
     * A static method that tests the add() method.
     * @param list a Stringlist
     */
    public static void testAddNegative(StringList list) {
        System.out.print("testAddNegative: ");
        try {
            list.add(-5, "world");
            System.out.println("FAIL: expected IOOB; however, no exception was encountered");
        } catch (IndexOutOfBoundsException ioob) {
            System.out.println("PASS: expected IOOB; IOOB was encountered ");
        } catch (NullPointerException npe) {
            System.out.println("FAIL: NPE was encountered: " + npe.getMessage());
        } catch (IllegalArgumentException iae) {
            System.out.println("FAIL: IAE was encountered: " + iae.getMessage());
        } // try
    } // testAddNegative

    /**
     * A static method that tests the remove() method.
     * @param list a Stringlist
     */
    public static void testRemove(StringList list) {
        System.out.print("testRemove: ");
        try {
            list.remove(0);
            System.out.println("PASS: no exception was encountered");
        } catch (IndexOutOfBoundsException ioob) {
            System.out.println("FAIL: IOOB was encountered");
        } catch (Throwable e) {
            System.out.println("FAIL: Should not throw exception " + e);
        } // try
    } // testRemove

    /**
     * A static method that tests the remove() method.
     * @param list a Stringlist
     */
    public static void testRemoveNegative(StringList list) {
        System.out.print("testRemoveNegative: ");
        try {
            list.remove(-5);
            System.out.println("FAIL: expected IOOB; however, no exception was encountered");
        } catch (IndexOutOfBoundsException ioob) {
            System.out.println("PASS: expected IOOB; IOOB was encountered");
        } catch (Throwable e) {
            System.out.println("FAIL: expected IOOB, but got " + e);
        } // try
    } // testRemoveNegative

    /**
     * A static method that tests the get() method.
     * @param list a Stringlist
     */
    public static void testGet(StringList list) {
        System.out.print("testGet: ");
        try {
            list.get(0);
            System.out.println("PASS: no exception was encountered");
        } catch (IndexOutOfBoundsException ioob) {
            System.out.println("FAIL: IOOB was encountered");
        } catch (Throwable e) {
            System.out.println("FAIL: Should not throw exception " + e);
        } // try
    } // testGet

    /**
     * A static method that tests the get() method.
     * @param list a Stringlist
     */
    public static void testGetNegative(StringList list) {
        System.out.print("testGetNegative: ");
        try {
            list.get(-5);
            System.out.println("FAIL: expected IOOB; however, no exception was encountered");
        } catch (IndexOutOfBoundsException ioob) {
            System.out.println("PASS: expected IOOB; IOOB was encountered");
        } catch (Throwable e) {
            System.out.println("FAIL: expected IOOB, but got " + e);
        } // try
    } // testGetNegative

    /**
     * A static method that tests the get() method.
     * @param list a Stringlist
     */
    public static void testClear(StringList list) {
        System.out.print("testClear: ");
        list.clear();
        if (list.size() == 0) {
            System.out.println("PASS: no exception expected");
        } else {
            System.out.println("FAIL: the list is not cleared");
        } // if
    } // testClear

    /**
     * A static method that tests the append() method.
     * @param list a StringList
     */
    public static void testAppend(StringList list) {
        System.out.print("testAppend: ");
        try {
            list.append("end");
            //list.append("");
            //list.append(null);
            System.out.println("PASS: no exception expected");
        } catch (NullPointerException npe) {
            System.out.println("FAIL: no exception expected");
        } catch (IllegalArgumentException iae) {
            System.out.println("FAIL: no exception expected");
        } // try
    } // testAppend

    /**
     * A static method that tests the prepend() method.
     * @param list a StringList
     */
    public static void testPrepend(StringList list) {
        System.out.print("testPrepend: ");
        try {
            list.prepend("start");
            //list.prepend("");
            //list.prepend(null);
            System.out.println("PASS: no exception expected");
        } catch (NullPointerException npe) {
            System.out.println("FAIL: no exception expected");
        } catch (IllegalArgumentException iae) {
            System.out.println("FAIL: no exception expected");
        } // try
    } // testPrepend

    /**
     * A static method that tests the slice() method.
     * @param list a StringList
     */
    public static void testSlice(StringList list) {
        System.out.print("testPrepend: ");
        try {
            list.slice(1,5);
            System.out.println("PASS: no exception expected");
        } catch (IndexOutOfBoundsException ioob) {
            System.out.println("FAIL: IOOB encountered: " + ioob.getMessage());
        } // try
    } // testSlice

}
