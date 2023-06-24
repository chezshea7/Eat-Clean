// Class to store the data related to Food
public class Food{

    private String foodName; // Name of the food
	private int calories; // Calories in the food
	private boolean isOrganic; // True if the food is organic
	
	public Food(){
		this.foodName = "";
		this.calories = 0;
		this.isOrganic = false;
	}
	
	public Food(String name, int cal, boolean org){
		this.foodName = name;
		this.calories = cal;
		this.isOrganic = org;
	}
	
	public String getName(){
		return this.foodName;
	}
	
	public int getCalories(){
		return this.calories;
	}
	
	public boolean isOrganic(){
		return this.isOrganic;
	}
	
	public void setName(String name){
		this.foodName = name;
	}
	
	public void setCalories(int cal){
		this.calories = cal;
	}
	
	public void setOrganic(boolean org){
		this.isOrganic = org;
	}
	
	public String toString(){
		return "Food: " + this.foodName + " | Calories: " + this.calories + " | Organic: " + this.isOrganic;
	}
}

// Class to store the data related to a Meal
public class Meal{

	private String mealName; // Name of the meal
	private ArrayList<Food> foods; // List of foods in the meal
	
	public Meal(){
		this.mealName = "";
		this.foods = new ArrayList<Food>();
	}
	
	public Meal(String name){
		this.mealName = name;
		this.foods = new ArrayList<Food>();
	}
	
	public void addFood(Food food){
		this.foods.add(food);
	}
	
	public void removeFood(Food food){
		this.foods.remove(food);
	}
	
	public double getCalories(){
		double cals = 0;
		for (Food food : this.foods){
			cals += food.getCalories();
		}
		return cals;
	}
	
	public int getOrganicFoodCount(){
		int count = 0;
		for (Food food : this.foods){
			if (food.isOrganic()){
				count++;
			}
		}
		return count;
	}
	
	public String toString(){
		String str = "Meal: " + this.mealName + "\n";
		for (Food food :this.foods){
			str += food.toString() + "\n";
		}
		return str;
	}
}

// Class to store data related to a Person 
public class Person{
	
	private String name; // Name of the Person
	private ArrayList<Meal> meals; // List of meals of the person
	
	public Person(){
		this.name = "";
		this.meals = new ArrayList<Meal>();
	}
	
	public Person(String name){
		this.name = name;
		this.meals = new ArrayList<Meal>();
	}
	
	public void addMeal(Meal meal){
		this.meals.add(meal);
	}
	
	public void removeMeal(Meal meal){
		this.meals.remove(meal);
	}
	
	public int getMealCount(){
		return this.meals.size();
	}
	
	public double getCalories(){
		double cals = 0;
		for (Meal meal : this.meals){
			cals += meal.getCalories();
		}
		return cals;
	}
	
	public int getOrganicMealCount(){
		int count = 0;
		for (Meal meal : this.meals){
			if (meal.getOrganicFoodCount() > 0){
				count++;
			}
		}
		return count;
	}
	
	public String toString(){
		String str = "Person: " + this.name + "\n";
		for (Meal meal : this.meals){
			str += meal.toString() + "\n";
		}
		return str;
	}
}

// Class to store data related to a Person's diet
public class Diet{

	private Person person; // Person whose diet plan is to be followed
	private double calories; // Target calories for the person
	private int organicMealCount; // Target organic meal count
	
	public Diet(){
		this.person = new Person();
		this.calories = 0.0;
		this.organicMealCount = 0;
	}
	
	public Diet(Person person, double cal, int orgMeal){
		this.person = person;
		this.calories = cal;
		this.organicMealCount = orgMeal;
	}
	
	public void setPerson(Person person){
		this.person = person;
	}
	
	public void setTargetCalories(double cal){
		this.calories = cal;
	}
	
	public void setOrganicMealCount(int orgMeal){
		this.organicMealCount = orgMeal;
	}
	
	public Person getPerson(){
		return this.person;
	}
	
	public double getTargetCalories(){
		return this.calories;
	}
	
	public int getOrganicMealCount(){
		return this.organicMealCount;
	}
	
	public void planDiet(){
		double difference = this.calories - this.person.getCalories();
		int organic = this.organicMealCount - this.person.getOrganicMealCount();
		
		// If person has not met the target calories and organic meal count
		if (difference > 0 || organic > 0){
			// Set of healthy foods
			ArrayList<Food> healthyFoods = new ArrayList<Food>();
			healthyFoods.add(new Food("Oats", 150, true));
			healthyFoods.add(new Food("Apple", 95, true));
			healthyFoods.add(new Food("Salmon", 430, true));
			healthyFoods.add(new Food("Mixed Vegetables", 90, true));
			healthyFoods.add(new Food("Tofu", 95, true));
			
			// Set of organic foods
			ArrayList<Food> organicFoods = new ArrayList<Food>();
			organicFoods.add(new Food("Organic Eggs", 85, true));
			organicFoods.add(new Food("Organic Milk", 90, true));
			organicFoods.add(new Food("Organic Rice", 180, true));
			
			// Calculate the calories difference and organic meal count difference
			double calsDiff = difference;
			int orgMealDiff = organic;
			
			while(calsDiff > 0 && orgMealDiff > 0){
				// Pick a random organic food and add it
				Random rand = new Random();
				int index = rand.nextInt(organicFoods.size());
				Food food = organicFoods.get(index);
				
				// Create a meal and add the food
				Meal meal = new Meal("Organic Meal");
				meal.addFood(food);
				
				// Add the meal to person's list
				this.person.addMeal(meal);
				
				// Update the differences
				calsDiff -= food.getCalories();
				orgMealDiff--;
			}
			
			while(calsDiff > 0){
				// Pick a random healthy food and add it
				Random rand = new Random();
				int index = rand.nextInt(healthyFoods.size());
				Food food = healthyFoods.get(index);
				
				// Create a meal and add the food
				Meal meal = new Meal("Healthy Meal");
				meal.addFood(food);
				
				// Add the meal to person's list
				this.person.addMeal(meal);
				
				// Update the difference
				calsDiff -= food.getCalories();
			}
			
		}
		
	}
	
}