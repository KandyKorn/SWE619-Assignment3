import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GrowListTest {

	@Test //Test that second list is its own object
	void separateInstancesTest() {
		GrowList<String> list = new GrowList<String>();
		GrowList<String> list2 = new GrowList<String>();
		list2 = list.add("cat");
		assertEquals(0, list.size());
		assertEquals(1, list2.size());
	}
	@Test //Test that nothing is added to original list
	void immutableListTest() {
		GrowList<String> list = new GrowList<String>();
		list.add("cat");
		assertEquals(0,list.size());
	}
	@Test //Test that the correct value is stored
	void indexCheckTest() {
		GrowList<String> list = new GrowList<String>();
		GrowList<String> list2 = new GrowList<String>();
		GrowList<String> list3 = new GrowList<String>();
		list2 = list.add("cat");
		list3 = list2.add("dog");
		assertEquals("dog",list3.get(1));
	}
}
