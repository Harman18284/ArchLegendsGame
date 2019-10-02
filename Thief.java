public class Thief extends Hero {


    public Thief(String name,float HP,float XP,float level){
        super(name,HP,XP,level);
    }

    @Override
    public void attack(Monster monster){

        System.out.println("You attacked and inflicted 6 damage to the monster.");
        monster.setHP(monster.getHP()-6);

    }
    @Override
    public void defence(Monster monster){
        System.out.println("You got 4HP less damage.");
        this.setHP(this.getHP()+4);

    }
    @Override
    public void special_power(Monster monster){

        System.out.println("You've destructed 30% of opponents HP.");
       float k = (int) Math.round(monster.getHP()*0.30);
        monster.setHP(monster.getHP()-k);

    }
    @Override
    public void attack_special(Monster monster){
        System.out.println("You attacked and inflicted 6 damage to the monster.");
        monster.setHP(monster.getHP()-6);


    }

    @Override
    public void defence_special(Monster monster){
        System.out.println("You got 4HP less damage.");
        this.setHP(this.getHP()+4);

    }

    @Override
    public void setDefault(Monster monster){
        this.setHP(100);
        this.setLevel(1);
        this.setXP(0);
        this.setMonsters_defeated(0);
    }

    public void print(){
        super.print();
    }



}
