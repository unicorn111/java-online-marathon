class ArrayUtil {
	 public static <T> T setAndReturn(T[] array, T obj, int position){
	        array[position] = obj;
	        return array[position];
	    }
}
