import java.time.format.SignStyle;
import java.util.ArrayList;

public class User {

    private String username;
    private Hero hero;

    public User(String username, Hero hero) {

        this.hero=hero;
        this.username=username;

    }

//
//    public Sidekick getSidekick() {
//        return sidekick;
//    }
//
//    public void setSidekick(Sidekick sidekick) {
//        this.sidekick = sidekick;
//    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    ArrayList<Sidekick> Sidekick_list = new ArrayList<Sidekick>();


}
