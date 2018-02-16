import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class test {
	SearchTreeADT<String> tree = null; // should this be inside each individual method or like this?
	String expected = null;
	String actual = null;
	Random r = new Random();
	int size1 = 100;
	int size2 = 200;

	public static void main(String args[]) {
		System.out.println("tests.txt");
		System.out.println("================================================================");
		System.out.println("p2 Part A: Additional Tests to implement for p2");
		System.out.println("Name: Amber Westlund");
		System.out.println("");

	}

	/**
	 * Tests height after 100 random nodes have been added
	 */
	@Test
	public void test08_height_of_100_nodes() {

	}

	/**
	 * Insert and delete (smallest to largest nodes) 100 random nodes and check if
	 * the rebalance is correct after each delete
	 */
	@Test
	public void test09_rebalance_after_delete_smallest_nodes() {

	}

	/**
	 * Insert and test 100 random ints to see if they were inserted correctly by
	 * comparing to ascending order
	 */
	@Test
	public void test10_ascending_order_after_100_inserted() {

	}

	/**
	 * Insert and delete (largest node) 100 random nodes and check if the rebalance
	 * is correct after each delete
	 */
	@Test
	public void test11_rebalance_after_delete_largest_nodes() {

	}

	/**
	 * Test to see if lookup can find a node in the tree of 200 nodes, fails if it
	 * cannot find the node
	 */
	@Test
	public void test12_lookup_value_in_tree_of_200_nodes() {

	}

	/**
	 * Insert and delete 100 nodes and check isEmpty
	 */
	@Test
	public void test13_insert_and_delete_100_nodes_test_isEmpty() {

	}

	/**
	 * Insert 100 nodes and lookup a node not in tree, delete should fail to not
	 * fail this test
	 */
	@Test
	public void test14_lookup_node_not_in_tree() {

	}

	/**
	 * Makes sure insert() throws an exception when inserting a null value
	 */
	@Test
	public void test15_null_throws_IllegalArgumentException() {

	}
}
