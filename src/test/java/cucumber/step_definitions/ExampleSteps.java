package cucumber.step_definitions;

import static org.testng.Assert.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import utilities.DataManager;

public class ExampleSteps {

	private static DataManager dataManager = DataManager.getInstance();
	private static List<Map<String, String>> goodFood = new ArrayList<Map<String, String>>();
	private static double firstNumber;
	private static double secondNumber;
	private static double result;

	@Given("caller is asked for a number")
	public void caller_is_asked_for_a_number() {
		System.out.println("What is your number?");
	}

	@When("caller says {int}")
	public void caller_says(Integer num) {
		assertTrue(num >= 1 && num <= 7, "Please enter a number between 1 and 7.");
		String dayOfWeek = DayOfWeek.of(num).name().toLowerCase();
		dataManager.setDayOfWeek(dayOfWeek);
	}

	@Then("caller is told the day is {string}")
	public void caller_is_told_the_day_is(String day) {
		String expectedDayOfWeek = day.strip().toLowerCase();
		String actualDayOfWeek = dataManager.getDayOfWeek();
		assertEquals(actualDayOfWeek, expectedDayOfWeek);
	}

	@Given("user looks at the math problem {int}")
	public void user_looks_at_the(Integer id) {
		System.out.println("Test ID: " + id);
	}

	@Given("nutritional die is important to individual health")
	public void nutritional_die_is_important_to_individual_health() {
		System.out.println("We need to eat more healthy food.");
	}

	@When("we see a food table")
	public void we_see_a_food_table(DataTable dataTable) {
		List<Map<String, String>> dataRows = dataTable.asMaps();
		String key = "health_value";
		for (Map<String, String> row : dataRows) {
			if (row.containsKey(key) && Integer.valueOf(row.get(key)) >= 5) {
				goodFood.add(row);
			}
		}
	}

	@Then("we choose to eat {string} food")
	public void we_choose_to_eat_food(String status) {
		List<String> goodFoodList = new ArrayList<>();
		String key = "status";
		for (Map<String, String> food : goodFood) {
			if (food.containsKey("status")) {
				assertEquals(food.get(key), status);
				goodFoodList.add(food.get("food"));
			}
		}
		System.out.println("We need to eat more of: " + goodFoodList.toString());
	}

	@Then("user performs the {string} operation")
	public void user_performs_the(String operator) {
		switch (operator.strip()) {
		case "add":
			result = firstNumber + secondNumber;
			break;
		case "subtract":
			result = firstNumber - secondNumber;
			break;
		case "multiply":
			result = firstNumber * secondNumber;
			break;
		case "divide":
			result = firstNumber / secondNumber;
			break;
		default:
			assertFalse(true, "Invalid operator.");
			break;
		}
	}

	@When("user gets both the value {double} and the value {double}")
	public void user_gets_both_the_value_and_the_value(Double firstNumber, Double secondNumber) {
		ExampleSteps.firstNumber = firstNumber;
		ExampleSteps.secondNumber = secondNumber;
	}

	@Then("user verify the value {double}")
	public void user_verify_the(Double result) {
		assertEquals(ExampleSteps.result, result);
	}

}
