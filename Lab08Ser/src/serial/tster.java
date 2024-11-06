package serial;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class tster {

	@Test
	public void test() throws IOException, ClassNotFoundException {
		TVShowSer testShow = new TVShowSer("6457d26c7b901e08b141869d,13,How do you like Wednesday?,水曜どうでしょう,\"How do you like Wednesday? was a Japanese television variety series that aired on the HTB network in Hokkaidō, Japan, and on other regional television networks in Japan. The program debuted on HTB on October 9, 1996. The series was one of the first local variety programs to be produced on Hokkaido; prior to this series' launch, local variety programs in Hokkaidō were virtually non-existent. The program also had a significant influence on other local programs in other regions in Japan, most notably Kwangaku! in Kansai and Nobunaga in Tokai.\\n\\nThe series achieved a record 18.6% viewing share on December 8, 1999, the highest share for a late-night program on a local TV station.\\n\\nProduction of the weekly regular series ended in September 2002, though new limited-run series were produced on average of every 18 months; the latest series was shown on HTB in late 2005, eight episodes in length.\\n\\nMost of the series have been rerun under the names of Dōdeshō Returns and Suiyō Dōdeshō Classic.\",,true,Returning Series,ja,JP,,,,,,,,1996-10-09,2022-02-16,568,4,/i2MwS6U0XzD8ad6aS3HiTNKz8ov.jpg,35,,,,,,,,Comedy,,,,,,,,6457d26c7b901e08b141869e,,,,,,,,9.2,2,21.207,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,\r\n");
	
		testShow.toSerFile("abc.dat");
		
		TVShowSer newShow = testShow.fromSerFile("abc.dat");
		
		System.out.println(newShow);
	}

}
