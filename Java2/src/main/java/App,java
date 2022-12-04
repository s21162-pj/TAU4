import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    Map<String, List<String>> friendships = new HashMap<>();

    //Dodanie przyjaciół - wykorzystuje funkcje addFriend!
    public void makeFriends(String person1, String person2) {
        addFriend(person1, person2);
        addFriend(person2, person1);
    }

    //Pobranie listy przyjaciol
    public List<String> getFriendsList(String person) {
        return friendships.get(person);
    }

    //Sprawdzenie czy przyjaciele
    public boolean areFriends(String person1, String person2) {
        List<String> friends = getFriendsList(person1);
        return friends.contains(person2);
    }

    //Dodanie do listy przyjaciol do danej osoby
    private void addFriend(String person, String friend) {
        List<String> friends = getFriendsList(person);
        if (friends == null) {
            friends = new ArrayList<String>();
        }

        friends.add( friend );
        friendships.put(person, friends);
    }
}
