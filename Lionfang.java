public class Lionfang extends Monster {

    private float level = 4;

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }

    public Lionfang(String name,float HP){
        super(name,HP);
    }

    public void print(){
        super.print();
    }


    @Override
    public void setDefault(){
        this.setHP(250);
    }

    public String name = "Lionfang";

}
