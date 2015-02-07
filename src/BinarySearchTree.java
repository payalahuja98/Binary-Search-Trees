public class BinarySearchTree<T extends Comparable <T>> implements BSTInterface<T>{
	
	protected BSTNode root;
	boolean found;
	
	protected LinkedUnboundedQueue<T> inOrderQueue;
	protected LinkedUnboundedQueue<T> preOrderQueue;
	protected LinkedUnboundedQueue<T> postOrderQueue;
	
	public BinarySearchTree(){
		root = null;
	}
	public boolean isEmpty(){
		return (root == null);
	}
	public int size(){
		return recSize(root);
	}
	private int recSize(BSTNode<T> node){
		if(node == null){
			return 0;
		}
		int size = recSize(node.getLeft()) + recSize(node.getRight()) + 1;
		return size;
	}
	private boolean recContains(T element, BSTNode<T> node){
		if(node.getInfo().equals(element)){
			return true;
		}
		recContains(element,node.getLeft());
		recContains(element,node.getRight());
		if(node == null){
			return false;
		} 
	}
	public boolean contains(T element){
		return recContains(element, root);
	}
	private T recGet(T element, BSTNode<T> node){
		if(node.getInfo().equals(element)){
			return node.getInfo();
		}
		recContains(element,node.getLeft());
		recContains(element,node.getRight());
		return null;
	}
	public T get(T element){
		return recGet(element, root);
	}
	public void add(T element){
		root = recAdd(element, root);
	}
	public BSTNode<T> recAdd(T element, BSTNode<T> node){
		if(node == null){
			node = new BSTNode<T>(element);
		}
		if(node.getInfo().compareTo(element) <= 0){
			recAdd(element,node.getLeft());
		}
		else{
			if(node.getInfo().compareTo(element) > 0){
				recAdd(element, node.getRight());
			}
		}
		return node;
	}
	public boolean remove(T element){
		root = recRemove(element, root);
		return found;
	}
	public BSTNode<T> recRemove(T element, BSTNode<T> node){
		BSTNode<T> temp = new BSTNode<T>(null);
		if(node.getLeft() == null && node.getRight() == null){ 
			temp = node;
			node = null;
		}
		else{
		//not done
		}
		return temp;
	}
	public BSTNode<T> removeNode(BSTNode<T> tree){
		T data;
		
		if(tree.getLeft() == null){
			return tree.getRight();
		}
		else{
			if(tree.getRight() == null){
				return tree.getLeft();
			}
			else{
				data = getPredecessor(tree.getLeft());
				tree.setInfo(data);
				tree.setLeft(recRemove(data, tree.getLeft()));
				return tree;
			}
		}
	}
	private T getPredecessor(BSTNode<T> tree){
		while(tree.getRight() != null){
			tree = tree.getRight();
		} 
		return tree.getInfo();
	}
	public int reset(int orderType){
		int numNodes = size();
		if(orderType == INORDER){
			inOrderQueue = new LinkedUnboundedQueue<T>();
			inOrder(root);
		}
		else{
			if(orderType == PREORDER){
				preOrderQueue = new LinkedUnboundedQueue<T>();
				preOrder(root);
			}
			else{
				if(orderType == POSTORDER){
					postOrderQueue = new LinkedUnboundedQueue<T>();
					postOrder(root);
				}
			}
		}
		return numNodes;
	}
	public T getNext(int orderType) throws QueueUnderflowException{
		if(orderType == INORDER){
			return inOrderQueue.dequeue();
		}
		else{
			if(orderType == PREORDER){
				return preOrderQueue.dequeue();
			}
			else{
				if(orderType == POSTORDER){
					return postOrderQueue.dequeue();
				}
				else{
					return null;
				}
			}
		}
	}
	private void inOrder(BSTNode<T> tree){
		if(tree != null){
			inOrder(tree.getLeft());
			inOrderQueue.enqueue(tree.getInfo());
			inOrder(tree.getRight());
		}
	}
	private void preOrder(BSTNode<T> tree){
		if(tree != null){
			preOrderQueue.enqueue(tree.getInfo());
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}
	private void postOrder(BSTNode<T> tree){
		if(tree != null){
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
			preOrderQueue.enqueue(tree.getInfo());
		}
	}
	
}
