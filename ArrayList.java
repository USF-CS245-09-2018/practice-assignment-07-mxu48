public class ArrayList implements List {


	int count = 0; /* Number of items in list */ 
	Object [] arr;

	public ArrayList () {
		int size = 10;
		arr = new Object[size];
	}

	public boolean listEmpty(int index) {
		if(count == 0) {
			return true;
		}
		return false;
	}

	public void add(Object obj) {
		/* Check if full, grow array */
		if(count == arr.length) {
			doubleArr();
		}
		/* Add obj to last position */
		arr[count] = obj;
		count++;
	}

	public void add(int pos, Object obj) {
		/* If index to be added outside of array indeces */
		if(pos < 0 || pos > count) {
			throw new RuntimeException("That position is out of the scope of the list.");
		}
		/* Check if full */
		if(count == arr.length) {
			doubleArr();
		}
		/* Shift to make room for new obj by moving all objects from pos to count move over one */
		for(int i = count; i > pos; i--) {
			arr[i] = arr[i-1];
		}
		
		/* Insert new object */
		arr[pos] = obj;
		count++; 

	}

	public Object get(int pos) {
		return arr[pos];
	}

	public Object remove(int pos) {
		if(pos < 0 || pos >= count) {
			throw new RuntimeException("That position is out of the scope of the list.");
		}
		Object remove = arr[pos]; /* Onject to be removed */
		/* Replace current with neighbor, shift rest of list down one to fill position of removed  */
		for(int i = pos; i < count-1;i++) {
			arr[i] = arr[i+1];
		}
		/* In case pos empty, out of list scope */
		if(pos == count-1) {
			arr[pos] = null;
		}

		--count;
		/* Item removed */
		return remove;
	}

	public int size() {
		return count; /* Number of objects in list */
	}

	public void doubleArr() {
		Object [] newArr = new Object [arr.length * 2];
		for(int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i]; /* Copy values */
		}

		arr = newArr;
	}
}