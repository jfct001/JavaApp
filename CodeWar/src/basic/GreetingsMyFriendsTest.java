package basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class GreetingsMyFriendsTest {

	GreetingsMyFriends greetings = new GreetingsMyFriends();

	  @Test
		public void nullArgument() {
			assertNull("Must return null for null args", greetings.greetingForAllFriends((String[]) null));
		}

		@Test
		public void emptyArgument() {
			assertNull("Must return null for empty args", greetings.greetingForAllFriends());
		}

		@Test
		public void notNullArgs() {
			assertNotNull("Must return something else then null for none empty nor null args", greetings.greetingForAllFriends("Bilal"));
		}

		@Test
		public void singleArg() {
			assertEquals(greetings.greetingForAllFriends("Bilal"), "Hello, Bilal!");
		}

}
