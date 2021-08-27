import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface DrinkReceipt {
    public String getName();
    public DrinkReceipt addComponent(String componentName, int componentCount);
}

interface DrinkPreparation {
    public Map<String, Integer> makeDrink();
}
interface Rating {
    public int getRating();
}
class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    private  String name;
    private int rating;
    private Map<String, Integer> ingredients = new HashMap<String, Integer>();
    
    public Caffee(String name, int rating) {
		this.name = name;
		this.rating = rating;
	}
	public Map<String, Integer> getIngredients() {
		return ingredients;
	}
	public void setIngredients(Map<String, Integer> ingredients) {
		this.ingredients = ingredients;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String getName() {
		return this.name;
	}
    @Override
	public DrinkReceipt addComponent(String componentName, int componentCount) {
    	ingredients.put(componentName, componentCount);
		return this;
	}
    @Override
	public Map<String, Integer> makeDrink() {
		this.addComponent("Water", 100).addComponent("Arabica", 20);
		return ingredients;
	}
	@Override
	public int getRating() {
		return this.rating;
	}
	@Override
	public String toString() {
		return "Caffee [name=" + name + ", rating=" + rating + "]";
	}
}
class Espresso extends Caffee {
	public Espresso(String name, int rating) {
		super(name, rating);
	}

	@Override
	public Map<String, Integer> makeDrink() {
		this.addComponent("Water", 50).addComponent("Arabica", 20);
		return super.getIngredients();
	}

	@Override
	public String toString() {
		return "Espresso [name=" + getName() + ", rating=" + getRating() + "]";
	}
}
class Cappuccino extends Caffee {
	public Cappuccino(String name, int rating) {
		super(name, rating);
	}

	@Override
	public Map<String, Integer> makeDrink() {
		this.addComponent("Water", 100).addComponent("Arabica", 20).addComponent("Milk", 50);
		return super.getIngredients();
	}

	@Override
	public String toString() {
		return "Cappuccino [name=" + getName() + ", rating" + getRating() + "]";
	}
}

class MyUtils {
    public Map<String, Double> averageRating(List<Caffee> coffees) {
    	Map<String, Double> res = new HashMap<String, Double>();
    	int[] caffee = {0, 0, 1};
    	int[] espresso = {0, 0, 2};
    	int[] cappuccino = {0,0, 3};
    	if(coffees.isEmpty()) {
    		return res;
    	}
        for(int i=0; i<coffees.size(); i++) {
        	if (coffees.get(i) instanceof Cappuccino) {
        		cappuccino[0] += 1;
        		cappuccino[1] += coffees.get(i).getRating();
        	}
        	else if (coffees.get(i) instanceof Espresso) {
        		espresso[0] += 1;
        		espresso[1] += coffees.get(i).getRating();
        	}
        	else{
        		caffee[0] += 1;
        		caffee[1] += coffees.get(i).getRating();
        	}
        }
        int[][] all = {caffee, espresso, cappuccino};
        for(int i=0; i<all.length; i++) {
        	if(all[i][0] != 0) {
        		if(all[i][2] == 1) {
        			res.put("Caffee", all[i][1]/(double)all[i][0]);
        		}
        		else if(all[i][2] == 2) {
        			res.put("Espresso", all[i][1]/(double)all[i][0]);
        		}
        		else {
        			res.put("Cappuccino", all[i][1]/(double)all[i][0]);
        		}
        	}
        	else {
        		continue;
        	}
        }
        return res;
    }
}
