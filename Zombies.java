public class Zombies extends Monster {

    private float level = 2;

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }

    public Zombies(String name,float HP){
        super(name,HP);
    }

    public void print(){
        super.print();
    }


    @Override
    public void setDefault(){
        this.setHP(150);
    }

    public String name = "Zombies";
}
