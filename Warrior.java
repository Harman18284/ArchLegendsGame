public class Warrior extends Hero{

   public Warrior(String name,float HP,float XP,float level){
       super(name,HP,XP,level);
   }
    @Override
   public void attack(Monster monster){

        System.out.println("You attacked and inflicted 10 damage to the monster.");
        monster.setHP(monster.getHP()-10);
//       System.out.println(monster.getHP());
//        this.sm_count+=1;

   }
    @Override
   public void attack_special(Monster monster){
       System.out.println("You attacked and inflicted 15 damage to the monster.");
       monster.setHP(monster.getHP()-15);

   }
    @Override
   public void defence(Monster monster){

       System.out.println("You got 3HP less damage.");
       this.setHP(this.getHP()+3);


   }
    @Override
   public void defence_special(Monster monster){
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
