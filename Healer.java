public class Healer extends Hero {



    public Healer(String name,float HP,float XP,float level){
        super(name,HP,XP,level);
    }
    @Override
    public void attack(Monster monster){

        System.out.println("You attacked and inflicted 4 damage to the monster.");
        monster.setHP(monster.getHP()-4);

    }
    @Override
    public void attack_special(Monster monster){

        System.out.println("You attacked and inflicted 4 damage to the monster.");
        monster.setHP(monster.getHP()-4);

        System.out.println("and 5% extra HP for you...");
        float k = (int) Math.round(this.getHP()*0.05);
        this.setHP(this.getHP()+k);


    }

    @Override
    public void defence_special(Monster monster){

        System.out.println("You got 8HP less damage.");
        this.setHP(this.getHP()+8);

        System.out.println("and 5% extra HP for you...");
        float k = (int) Math.round(this.getHP()*0.05);
        this.setHP(this.getHP()+k);
    }
    @Override
    public void defence(Monster monster){
        System.out.println("You got 8HP less damage.");
        this.setHP(this.getHP()+8);


    }
    @Override
    public void special_power(Monster monster){


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
