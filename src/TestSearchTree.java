import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/////////////////////////////////////////////////////////////////////////////
// Semester:         CS400 Spring 2018
// PROJECT:          cs400_p2_201801
// FILES:            TestSearchTree.java
//                   SearchTreeADT.java
//                   BalancedSearchTree.java
//
// USER:             Awestlund
//
// Instructor:       Deb Deppeler (deppeler@cs.wisc.edu)
// Bugs:             no known bugs
//
// 2018 Feb 8, 2018 5:13:18 PM TestSearchTree.java 
//////////////////////////// 80 columns wide //////////////////////////////////
/**
 * @author amberwestlund
 *
 */
public class TestSearchTree {

	SearchTreeADT<String> tree = null;
	// can make more trees of different types
	String expected = null;
	String actual = null;
	Random r = new Random();
	int size1 = 100;
	int size2 = 200;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// set up huge data structure
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Constructor that runs before every test
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tree = new BalancedSearchTree<String>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Tests if isEmpty is true in an empty tree, fails if it is false for the newly
	 * constructed search tree
	 */
	@Test
	public void test01_isEmpty_on_empty_tree() {
		expected = "true";
		actual = "" + tree.isEmpty();
		if (!expected.equals(actual))
			fail("expected: " + expected + " actual: " + actual);
	}

	@Test
	public void test02_ascending_order_on_empty_tree() {
		expected = "";
		actual = tree.inAscendingOrder();
		if (!expected.equals(actual))
			fail("expected: " + expected + " actual: " + actual);
	}

	@Test
	/** tests that the height of an empty tree is 0 */
	public void test03_height_on_empty_tree() {
		expected = "0";
		actual = "" + tree.height();
		if (!expected.equals(actual))
			fail("expected: " + expected + " actual: " + actual);
	}

	@Test
	public void test04_isEmpty_after_one_insert() {
		tree.insert("1");
		expected = "false";
		actual = "" + tree.isEmpty();
		if (!expected.equals(actual))
			fail("expected: " + expected + " actual: " + actual);
	}

	@Test
	/** tests that the ascending order after inserting A item is "A," */
	public void test05_ascending_order_after_one_insert() {
		tree.insert("A");
		expected = "A,";
		actual = tree.inAscendingOrder();
		if (!expected.equals(actual))
			fail("expected: " + expected + " actual: " + actual);
	}

	@Test
	/** tests that the height after inserting A is 1 */
	public void test06_height_after_one_insert() {
		tree.insert("A");
		expected = "1";
		actual = "" + tree.height();
		if (!expected.equals(actual))
			fail("expected: " + expected + " actual: " + actual);
	}

	@Test
	/** tests that the height after inserting A and B and deleting A is 1 */
	public void test07_height_after_two_insert_and_delete() {
		tree.insert("A");
		tree.insert("B");
		tree.delete("A");
		expected = "1";
		actual = "" + tree.height();
		if (!expected.equals(actual))
			fail("expected: " + expected + " actual: " + actual);
	}
	/**
	 * Tests height after 100 random nodes have been added
	 */
	@Test
	public void test08_height_of_100_nodes() {
		// System.out.println("test08_Height_of_100_Nodes\n");
		// generate array of 100
		int[] array = new int[size1];
		int i = 0;
		for (i = 0; i < array.length; i++) {
			array[i] = r.nextInt();
			tree.insert(Integer.toString(array[i]));
		}
		// insert array as nodes to the tree
		// test height
		expected = ""+size1;
		actual = "" + tree.height();
		if (!expected.equals(actual))
			fail("expected: " + expected + " actual: " + actual);
	}

	/**
	 * Insert and delete (smallest node) 100 random nodes and check if the rebalance
	 * is correct after each delete
	 */
	@Test
	public void test09_rebalance_after_delete_smallest_nodes() {
		// System.out.println("test09_rebalance_after_delete_smallest_nodes\n");
		int[] array = new int[size1];
		int i = 0;
		for (i = 0; i < array.length; i++) {
			array[i] = r.nextInt();
			tree.insert(Integer.toString(array[i]));
		}
		int[] sorted = array.clone();
		Arrays.sort(sorted);
		for (int j = 0; j < sorted.length; j++) {
			// always deleting the smallest node?
			tree.delete("" + sorted[j]);
			// expected is a string of all the elements of the sorted array separated by
			// commas
			expected = null;
			for (int k = j + 1; k < sorted.length - j; k++) {
				// skip elements that have already been deleted -> k+1
				expected += "" + sorted[k] + ",";
			}
			actual = tree.inAscendingOrder();
			if (!expected.equals(actual))
				fail("expected: " + expected + " actual: " + actual);
		}
	}

	/**
	 * Insert and test 100 random ints to see if they were added in ascending order
	 */
	@Test
	public void test10_ascending_order_after_100_inserted() {
		// System.out.println("ascending_order_after_100_inserted\n");
		// generate array of 100
		int[] array = new int[size1];
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt();
			tree.insert(Integer.toString(array[i]));
		}
		int[] sorted = array.clone();
		Arrays.sort(sorted);
		// test Ascending order for each node

		for (int j = 0; j < sorted.length; j++) {
			expected = null;
			for (int k = 0; k < array.length; k++) {
				expected += "" + sorted[k] + ",";
			}
			actual = tree.inAscendingOrder();
			if (!expected.equals(actual)) {
				fail("expected: " + expected + " actual: " + actual);
			}
		}

	}

	/**
	 * Insert and delete (largest node) 100 random nodes and check if the rebalance
	 * is correct after each delete
	 */
	@Test
	public void test11_rebalance_after_delete_largest_nodes() {
		// System.out.println("test11_rebalance_after_delete_largest_nodes\n");
		int[] array = new int[size1];
		int i = 0;
		for (i = 0; i < array.length; i++) {
			array[i] = r.nextInt();
			tree.insert(Integer.toString(array[i]));
		}
		int[] sorted = array.clone();
		Arrays.sort(sorted);
		int count = 0;
		for (int j = sorted.length - 1; j >= 0; j++) {
			// always deleting the smallest node?
			tree.delete("" + sorted[j]);
			count += 1;
			// expected is a string of all the elements of the sorted array separated by
			// commas
			expected = null;
			for (int k = 0; k < sorted.length - count; k++) {
				// skip elements that have already been deleted -> k+1
				expected += "" + sorted[k] + ",";
			}
			actual = tree.inAscendingOrder();
			if (!expected.equals(actual))
				fail("expected: " + expected + " actual: " + actual);
		}
	}

	/**
	 * Test to see if lookup can find a node in the tree of 200 nodes, fails if it
	 * cannot find the node
	 */
	@Test
	public void test12_lookup_value_in_tree_of_200_nodes() {
		// System.out.println("test12_lookup_value_in_tree_of_200_nodes\n");
		int[] array = new int[size2];
		int i = 0;
		for (i = 0; i < array.length; i++) {
			array[i] = r.nextInt(); // generate random number
			tree.insert(Integer.toString(array[i]));
		}
		expected = "true";
		// randomly choose one of the 200 values we have entered into the tree
		String testNode = "" + array[r.nextInt(size2)];
		actual = "" + tree.lookup(testNode);
		if (!expected.equals(actual))
			fail("expected: " + expected + " actual: " + actual);
	}

	/**
	 * Insert and delete 100 nodes and check isEmpty
	 */
	@Test
	public void test13_insert_and_delete_100_nodes_test_isEmpty() {
		// System.out.println("test13_insert_and_delete_100_nodes_test_isEmpty");
		int[] array = new int[size1];
		int i = 0;
		for (i = 0; i < array.length; i++) {
			array[i] = r.nextInt();
			tree.insert(Integer.toString(array[i]));
		}
		for (int j = 0; j > array.length; j++) {
			// always deleting the smallest node?
			tree.delete("" + array[j]);
		}
		// expected is a string of all the elements of the sorted array separated by
		// commas
		expected = "true";
		actual = "" + tree.isEmpty();
		if (!expected.equals(actual))
			fail("expected: " + expected + " actual: " + actual);

	}

	/**
	 * Insert 100 nodes and lookup a node not in tree, delete should fail to not
	 * fail this test
	 */
	@Test
	public void test14_lookup_node_not_in_tree() {
		// System.out.println("test14_delete_node_not_in_tree");
		int[] array = new int[size1];
		int i = 0;
		for (i = 0; i < array.length; i++) {
			array[i] = r.nextInt();
			tree.insert(Integer.toString(array[i]));
		}
		expected = "false";
		actual = "" + tree.lookup("red"); // looking up chars when we have only entered ints
		if (!expected.equals(actual))
			fail("expected: " + expected + " actual: " + actual);
	}
	
	/**
	 * Makes sure insert throws an exception when inserting a null value
	 */
	@Test
	public void test15_null_throws_IllegalArgumentException() {
		try {
		tree.insert(null);
		//should not get to the next line, needs to fail the line above
		fail("Did not throw IllegalArgumentException()");
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	// You must test how your tree handles small, medium, and large number of key
	// items, with exception handling if necessary.
	// unit test fail messages must show test expected and actual (see examples in
	// provide test file)
	// test for correct operation on on empty tree
	// tree with one item
	// trees with a few to several items added and deleted
	// trees with many items added and deleted
	// trees with items added, deleted, and new one added

}