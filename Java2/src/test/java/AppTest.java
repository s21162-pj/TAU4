import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AppTest {
    private static App sut;

    @BeforeEach
    void setUp() {
        sut = new App();
        sut.makeFriends("Andrzej", "Szymon");
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }

    @Test
    @DisplayName("List contains Key")
    public void test_List_has_key() {
        assertThat(sut.friendships, hasKey("Andrzej"));
    }

    @Test
    @DisplayName("Key 1 has item")
    public void test_Key1_has_item() {
        assertThat(sut.friendships, hasEntry(is("Andrzej"), hasItem("Szymon")));
    }

    @Test
    @DisplayName("Key 2 has item")
    public void test_Key2_has_item() {
        assertThat(sut.friendships, hasEntry(is("Szymon"), hasItem("Andrzej")));
    }

    @Test
    @DisplayName("Test method 'areFriends' = true")
    public void test_areFriends_true() {
        assertThat(sut.areFriends("Andrzej", "Szymon"), is(true));
    }

    @Test
    @DisplayName("Test method 'areFriends' = false")
    public void test_areFriends_false() {
        assertThat(sut.areFriends("Andrzej", "Jan"), not(true));
    }

    @Test
    @DisplayName("Test method 'getFriendsList'")
    public void test_getFriendsList_true() {
        assertThat(sut.getFriendsList("Andrzej"), notNullValue());
    }
}
