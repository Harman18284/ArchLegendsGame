public class Minions extends Sidekick implements Cloneable {

    public Minions(float HP,float XP, float cost, float damage){
        super(HP,XP,cost,damage);
    }



    @Override
    public void attack(Monster monster){



        System.out.println("You attacked and inflicted " + damage + " damage to the monster.");
        monster.setHP(monster.getHP()- damage);

    }

    @Override
    public void defence(float f,Monster monster){

//        System.out.println("You got " + f+5 + " less damage.");
//        this.setHP(this.getHP()+f+5);


    }

    @Override
    public void toDefault(){
        this.HP=100;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }



}
