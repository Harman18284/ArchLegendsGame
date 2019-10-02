abstract class Sidekick implements Cloneable{

    protected float HP=100;
    protected float XP=0;
    protected float cost;
    protected float damage;

    abstract void attack(Monster monster);
    abstract void defence(float f,Monster monster);
    abstract void toDefault();



    protected boolean clone_flag=true;

    public Sidekick(float HP,float XP, float  cost, float damage){

        this.HP=HP;
        this.XP=XP;
        this.cost=cost;
        this.damage=damage;

    }

    public void print(){
        System.out.println("Sidekick HP - " + this.getHP() + " XP - "+ this.getXP());
    }

    public float getHP() {
        return HP;
    }

    public void setHP(float HP) {
        this.HP = HP;
    }

    public float getXP() {
        return XP;
    }

    public void setXP(float XP) {
        this.XP = XP;
    }

//    public float  getBase_cost() {
//        return base_cost;
//    }
//
//    public void setBase_cost(float  base_cost) {
//        this.base_cost = base_cost;
//    }

    public boolean isClone_flag() {
        return clone_flag;
    }

    public void setClone_flag(boolean clone_flag) {
        this.clone_flag = clone_flag;
    }


    public float  getCost() {
        return cost;
    }

    public void setCost(float  cost) {
        this.cost = cost;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }


    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }




}
