class Point{
    private int x;
    private int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int[] getXYPair(){
    	int[] pair = {x, y};
        return pair;
    }
    
    public double distance(int x, int y){
        double res = Math.sqrt((Math.pow((x - this.x), 2) +
        Math.pow((y - this.y), 2)));
        return res;
    }
    
    public double distance(Point p){
    	return distance(p.x, p.y);
    }
    
    public double distance(){
    	return distance(0, 0);
    }
}
