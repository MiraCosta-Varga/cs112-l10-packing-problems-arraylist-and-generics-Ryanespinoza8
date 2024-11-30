import java.util.List; 
public class Inventory<T extends Supplies> {


	/*     STEP 3 
	*        
	*      Create this bounded type generic class with everything you 
	*      would expect in a class (instance variable, constructor,
	*      get/set methods) and then make two additional generic methods:
	*
	*      Go to Transfer.java for STEP 4
	*/
	//Instance variables
	private T t;

	public Inventory() {
        // Constructor logic (if needed)
        this.t = null; // Just an example; initialize as needed
    }

    // Constructor that accepts a parameter of type T
	public Inventory(T t) {
		this.t = t; // Assigning the parameter t to the field t
	}
	 // Setter method for the field t
	 public void setObj(T t) {
        this.t = t;  // Set the value of t
    }

    // Getter method for the field t
    public T getObj() {
        return t;  // Return the value of t
    }

	/*     STEP 5
	*
	*      Create a method called searchByName() that takes two parameters:
	*          - The input List<T> of generic type T
	*          - A String "name" that we will use to search in the input List
	*
	*      This method should iterate through all the objects in our List
	*      and use the getName() method of Supplies to compare against the
	*      input String "name", use the indexOf() method to return the 
	*      index. If no match is found, return -1. 
	*/
	public int searchByName(List<T> inputList, String name) {
		// Trim the input name to remove leading and trailing spaces
		name = name.trim();
	
		// Loop through the list to find the matching element
		for (T element : inputList) {
			
			// Check if the element has the name that matches (case insensitive)
			if (element.getName().equalsIgnoreCase(name)) {
				return inputList.indexOf(element);
			}
			System.out.println("could not find that item.");
			return -1;
		}
		
		// Return -1 if no match is found
		return -1;
	}
	

	/*     STEP 7:
	* 
	*      Create a method called checkQty() that takes three parameters:
	*           - The input List<T>
	*           - The String name of the object we want to check
	*           - The int desiredQuantity that we want to check/change for 
	*             the item
	*           
	*      Use our method searchByName() to be able to get the index of 
	*      the object we are looking for and use the index to access the 
	*      object within the List<T>. If the object is not found, or if
	*      our searchByName() method returns -1, return null.
	*
	*      Once our object is found, check the quantity via the .get() 
	*      method from the List class and by using the .getQuantity()
	*      from the Supplies class. Compare the value with the parameter 
	*      desiredQuantity, if they match then return the object as-is
	*      and notify user that the quantity matches. If it does not 
	*      match the quantity in the list, then update using .setQuantity
	*      and return the object with the new quantity.
	*/

	public T checkQty(List<T> inputList, String name, int desiredQuantity) 
	{
        int indexOfItem = searchByName(inputList, name);
        
        // Handle case where item is not found
        if (indexOfItem == -1) {
            return null;
        }
        
        // Check and update the quantity if necessary
		if (inputList.get(indexOfItem).getQuantity() != desiredQuantity) {
			// Set the new quantity if it doesn't match

			inputList.get(indexOfItem).setQuantity(desiredQuantity);
			return inputList.get(indexOfItem);
		}
		else {
			return inputList.get(indexOfItem);
		}

    }
}