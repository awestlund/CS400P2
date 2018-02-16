import java.util.ArrayList;

// starter class for a BalancedSearchTree
// you may implement AVL, Red-Black, 2-3 Tree, or 2-3-4 Tree
// be sure to include in class header which tree you have implemented
public class BalancedSearchTree<T extends Comparable<T>> implements SearchTreeADT<T> {

	// inner node class used to store key items and links to other nodes
	protected class Treenode<K extends Comparable<K>> {
		public Treenode(K item) {
			this(item, null, null);
		}

		public Treenode(K item, Treenode<K> left, Treenode<K> right) {
			key = item;
			this.left = left;
			this.right = right;
		}

		K key;
		Treenode<K> left;
		Treenode<K> right;

		// prereq root cannot be null
		/**
		 * @return the number of nodes in the tree (VLR)
		 */
		protected int countHelper() {
			// if the parent has two children
			if (left != null && right != null) {
				return (1 + left.countHelper() + right.countHelper());
			}
			// else if the parent has only one child
			else if (left != null) {

				return (1 + left.countHelper());
			} else if (right != null) {

				return (1 + right.countHelper());
			}
			// if a parent has no children
			return 1;
		}

		/**
		 * Adds node's keys into an array
		 * 
		 * @return LVR array list of all the nodes in the tree
		 */
		protected ArrayList<K> inAscendingOrderHelper() {
			// LVR implementation
			ArrayList<K> newList = new ArrayList<K>();
			// add all in left side
			if (left != null) {
				newList.addAll(left.inAscendingOrderHelper());
				// do i have to do anything different to make sure that this adds the key not
				// the node??
			}
			// add middle
			newList.add(key);
			// add all in the right side
			if (right != null) {
				newList.addAll(right.inAscendingOrderHelper());
				// do i have to do anything different to make sure that this adds the key not
				// the node??
			}

			return newList;

		}

		/**
		 * @param item
		 *            the value we want to find in the search tree
		 * @return true if item was found and false if no item of the same value was
		 *         found
		 */
		protected boolean searchHelper(K item) {
			if (item.compareTo(this.key) == 0) {
				return true;
			}
			// item is greater then key ==> right child node
			else if (item.compareTo(this.key) > 0) {
				if (this.right != null) {
					return (this.right).searchHelper(item);
				} else {
					return false;
				}
				// item is less then key ==> left child node
			} else {
				if (this.left != null) {
					return (this.left).searchHelper(item);
				} else {
					return false;
				}
			}

		}

		private void insertHelper(Treenode newNode) {
			// TODO Auto-generated method stub
			
		}
	}

	protected Treenode<T> root;

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchTreeADT#inAscendingOrder()
	 */
	public String inAscendingOrder() {
		if (root != null) {
			int size = root.countHelper();
			ArrayList<T> inOrderArray = new ArrayList<T>(size);
			inOrderArray = root.inAscendingOrderHelper();
			return "" + inOrderArray;
			// TODO : must return comma separated list of keys in ascending order

		} else {
			return "";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchTreeADT#isEmpty()
	 */
	public boolean isEmpty() {
		// TODO return empty if there are no keys in structure
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchTreeADT#height()
	 */
	public int height() {
		// TODO return the height of this tree
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchTreeADT#lookup(java.lang.Comparable)
	 */
	public boolean lookup(T item) {
		// TODO must return true if item is in tree, otherwise false
		if (root.equals(null)) {
			return false;
		} else {
			return root.searchHelper(item);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchTreeADT#insert(java.lang.Comparable)
	 */
	public void insert(T item) throws IllegalArgumentException {
		if (item == null) {
			throw new IllegalArgumentException();
		}
		Treenode newNode = new Treenode(item);
		root.insertHelper(newNode);
		// TODO if item is null throw IllegalArgumentException,
		// otherwise insert into balanced search tree
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchTreeADT#delete(java.lang.Comparable)
	 */
	public void delete(T item) {
		// TODO if item is null or not found in tree, return without error
		// else remove this item key from the tree and rebalance

		// NOTE: if you are unable to get delete implemented
		// it will be at most 5% of the score for this program assignment
	}

	// HINT: define this helper method that can find the smallest key
	// in a sub-tree with "node" as its root
	// PRE-CONDITION: node is not null
	/**
	 * @param node
	 * @return
	 */
	private T leftMost(Treenode<T> node) {
		// TODO return the key value of the left most node in this subtree
		// or return node's key if node does not have a left child
		// recurse until left child of left node is null then return the nodes key
		return node.key;
	}

}