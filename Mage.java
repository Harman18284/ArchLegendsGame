public class Mage extends Hero{


    public Mage(String name,float HP,float XP,float level){
        super(name,HP,XP,level);
    }

    @Override
    public void attack(Monster monster){

        System.out.println("You attacked and inflicted 5 damage to the monster.");
        monster.setHP(monster.getHP()-5);

    }
    @Override
    public void defence(Monster monster){
        System.out.println("You got 5HP less damage.");
        this.setHP(this.getHP()+5);

    }
    @Override
    public void special_power(Monster monster){


    }
    @Override
    public void attack_special(Monster monster){

        System.out.println("You attacked and inflicted 5 damage to the monster.");
        monster.setHP(monster.getHP()-5);
        System.out.println("and 5% extra damage...");
        float k = (int) Math.round(monster.getHP()*0.05);
        monster.setHP(monster.getHP()-k);

    }

    @Override
    public void defence_special(Monster monster){
        System.out.println("You got 5HP less damage.");
        this.setHP(this.getHP()+5);

        System.out.println("and 5% extra damage...");
        float k = (int) Math.round(monster.getHP()*0.05);
        monster.setHP(monster.getHP()-k);


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
