enum SortOrder{ASC, DESC}

@SuppressWarnings("unchecked")
class AddressBook implements Iterable {
	private NameAddressPair[] addressBook;
	private int counter = 0;
	public AddressBook(int capacity) {
		addressBook = new NameAddressPair[capacity];
	}
	public boolean create(String firstName, String lastName, String address) {
		NameAddressPair.Person p = new NameAddressPair.Person(firstName, lastName);
		NameAddressPair nameaddresspair = new NameAddressPair(p, address);
		if (addressBook.length == counter) {
			NameAddressPair[] copy = new NameAddressPair[addressBook.length * 2];
			System.arraycopy(addressBook, 0, copy, 0, addressBook.length);
			addressBook= copy;
		}
		if(counter > 0) {
			for (int i=0; i<counter; i++) {
				if(addressBook[i].person.equals(p)) {
					return false;
				}
			}
		}
		addressBook[counter] = nameaddresspair;
		counter ++;
		return true;
	}
	
	public String read(String firstName, String lastName) {
		NameAddressPair.Person p = new NameAddressPair.Person(firstName, lastName);
		for (int i=0; i<counter; i++) {
			if(addressBook[i].person.equals(p)) {
				return addressBook[i].address;
			}
		}
		return null;
	}
	
	public boolean update(String firstName, String lastName, String address) {
		NameAddressPair.Person p = new NameAddressPair.Person(firstName, lastName);
		for (int i=0; i<counter; i++) {
			if(addressBook[i].person.equals(p)) {
				addressBook[i].address = address;
				return true;
			}
		}
		return false;
	}
	public boolean delete(String firstName, String lastName) {
		NameAddressPair.Person p = new NameAddressPair.Person(firstName, lastName);
		for (int i=0; i<counter; i++) {
			if(addressBook[i].person.equals(p)) {
				NameAddressPair[] copy = new NameAddressPair[addressBook.length ];
				for (int a = 0, j = 0; a < addressBook.length; a++) {
				    if (a != i) {
				        copy[j++] = addressBook[a];
				    }
				}
				addressBook = copy;
				counter--;
				
				return true;
			}
		}
		return false;
	}
	public int size() {
		return counter;
	}
	public void sortedBy(SortOrder order) {
		if(order == SortOrder.ASC) {
			Arrays.sort(addressBook, new Comparator(){
				public int compare(Object o1, Object o2){
					NameAddressPair s1 = (NameAddressPair)o1;
					NameAddressPair s2 = (NameAddressPair)o2;
					int res = s1.person.firstName.compareTo(s2.person.firstName);
					if (res != 0)
	                    return res;
	                return s1.person.lastName.compareTo(s2.person.lastName);
			}});
		}
		else if(order == SortOrder.DESC) {
			Arrays.sort(addressBook, new Comparator(){
				public int compare(Object o1, Object o2){
					NameAddressPair s1 = (NameAddressPair)o1;
					NameAddressPair s2 = (NameAddressPair)o2;
					int res = s2.person.firstName.compareTo(s1.person.firstName);
					if (res != 0)
	                    return res;
	                return s2.person.lastName.compareTo(s1.person.lastName);
			}});
		}
	}
	private static class NameAddressPair{
		private final Person person;
		private String address;
		
		private NameAddressPair(Person person, String address) {
			this.person = person;
			this.address = address;
		}
		
		@Override
		public String toString() {
			return "First name: " + person.firstName + ", Last name: " 
					+ person.lastName + ", Address: " + address;
		}

		private static class Person{
			private String firstName;
			private String lastName;
			
			private Person(String firstName, String lastName) {
				this.firstName = firstName;
				this.lastName = lastName;
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
				if (lastName == null) {
					if (other.lastName != null)
						return false;
				} else if (!lastName.equals(other.lastName))
					return false;
				return true;
			}
			
		}
	}
	@Override
	public Iterator iterator() {
		return new AddressBookIterator();
	}
	
	@SuppressWarnings("unchecked")
	private class AddressBookIterator implements Iterator {
		private int counter = -1;

		@Override
		public boolean hasNext() {
			if((counter + 1) == addressBook.length) {
            	return false;
            }
			else if(addressBook[counter + 1] == null) {
				return false;
			}
            return true;
        }

		@Override
		public String next() {
			counter +=1;
            return "First name: " + addressBook[counter].person.firstName + ", Last name: " 
					+ addressBook[counter].person.lastName + ", Address: " + addressBook[counter].address;
		}
		
	}

}
