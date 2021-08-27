import java.util.ArrayList;
import java.util.List;

class Person {
	private String firstName;
	private String lastName;
	private String idCode;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) throws NameException{
		if(firstName == null) {
			throw new NameException("Incorrect value " + firstName + 
    				" for firstName (should start from upper case and contains only "
    				+ "alphabetic characters and symbols -, _)"); 
		}
		char[] chars = firstName.toCharArray();
		if(!Character.isLetter(chars[0])) {
			throw new NameException("Incorrect value " + firstName + 
    				" for firstName (should start from upper case and contains only "
    				+ "alphabetic characters and symbols -, _)"); 
		}
		if(!Character.toString(chars[0]).equals(Character.toString(chars[0]).toUpperCase())) {
			throw new NameException("Incorrect value " + firstName + 
    				" for firstName (should start from upper case and contains only "
    				+ "alphabetic characters and symbols -, _)"); 
    	}
		for (char c : chars) {
	        if(!Character.isLetter(c)) {
	            if(!Character.toString(c).equals("-")) {
	            	if(!Character.toString(c).equals(" ")) {
	            		throw new NameException("Incorrect value " + firstName + 
	            				" for firstName (should start from upper case and contains only alphabetic characters and symbols -, _)"); 
	            	}
	            }
	        }
	    }
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) throws NameException {
		if(lastName == null) {
			throw new NameException("Incorrect value " + lastName + 
    				" for lastName (should start from upper case and contains only "
    				+ "alphabetic characters and symbols -, _)");
		}
		char[] chars = lastName.toCharArray();
		if(!Character.isLetter(chars[0])) {
			throw new NameException("Incorrect value " + lastName + 
    				" for lastName (should start from upper case and contains only "
    				+ "alphabetic characters and symbols -, _)"); 
		}
		if(!Character.toString(chars[0]).equals(Character.toString(chars[0]).toUpperCase())) {
			throw new NameException("Incorrect value " + lastName + 
    				" for lastName (should start from upper case and contains only "
    				+ "alphabetic characters and symbols -, _)"); 
    	}
		for (char c : chars) {
	        if(!Character.isLetter(c)) {
	            if(!Character.toString(c).equals("-")) {
	            	if(!Character.toString(c).equals(" ")) {
	            		throw new NameException("Incorrect value " + lastName + 
	            				" for lastName (should start from upper case and contains only alphabetic characters and symbols -, _)"); 
	            	}
	            }
	        }
	    }
		this.lastName = lastName;
	}
	
	public String getIdCode() {
		return idCode;
	}
	
	public void setIdCode(String idCode) throws CodeException {
		if(idCode == null) {
			throw new CodeException("Incorrect value " + idCode+ " for code (should contains exactly 10 digits)");
		}
		if(idCode.length() != 10) {
			throw new CodeException("Incorrect value " + idCode+ " for code (should contains exactly 10 digits)");
		}
		char[] chars = idCode.toCharArray();
		for (char c : chars) {
	        if(!Character.isDigit(c)) {
	        	throw new CodeException("Incorrect value " + idCode+ " for code (should contains exactly 10 digits)");
	        }
	    }
		this.idCode = idCode;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName + ": " + idCode;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((idCode == null) ? 0 : idCode.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (idCode == null) {
			if (other.idCode != null)
				return false;
		} else if (!idCode.equals(other.idCode))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	public static Person buildPerson(String firstName, String lastName, String idCode) throws IllegalArgumentException {
		List<String> exception = new ArrayList<String>();
		Person p = new Person();
		try {
			p.setFirstName(firstName);
		}catch(NameException e) {
			exception.add(e.msg);
		}
		try {
			p.setLastName(lastName);
		}catch(NameException e) {
			exception.add(e.msg);
		}
		try {
			p.setIdCode(idCode);
		}catch(CodeException e) {
			exception.add(e.msg);
		}
		String StringEx = String.join("; ", exception);
		if(StringEx.length() != 0) {
			throw new IllegalArgumentException(StringEx);
		}
		return p;
	}
	
}

class NameException extends RuntimeException{
	String msg;

	public NameException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
}

class CodeException extends RuntimeException{
	String msg;

	public CodeException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
}
