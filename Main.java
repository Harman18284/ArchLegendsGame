//import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.lang.*;

//USE all names with first letter capital..

public class Main {

    public static void printHello(){
        System.out.println("hey");
    }

    public static void printJello(){
        System.out.println("hey");
    }

    public static void main(String[] args) throws IOException , CloneNotSupportedException {


        ArrayList<Monster> monsters_fought = new ArrayList<Monster>();



        ArrayList<User> users_list = new ArrayList<User>();
        ArrayList<Hero> heroes_list = new ArrayList<Hero>();
        ArrayList<Monster> monsters_list = new ArrayList<Monster>();

        /////Monster/////
        Goblins Goblins = new Goblins("Goblins",100);
        monsters_list.add(Goblins);
        Zombies Zombies = new Zombies("Zombies",150);
        monsters_list.add(Zombies);
        Fiends Fiends = new Fiends("Fiends",200);
        monsters_list.add(Fiends);
        Lionfang Lionfang = new Lionfang("Lionfang",250);
        monsters_list.add(Lionfang);
        ////////////////

        /////Heroes/////
        Warrior Warrior = new Warrior("Warrior",100,0,1);
        heroes_list.add(Warrior);
        Thief Thief = new Thief("Thief",100,0,1);
        heroes_list.add(Thief);
        Mage Mage = new Mage("Mage",100,0,1);
        heroes_list.add(Mage);
        Healer Healer = new Healer("Healer",100,0,1);
        heroes_list.add(Healer);
        ////////////////


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Random r = new Random();
        Random r1 = new Random();
        Random r2 = new Random();
//
//        System.out.println("Enter a String");
//        String b = br.readLine();

        boolean run=true;

        boolean run2=true;
        boolean clone=false;
//        boolean run10=true;

        while(run){
            boolean run1=true;

            System.out.println("-----------------------------");
            System.out.println("Welcome to ArchLegends");
            System.out.println("Choose your option");
            System.out.println("1) New User");
            System.out.println("2) Existing User");
            System.out.println("3) Exit");

            int q = Integer.parseInt(br.readLine());

            if(q==1){

                System.out.println("Enter Username");
                String username = br.readLine();

                System.out.println("Choose a Hero");
                System.out.println("1) Warrior");
                System.out.println("2) Thief");
                System.out.println("3) Mage");
                System.out.println("4) Healer");

                Hero temp=Warrior;

                int q1 = Integer.parseInt(br.readLine());

                if(q1==1){
                    temp= Warrior;
                }
                else if(q1==2){
                    temp= Thief;
                }
                else if(q1==3){
                    temp= Mage;
                }
                else if(q1==4){
                    temp= Healer;
                }
                else{
                    System.out.println("Select specified options only..");
                }

                users_list.add(new User(username,temp));
                System.out.println("User Creation Done - UserName = " + username + "  Heroname = " + temp.name);
                System.out.println("Log in to play the game! Exiting....");


            }

            if(q==2){

                System.out.println("Enter Username");
                String username = br.readLine();



                for (User user : users_list) {
                    if (user.getUsername().equals(username)) {
                        System.out.println("User Found... logging in");
                        System.out.println("Welcome - " + username);

                        while(run1==true){



                            System.out.println("-------------------------------------------------------");
                            System.out.println("You are at the starting location. Choose path:");
                            System.out.println("Below locations are changed randomly in each iteration.");
                            System.out.println("1) Go to Random Location 1");
                            System.out.println("2) Go to Random Location 2");
                            System.out.println("3) Go to Random Location 3");
                            System.out.println("4) Exit");
                            System.out.println("5) Sequence of Monsters");

                            int a = Integer.parseInt(br.readLine());

                            if(a==1 || a==2 || a==3){

                                Monster m=monsters_list.get(0);

                                //defeated less than 3
                                if(user.getHero().getMonsters_defeated()<3){

                                    int rand = r1.nextInt(3);
                                    m=monsters_list.get(rand);

                                }

                                //defeated more than 3 (lionfang is included) (hardcoded to get lionfang)
                                //uncomment to make it normal...
                                if(user.getHero().getMonsters_defeated()>=3){

//                                    int rand = r1.nextInt(4);
//                                    m=monsters_list.get(rand);
                                      m = monsters_list.get(3);
                                }

                                monsters_fought.add(m);

                                System.out.println("Moving to a random location");
                                System.out.println("Fight Started. Your fighting with Monster - " + m.getName());



                                System.out.println("Type yes if you wish to use a sidekick, else type no..");
                                String use = br.readLine();

                                if(use.equals("yes")){

                                    if(user.Sidekick_list.isEmpty()){
                                        System.out.println("You don't have any Sidekick...");
                                    }
                                    else if(!user.Sidekick_list.isEmpty()){

                                        Sidekick temp = user.Sidekick_list.get(0);

                                        if(temp instanceof Minions){
                                            System.out.println("You have a Sidekick Minion with you. Attack of sidekick is - " + temp.damage);

                                            if(temp.isClone_flag()){
                                                System.out.println("Press c to use cloning ability, Else press f to continue fight..");
                                                String z = br.readLine();
                                                if(z.equals("c")){
                                                    System.out.println("Cloning done");
                                                    clone=true;
                                                }
                                                else if(z.equals("f")){

                                                }

                                            }

                                        }
                                        else if(temp instanceof Knight){
                                            System.out.println("You have a Sidekick Knight with you. Attack of sidekick is - " + temp.damage);
                                        }

                                    }

                                    int counter=0;
                                    int sp_counter=4;
                                    boolean special_move=false;
                                    boolean hehe=false;


                                    while(run2){

                                        if(!user.Sidekick_list.isEmpty() && user.Sidekick_list.get(0).getHP()<=0){
                                            System.out.println("Sidekick Dead...");
                                            user.Sidekick_list.get(0).toDefault();
                                            user.Sidekick_list.remove(0);
                                        }

                                        if(user.Sidekick_list.isEmpty()){
                                            user.Sidekick_list.add(new Minions(100,0,5,0));
                                            user.Sidekick_list.add(new Knight(100,0,8,0));
                                        }

                                        if(user.getHero().getHP()<=0){
                                            System.out.println("-------------------------------------------------------");
                                            System.out.println("GameOver! You've been defeated by " + m.getName());

                                            //setting hero & monster to default..
                                            user.getHero().setDefault(m);
                                            m.setDefault();

                                            if(!user.Sidekick_list.isEmpty()){
                                                user.Sidekick_list.get(0).toDefault();
                                            }

                                            run1=false;
                                            break;



                                        }

                                        System.out.println("Choose move:\n" +
                                                "1) Attack\n" +
                                                "2) Defense\n" +
                                                "3) Special Move");

                                        boolean defence = false;
                                        boolean defence_special = false;
                                        boolean sp_flag = false;
//
                                        int b = Integer.parseInt(br.readLine());

                                        if(b==1){

                                            if(special_move==true){

                                                user.getHero().attack_special(m);
                                                if(clone){
                                                    Sidekick c1 = (Sidekick) user.Sidekick_list.get(0).clone();
                                                    Sidekick c2 = (Sidekick) user.Sidekick_list.get(0).clone();
                                                    Sidekick c3 = (Sidekick) user.Sidekick_list.get(0).clone();
                                                    c1.attack(m);
                                                    c2.attack(m);
                                                    c3.attack(m);

                                                    clone=false;

                                                    user.Sidekick_list.get(0).setClone_flag(false);
                                                }

                                                    user.Sidekick_list.get(0).attack(m);


                                            }
                                            else{
                                                user.getHero().attack(m);

                                                if(clone){
                                                    Sidekick c1 = (Sidekick) user.Sidekick_list.get(0).clone();
                                                    Sidekick c2 = (Sidekick) user.Sidekick_list.get(0).clone();
                                                    Sidekick c3 = (Sidekick) user.Sidekick_list.get(0).clone();
                                                    c1.attack(m);
                                                    c2.attack(m);
                                                    c3.attack(m);

                                                    clone=false;

                                                    user.Sidekick_list.get(0).setClone_flag(false);
                                                }

                                                    user.Sidekick_list.get(0).attack(m);


                                            }
                                            System.out.println("Monsters details");
                                            m.print();


                                        }
                                        else if(b==2 || b==3){

                                            if(b==2){

                                                if(special_move){
                                                    defence_special=true;
                                                }
                                                else{
                                                    defence=true;
                                                }

                                            }
                                            else if(b==3){

                                                if((counter%3==0 || counter>3) && counter!=0){

                                                    hehe=true;
                                                    special_move=true;
                                                    user.getHero().special_power(m);


                                                    if(clone){
                                                        Sidekick c1 = (Sidekick) user.Sidekick_list.get(0).clone();
                                                        Sidekick c2 = (Sidekick) user.Sidekick_list.get(0).clone();
                                                        Sidekick c3 = (Sidekick) user.Sidekick_list.get(0).clone();
                                                        c1.attack(m);
                                                        c2.attack(m);
                                                        c3.attack(m);

                                                        clone=false;

                                                        user.Sidekick_list.get(0).setClone_flag(false);
                                                    }

                                                    user.Sidekick_list.get(0).attack(m);


                                                    System.out.println("Monsters details");
                                                    m.print();

                                                    counter=0;

                                                }
                                                else{
                                                    sp_flag=true;
                                                    System.out.println("Can't apply special power...");
                                                }

                                            }


                                        }

                                        if(m.getHP()<=0){

                                            user.Sidekick_list.get(0).toDefault();
                                            System.out.println("-------------------------------------------------------");
                                            System.out.println("Congratulations! You've defeated " + m.getName());

                                            user.getHero().setXP(user.getHero().getLevel()*20);
                                            user.Sidekick_list.get(0).setXP((float) (user.Sidekick_list.get(0).getXP()+user.getHero().getXP()*0.10));
                                            System.out.println("Sidekick has also gained " + user.Sidekick_list.get(0).getXP() + " XP");

                                            if(m.name.equals("Lionfang")){

                                                System.out.println("You've Completed the game..You're the Champion but You can continue the game for fun");
                                            }

                                            /////////////////////////////////////////
                                            System.out.println("Available XP - " + user.getHero().getXP());


                                            System.out.println("If you would like to buy a sidekick, type yes otherwise type no to upgrade level..");
                                            String option = br.readLine();
                                            if(option.equals("yes")){
                                                //code for sidekick
                                                System.out.println("Your current XP is - " + user.getHero().getXP());
                                                System.out.println("If you want to buy a Minion, press 1");
                                                System.out.println("If you want to buy a Knight, press 2");

                                                int o = Integer.parseInt(br.readLine());

                                                if(o==1){

                                                    //buy a minion code....
                                                    System.out.println("How many XP's would you like to spend? ( Minimum 5xp )");
                                                    int nxp = Integer.parseInt(br.readLine());

                                                    user.getHero().setXP(user.getHero().getXP()-nxp);

                                                    System.out.println("You bought a Minion  ");
                                                    float sidekick_attack = (float) ((nxp-5)*0.5 + 1);
                                                    System.out.println("Attack of Sidekick - " + sidekick_attack);

                                                    user.Sidekick_list.add(new Minions(100,0,nxp,sidekick_attack));
                                                    Collections.sort(user.Sidekick_list, new SortByXP());
                                                    System.out.println("XP of sidekick - " + user.Sidekick_list.get(user.Sidekick_list.size()-1).getXP());



                                                }
                                                else if(o==2){

                                                    // buy a Knight code....
                                                    System.out.println("How many XP's would you like to spend? ( Minimum 7 xp ) ");
                                                    int nxp = Integer.parseInt(br.readLine());

                                                    user.getHero().setXP(user.getHero().getXP()-nxp);

                                                    System.out.println("You bought a Knight ");
                                                    float sidekick_attack = (float) ((nxp-8)*0.5 + 2);
                                                    System.out.println("Attack of Sidekick - " + sidekick_attack);

                                                    user.Sidekick_list.add(new Knight(100,0,nxp,sidekick_attack));
                                                    Collections.sort(user.Sidekick_list, new SortByXP());
                                                    System.out.println("XP of sidekick - " + user.Sidekick_list.get(user.Sidekick_list.size()-1).getXP());

                                                }


                                            }
                                            else{

                                                System.out.println("Your level is increased...");
                                                user.getHero().setLevel(user.getHero().getLevel()+1);

                                            }

                                            user.getHero().setMonsters_defeated(user.getHero().getMonsters_defeated() + 1);

                                            if(user.getHero().getLevel()==1){
                                                user.getHero().setHP(100);
                                            }

                                            if(user.getHero().getLevel()==2){
                                                user.getHero().setHP(150);
                                            }
                                            if(user.getHero().getLevel()==3){
                                                user.getHero().setHP(200);
                                            }
                                            if(user.getHero().getLevel()==4){
                                                user.getHero().setHP(250);
                                            }

                                            System.out.println("New Level - " + user.getHero().getLevel() + " New XP - " + user.getHero().getXP() + " New HP - " + user.getHero().getHP());

                                            //setting monster to default
                                            m.setDefault();

                                            break;

                                        }

                                        //Monster attack.....
                                        if(!sp_flag ){

                                            if(!hehe){


//                                        int val = (int) Math.round(((r.nextGaussian()+1)/2)*0.25*monsters_list.get(user.getHero().getLevel()-1).getHP());
//                                        val= Math.abs(val);

                                                if(m.name.equals("Lionfang")){

                                                    int bound = (int) r2.nextInt(9);

                                                    if(bound==6){

                                                        int val= (int) Math.round(0.50*user.getHero().getHP());


                                                        float val1 = (float) ((float) val*1.5);


                                                        System.out.println("Monster attacked and inflicted "+ val +" damage to you.");
                                                        user.getHero().setHP(user.getHero().getHP()-val);

                                                        if(!user.Sidekick_list.isEmpty()){
                                                            System.out.println("Monster attacked and inflicted "+ val1 +" damage to Sidekick.");
                                                            user.Sidekick_list.get(0).setHP(user.Sidekick_list.get(0).getHP()-val1);
                                                            user.Sidekick_list.get(0).print();
                                                        }




                                                        System.out.println("Heroes details");
                                                        user.getHero().print();

                                                        counter++;

                                                        if(special_move){
                                                            sp_counter--;
                                                        }


                                                        if(sp_counter==0){
                                                            special_move=false;
                                                            sp_counter=4;
                                                        }

                                                    }
                                                    else{

                                                        int val= (int) Math.round(0.25*m.getHP());
                                                        val = r.nextInt(val);

                                                        float val1 = (float) ((float) val*1.5);


                                                        System.out.println("Monster attacked and inflicted "+ val +" damage to you.");
                                                        user.getHero().setHP(user.getHero().getHP()-val);

                                                        if(!user.Sidekick_list.isEmpty()){
                                                            System.out.println("Monster attacked and inflicted "+ val1 +" damage to Sidekick.");
                                                            user.Sidekick_list.get(0).setHP(user.Sidekick_list.get(0).getHP()-val1);
                                                            user.Sidekick_list.get(0).print();
                                                        }

                                                        System.out.println("Heroes details");
                                                        user.getHero().print();

                                                        counter++;

                                                        if(special_move){
                                                            sp_counter--;
                                                        }


                                                        if(sp_counter==0){
                                                            special_move=false;
                                                            sp_counter=4;
                                                        }

                                                    }

                                                }
                                                else{


                                                    int val= (int) Math.round(0.25*m.getHP());

                                                    if(val==1 || val==2 || val==3 ){
                                                        val=4;
                                                    }

                                                    val = r.nextInt(val);

                                                    float val1 = (float) ((float) val*1.5);


                                                    System.out.println("Monster attacked and inflicted "+ val +" damage to you.");
                                                    user.getHero().setHP(user.getHero().getHP()-val);

                                                    if(!user.Sidekick_list.isEmpty()){
                                                        System.out.println("Monster attacked and inflicted "+ val1 +" damage to Sidekick.");
                                                        user.Sidekick_list.get(0).setHP(user.Sidekick_list.get(0).getHP()-val1);
                                                        user.Sidekick_list.get(0).print();
                                                    }

                                                    System.out.println("Heroes details");
                                                    user.getHero().print();

                                                    counter++;

                                                    if(special_move){
                                                        sp_counter--;
                                                    }


                                                    if(sp_counter==0){
                                                        special_move=false;
                                                        sp_counter=4;
                                                    }

                                                }


                                            }
                                            hehe=false;
//
                                        }

                                        if(defence_special){
                                            float x=user.getHero().getHP();
                                            user.getHero().defence_special(m);

                                            if(m.name.equals("Zombies")){
                                                user.Sidekick_list.get(0).defence(user.getHero().getHP()-x,m);
                                            }



                                            System.out.println("Monsters details");
                                            m.print();
                                        }

                                        if(defence==true){

                                            float x=user.getHero().getHP();
                                            user.getHero().defence(m);

                                            if(m.name.equals("Zombies")){
                                                user.Sidekick_list.get(0).defence(user.getHero().getHP()-x,m);
                                            }

                                            System.out.println("Monsters details");
                                            m.print();

                                        }

                                    }



                                }
                                else if(use.equals("no")){

                                    int counter=0;
                                    int sp_counter=4;
                                    boolean special_move=false;
                                    boolean hehe=false;


                                    while(run2){

                                        if(user.getHero().getHP()<=0){
                                            System.out.println("-------------------------------------------------------");
                                            System.out.println("GameOver! You've been defeated by " + m.getName());

                                            //setting hero & monster to default..
                                            user.getHero().setDefault(m);
                                            m.setDefault();
                                            run1=false;
                                            break;



                                        }

                                        System.out.println("Choose move:\n" +
                                                "1) Attack\n" +
                                                "2) Defense\n" +
                                                "3) Special Move");

                                        boolean defence = false;
                                        boolean defence_special = false;
                                        boolean sp_flag = false;
//
                                        int b = Integer.parseInt(br.readLine());

                                        if(b==1){

                                            if(special_move==true){

                                                user.getHero().attack_special(m);
                                            }
                                            else{
                                                user.getHero().attack(m);



                                            }
                                            System.out.println("Monsters details");
                                            m.print();


                                        }
                                        else if(b==2 || b==3){

                                            if(b==2){

                                                if(special_move){
                                                    defence_special=true;
                                                }
                                                else{
                                                    defence=true;
                                                }

                                            }
                                            else if(b==3){

                                                if((counter%3==0 || counter>3) && counter!=0){

                                                    hehe=true;
                                                    special_move=true;
                                                    user.getHero().special_power(m);

                                                    System.out.println("Monsters details");
                                                    m.print();

                                                    counter=0;

                                                }
                                                else{
                                                    sp_flag=true;
                                                    System.out.println("Can't apply special power...");
                                                }

                                            }


                                        }

                                        if(m.getHP()<=0){

                                            System.out.println("-------------------------------------------------------");
                                            System.out.println("Congratulations! You've defeated " + m.getName());

                                            user.getHero().setXP(user.getHero().getLevel()*20);

                                            if(m.name.equals("Lionfang")){

                                                System.out.println("You've Completed the game..You're the Champion but You can continue the game for fun");
                                            }

                                            /////////////////////////////////////////


                                            System.out.println("If you would like to buy a sidekick, type yes otherwise type no to upgrade level..");
                                            String option = br.readLine();
                                            if(option.equals("yes")){
                                                //code for sidekick
                                                System.out.println("Your current XP is - " + user.getHero().getXP());
                                                System.out.println("If you want to buy a Minion, press 1");
                                                System.out.println("If you want to buy a Knight, press 2");

                                                int o = Integer.parseInt(br.readLine());

                                                if(o==1){

                                                    //buy a minion code....
                                                    System.out.println("How many XP's would you like to spend? ( Minimum 5xp )");
                                                    int nxp = Integer.parseInt(br.readLine());

                                                    user.getHero().setXP(user.getHero().getXP()-nxp);

                                                    System.out.println("You bought a Minion  ");
                                                    float sidekick_attack = (float) ((nxp-5)*0.5 + 1);
                                                    System.out.println("Attack of Sidekick - " + sidekick_attack);

                                                    user.Sidekick_list.add(new Minions(100,0,nxp,sidekick_attack));
                                                    Collections.sort(user.Sidekick_list, new SortByXP());
                                                    System.out.println("XP of sidekick - " + user.Sidekick_list.get(user.Sidekick_list.size()-1).getXP());



                                                }
                                                else if(o==2){

                                                    // buy a Knight code....
                                                    System.out.println("How many XP's would you like to spend? ( Minimum 7 xp ) ");
                                                    int nxp = Integer.parseInt(br.readLine());

                                                    user.getHero().setXP(user.getHero().getXP()-nxp);

                                                    System.out.println("You bought a Knight ");
                                                    float sidekick_attack = (float) ((nxp-8)*0.5 + 2);
                                                    System.out.println("Attack of Sidekick - " + sidekick_attack);

                                                    user.Sidekick_list.add(new Knight(100,0,nxp,sidekick_attack));
                                                    Collections.sort(user.Sidekick_list, new SortByXP());
                                                    System.out.println("XP of sidekick - " + user.Sidekick_list.get(user.Sidekick_list.size()-1).getXP());

                                                }


                                            }
                                            else{

                                                System.out.println("Your level is increased...");
                                                user.getHero().setLevel(user.getHero().getLevel()+1);

                                            }

                                            user.getHero().setMonsters_defeated(user.getHero().getMonsters_defeated() + 1);

                                            if(user.getHero().getLevel()==1){
                                                user.getHero().setHP(100);
                                            }

                                            if(user.getHero().getLevel()==2){
                                                user.getHero().setHP(150);
                                            }
                                            if(user.getHero().getLevel()==3){
                                                user.getHero().setHP(200);
                                            }
                                            if(user.getHero().getLevel()==4){
                                                user.getHero().setHP(250);
                                            }

                                            System.out.println("New Level - " + user.getHero().getLevel() + " New XP - " + user.getHero().getXP() + " New HP - " + user.getHero().getHP());

                                            //setting monster to default
                                            m.setDefault();

                                            break;

                                        }

                                        //Monster attack.....
                                        if(!sp_flag ){

                                            if(!hehe){


//                                        int val = (int) Math.round(((r.nextGaussian()+1)/2)*0.25*monsters_list.get(user.getHero().getLevel()-1).getHP());
//                                        val= Math.abs(val);

                                                if(m.name.equals("Lionfang")){

                                                    int bound = (int) r2.nextInt(9);

                                                    if(bound==6){

                                                        int val= (int) Math.round(0.50*user.getHero().getHP());

                                                        float val1 = (float) ((float) val*1.5);


                                                        System.out.println("Monster attacked and inflicted "+ val +" damage to you.");
                                                        user.getHero().setHP(user.getHero().getHP()-val);

                                                        if(!user.Sidekick_list.isEmpty()){
                                                            System.out.println("Monster attacked and inflicted "+ val1 +" damage to Sidekick.");
                                                            user.Sidekick_list.get(0).setHP(user.Sidekick_list.get(0).getHP()-val1);
                                                            user.Sidekick_list.get(0).print();
                                                        }

                                                        System.out.println("Heroes details");
                                                        user.getHero().print();

                                                        counter++;

                                                        if(special_move){
                                                            sp_counter--;
                                                        }


                                                        if(sp_counter==0){
                                                            special_move=false;
                                                            sp_counter=4;
                                                        }

                                                    }
                                                    else{

                                                        int val= (int) Math.round(0.25*m.getHP());
                                                        val = r.nextInt(val);

                                                        float val1 = (float) ((float) val*1.5);


                                                        System.out.println("Monster attacked and inflicted "+ val +" damage to you.");
                                                        user.getHero().setHP(user.getHero().getHP()-val);

                                                        if(!user.Sidekick_list.isEmpty()){
                                                            System.out.println("Monster attacked and inflicted "+ val1 +" damage to Sidekick.");
                                                            user.Sidekick_list.get(0).setHP(user.Sidekick_list.get(0).getHP()-val1);
                                                            user.Sidekick_list.get(0).print();
                                                        }

                                                        System.out.println("Heroes details");
                                                        user.getHero().print();

                                                        counter++;

                                                        if(special_move){
                                                            sp_counter--;
                                                        }


                                                        if(sp_counter==0){
                                                            special_move=false;
                                                            sp_counter=4;
                                                        }

                                                    }

                                                }
                                                else{


                                                    int val= (int) Math.round(0.25*m.getHP());

                                                    if(val==1 || val==2 || val==3 ){
                                                        val=4;
                                                    }

                                                    val = r.nextInt(val);

                                                    float val1 = (float) ((float) val*1.5);


                                                    System.out.println("Monster attacked and inflicted "+ val +" damage to you.");
                                                    user.getHero().setHP(user.getHero().getHP()-val);

                                                    if(!user.Sidekick_list.isEmpty()){
                                                        System.out.println("Monster attacked and inflicted "+ val1 +" damage to Sidekick.");
                                                        user.Sidekick_list.get(0).setHP(user.Sidekick_list.get(0).getHP()-val1);
                                                        user.Sidekick_list.get(0).print();
                                                    }

                                                    System.out.println("Heroes details");
                                                    user.getHero().print();

                                                    counter++;

                                                    if(special_move){
                                                        sp_counter--;
                                                    }


                                                    if(sp_counter==0){
                                                        special_move=false;
                                                        sp_counter=4;
                                                    }

                                                }


                                            }
                                            hehe=false;
//
                                        }

                                        if(defence_special){
                                            user.getHero().defence_special(m);

                                            System.out.println("Monsters details");
                                            m.print();
                                        }

                                        if(defence==true){

                                            user.getHero().defence(m);

                                            System.out.println("Monsters details");
                                            m.print();

                                        }

                                    }

                                }



                            }

                            else if(a==4){
                                System.out.println("Exiting.....");
                                break;
                            }

                            else if(a==5){
                                System.out.println("Sequence of monsters...");
                                for(int i=0;i<monsters_fought.size();i++){
                                    System.out.println(i+1 + ") " + monsters_fought.get(i).name);
                                }
                            }

                        }


                    }
                }

            }

            if(q==3){
                System.out.println(" Exiting....");
                break;
            }


        }

    }

}
