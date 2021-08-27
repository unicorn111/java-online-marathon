enum Color{WHITE, RED, BLUE}

enum Type{RARE, ORDINARY}

class Plant {
    private String name;
    private Color color;
    private Type type;
    private boolean check = false;
    
	public Plant(String type, String color, String name) throws ColorException, TypeException {
		for (Type t:Type.values()) {
	    	if(t.toString().equals(type.toUpperCase())) {
	    		check = true;
	    	}
	    }
	    if(check) {
	    	this.type = Type.valueOf(type.toUpperCase());
	    }
	    else {
	    	throw new TypeException("Invalid value " + type + " for field type");
	    }
	    check = false;
	    for (Color c:Color.values()) {
	    	if(c.toString().equals(color.toUpperCase())) {
	    		check = true;
	    	}
	    }
	    if(check) {
	    	this.color = Color.valueOf(color.toUpperCase());
	    }
	    else {
	    	throw new ColorException("Invalid value " + color + " for field color");
	    }
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "{type: " + type + ", color: " + color + ", name: " + name + "}";
	}
}
class  ColorException extends Exception{
	private String msg;

	public ColorException(String msg) {
		super(msg);
	}
	
}

class  TypeException extends Exception{
	private String msg;
	
	public TypeException(String msg) {
		super(msg);
	}
}
