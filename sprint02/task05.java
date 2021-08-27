import java.util.ArrayList;
import java.util.List;

abstract class Figure{
    private double width;
    
	public Figure(double width) {
		this.width = width;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public abstract double getPerimeter();
}

class Rectang extends Figure {
	private double height;
	
    public Rectang(double width, double height) {
		super(width);
		this.height = height;
	}

	public double getPerimeter(){
        return 2 *(super.getWidth() + height);
    }
}
class Square extends Figure {
	public Square(double width) {
		super(width);
	}

    public double getPerimeter(){
        return 4 * super.getWidth();
    }
}
public class MyUtils {
    public double sumPerimeter(List<Figure> firures) {
        double sum = 0;
        if (firures.isEmpty()) {
        	return sum;
        }
        for(Figure f: firures) {
        	if(f == null) {
        		continue;
        	}
        	sum += f.getPerimeter();
        }
        return sum;
    }
}
