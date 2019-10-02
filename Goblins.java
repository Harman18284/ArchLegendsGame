public class Goblins extends Monster {

    private float level = 1;

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }

    public Goblins(String name,float HP){
        super(name,HP);
    }

    public void print(){
        super.print();
    }


    @Override
    public void setDefault(){
        this.setHP(100);
    }


    public String name = "Goblins";

}
