public class Fiends extends Monster {



    private float level = 3;

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }



    public Fiends(String name,float HP){
        super(name,HP);
    }

    public void print(){
        super.print();
    }

    @Override
    public void setDefault(){
        this.setHP(200);
    }

    public String name = "Fiends";

}
