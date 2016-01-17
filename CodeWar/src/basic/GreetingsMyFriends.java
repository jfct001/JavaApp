package basic;

public class GreetingsMyFriends {
	
	public String[] greetingForAllFriends(String... friends) {
		// check whether the argument is null
		if (friends == null) return null;
		// check whether the argument is empty
		if (friends.length == 0) return null;

		String[] greetingArray = new String[friends.length];
		int i = 0;
		for (String friend: friends) {
			greetingArray[i] = "Hello, " + friend + "!";
			i++;
		}
		
		return greetingArray;
  }
}
