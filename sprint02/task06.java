import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

abstract class Shape {
    private String name;

	public Shape(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public abstract double getArea();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (Shape) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}


class Circle extends Shape {
	private double radius;
	
    public Circle(String name, double radius) {
		super(name);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		if (this.getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!this.getName().equals(other.getName()))
			return false;
		return true;
	}
}


class Rectangle extends Shape {
	private double height;
	private double width;
	
	public Rectangle(String name, double height, double width) {
		super(name);
		this.height = height;
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		if (this.getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!this.getName().equals(other.getName()))
			return false;
		return true;
	}
	
	
}
public class MyUtils {
    public List<Shape> maxAreas(List<Shape> shapes) {
        if (shapes.isEmpty()) {
        	return shapes;
        }
        Set<Shape> set = new HashSet<Shape>();
        List<Shape> new_shapes = new ArrayList<Shape>();
        List<Circle> circles = new ArrayList<Circle>();
    	List<Rectangle> rectangls = new ArrayList<Rectangle>();
        for (Shape shape : shapes) {
        	set.add(shape);
        }
        if(set.size() == 1) {
    		new_shapes.add(set.iterator().next());
    		return new_shapes;
    	}
        for (Shape shape : set) {
        	if (shape instanceof Circle) {
    			circles.add((Circle)shape);
    		}
    		else if (shape instanceof Rectangle) {
    			rectangls.add((Rectangle)shape);
    		}
    		else {
    			continue;
    		}
        }
        if(circles.isEmpty() && rectangls.isEmpty()) {
    		return new_shapes;
    	}
        Collections.sort(circles, new Comparator<Circle>() {
        	public int compare(Circle o1, Circle o2) {
        		return Double.compare(o2.getArea(), o1.getArea());
            }
        });
        Collections.sort(rectangls, new Comparator<Rectangle>() {
        	public int compare(Rectangle o1, Rectangle o2) {
        		return Double.compare(o2.getArea(), o1.getArea());
            }
        });
        int size = 0;
    	if (circles.size() == 1) {
    		new_shapes.add(circles.get(0));
    	}
    	else {
    		new_shapes.add((Shape) circles.get(size));
        	while((size+1) < circles.size()) {
        		if(circles.get(size).getArea() == circles.get(size +1).getArea()) {
        			size +=1;
        			new_shapes.add((Shape) circles.get(size));
        		}
        		else {
        			break;
        		}
        	}
    	}
    	size = 0;
    	if (rectangls.size() == 1) {
    		new_shapes.add(rectangls.get(0));
    	}
    	else {
    		new_shapes.add((Shape) rectangls.get(size));
        	while((size+1) < rectangls.size()) {
        		if(rectangls.get(size).getArea() == rectangls.get(size +1).getArea()) {
        			size +=1;
        			new_shapes.add((Shape) rectangls.get(size));
        		}
        		else {
        			break;
        		}
        	}
    	}
        return new_shapes;
    }
}
