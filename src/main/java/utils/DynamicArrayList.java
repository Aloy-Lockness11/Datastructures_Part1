package utils;

/**
 *
 * @author michelle
 */

//Aloysius Wilfred Pacheco D00253302
public class DynamicArrayList {
    //max Capacity of String array
    private static final int DEFAULT_CAP = 10;
    private int size;
    private String[] arr;

    /**
     * Default constructor to init Dynamic array class object
     */
    public DynamicArrayList() {
        this.arr = new String[DEFAULT_CAP];
        this.size = 0;
    }
//1)  Your dynamic array list should include a constructor that lets the user supply an initial array of values to be added.
//    The constructor should take in one parameter, a String array, and its contents should be added to the list after you
//    initialise the array. The supplied array should be validated, and invalid values handled accordingly.
    /**
     * Constructor that takes an initialised array of values to be added to main array arr
     *
     * @param data the array of Strings to be added to the list
     * @throws IllegalArgumentException if the supplied array is null or contains invalid values
     */
public DynamicArrayList(String[] data) {
    if (data == null) {
        throw new IllegalArgumentException("Invalid values or null array (✖╭╮✖)");
    }

    this.arr = new String[data.length];
    System.arraycopy(data, 0, this.arr, 0, data.length);
    this.size = data.length;
}

    /**
     * Gets Stored array
     *
     * @return The array stored in object class
     */
    //Getter

    public String[] getArr() {
        return arr;
    }

    /**
     * Returns the number of elements currently stored in the list.
     *
     * @return The size of the list
     */
    public int size() {
        return this.size;
    }

    /**
     * Gets the data of the position in the list
     *
     * @param pos Position from which data should be retrieved
     * @return Data  at the position
     * @throws IndexOutOfBoundsException if the position is invalid
     */
    public String get(int pos) {
        if (pos < 0 || pos >= this.size) {
            //throws out of bounds error  in case position doesn't exist in array
            throw new IndexOutOfBoundsException("invalid pos ฅ(=༝ᆽ༝=)∫");
        }
        return this.arr[pos];
    }
    /**
     * Adds a String to the end of the list
     * Grows the internal array if space unavailable
     *
     * @param word String to be added
     * @return true if the String was added else false
     */
    public boolean add(String word) {
        //if size is the same as arr length then make space for new arr
        if (size == this.arr.length) {
            growArr();
        }
        //this.size+=1;
        this.arr[this.size++] = word;

        return true;
    }
//    2)Your list should contain a method called addAll() that takes one parameter:
//
//    An array of Strings to be added.
//    All values from this array should be added to the list (nulls included). The method should return nothing.

    /**
     * Adds all Strings from the given String array to the list
     *
     * @param data The array of Strings to be added to the list
     */

    public void addAll(String[] data){
        //if all data does not fit in the array, it is grown with the length of the existing array
        if (this.size+data.length >= this.arr.length) {
            growArr(data.length);
        }
        //array is added from the back
        System.arraycopy(data, 0, this.arr, this.size, data.length);
        this.size += data.length;
    }

//3)    Your list should contain a method called remove() that takes two parameters:
//
//    The String to be removed (This should not be null).
//    An int indicating the position from which to start the removal process.
//    The first instance of this String found starting at the specified position should be removed from the list.
//    The method should return a boolean indicating if an instance of the String was removed.
//
    /**
     * Removes first instance of the given String starting from the given position
     *
     * @param word     The String to be removed
     * @param fromPos  The position from which to start the removal
     * @return true if an instance of the String was removed, false if no string provided or fromPos not exist
     * @throws IllegalArgumentException if null argument is given to word
     * @throws IndexOutOfBoundsException if from pos doesn't exist in array
     */
    public boolean remove(String word, int fromPos){
        //throws null
        if (word==null){
            throw new IllegalArgumentException("null pointer nya ฅ(=༝ᆽ༝=)∫");
        }

        //throws out of bounds
        if (fromPos < 0 || fromPos >= this.size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        // Iterates through arr to find best match starting  of the word starting from fromPos
        for (int i = fromPos; i < size; i++) {
            if (word.equals(arr[i])) {
                // shifts elements to fill the gap created by removal
                System.arraycopy(arr, i + 1, arr, i, size - i - 1);
                // set the last element to null
                arr[--size] = null;
                // String found and removed
                return true;
            }
        }
        // String not found
        return false;

    }

//    4)Your list should contain a method called clear() that takes no parameters and returns nothing. This method should
//    wipe the content of the array and reset it back to the initial size.

    /**
     *
     * wipes all data from list and sets to default size
     *
     */
    public void clear(){
        this.arr = new String[DEFAULT_CAP];
        this.size = 0;
    }

    /**
     *
     * Returns the index of a string if present in the array
     *
     * @param word takes in a String word to query
     * @return index if the word is found else returns -1 if no word is found
     */



   public int indexOf(String word){
        //loops through whole array and checks for word
       for (int i = 0; i < this.size; i++) {
           if(this.arr[i].equals(word)){
               return i;
           }
       }
       //returns -1 if word not found in arr
       return -1;
   }






    /**
     *
     * Grows the array to make room for additional data
     *
     */

   private void growArr(){
        //new array grown to twice length initialised
        String[] grownArr = new String[this.size*2];
        //Array added to new array
        System.arraycopy(this.arr,0,grownArr,0,this.size);
        //Array assigned to object array
        this.arr = grownArr;
   }

    /**
     * Grows the array to the new given capacity.
     *
     * @param increaseAmt The new capacity for the internal array.
     */
    private void growArr(int increaseAmt){
        //new array grown to given length initialised
        String[] grownArr = new String[this.size+increaseAmt];
        //Array added to new array
        System.arraycopy(this.arr,0,grownArr,0,this.size);
        //Array assigned to object array
        this.arr = grownArr;
    }
}
