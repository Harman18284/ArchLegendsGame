abstract class Monster {

    protected String name;
    protected float HP;

    public Monster(String name,float HP){
        this.HP=HP;
        this.name=name;
    }

    public float getHP() {
        return HP;
    }

    public void setHP(float HP) {
        this.HP = HP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print (){
        System.out.println(" HP - " + HP);

    }

    abstract void setDefault();

}
