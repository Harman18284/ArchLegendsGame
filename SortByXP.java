import java.util.Comparator;

public class SortByXP implements Comparator<Sidekick> {

    public int compare(Sidekick a, Sidekick b)
    {
        return  (int) b.getXP() - (int) a.getXP() ;
    }

}
