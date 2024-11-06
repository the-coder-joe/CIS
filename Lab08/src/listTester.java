import static org.junit.Assert.*;

import org.junit.Test;

public class listTester {
	@Test
	public void calculate() {
		TVShowList list = new TVShowList();
		list.fromFile("tvs.csv");
		TVShowList rogList = list.findNameList("Rog");
		System.out.print("Number containing \"Rog\": ");
		System.out.println(rogList.size());

		TVShowList episodeRogList = list.findNameList("Rog", 10);

		System.out.print("Number containing \"Rog\" with 10 or more episodes: ");
		System.out.println(episodeRogList.size());
	}

	@Test
	public void test() {
		TVShowList testList = new TVShowList();

		// test empty TVShowList
		assertEquals(0, testList.findNameList("abc", 10).size());

		testList.fromFile("testFile.csv");

		assertEquals(5, testList.size());

		TVShowList a = testList.findNameList("oo");
		TVShowList b = testList.findNameList("oo", 100);

		assertEquals(2, a.size());
		assertEquals(1, b.size());

		b.reset();
		TVShow testShow = b.getNext();

		assert (testShow.equals(testShow));

		assertEquals(0, testShow.compareTo(testShow));
	}
}
