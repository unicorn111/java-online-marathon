class NameList {
    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }

    public class Iterator{
        private int counter = -1;
        
        private Iterator(){}
        
        public boolean hasNext(){
            if((counter + 1) == names.length) {
            	return false;
            }
            return true;
        }
        public String next(){
        	counter +=1;
            return names[counter];
        }
    }
}
