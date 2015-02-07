public interface BSTInterface<T extends Comparable<T>> {
	static final int INORDER = 1;
	static final int PREORDER = 2;
	static final int POSTORDER = 3;
	
	boolean isEmpty();
	
	int size();
	
	boolean contains(T element);
	
	boolean remove(T element);
	
	T get(T element);
	
	void add(T element);
	
	int reset(int orderType);
	
	T getNext(int orderType) throws QueueUnderflowException;
}
