class ArrayUtil {
    public static <T extends Number> double averageValue(Array<T> arr){
        double sum = 0;
        for(int i=0; i<arr.length(); i++){
            sum+=(double)((Integer) arr.get(i).intValue());
        }
        return sum / arr.length();
    }
}
