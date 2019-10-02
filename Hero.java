abstract class Hero {

    protected String name;
    protected float HP;
    protected float XP;
    protected float level;
    protected float sm_count=0;

    protected float monsters_defeated=0;

    public Hero(String name,float HP,float XP,float level){
        this.name=name;
        this.HP=HP;
        this.XP=XP;
        this.level=level;
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

    public float getSm_count() {
        return sm_count;
    }

    public void setSm_count(float sm_count) {
        this.sm_count = sm_count;
    }

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMonsters_defeated() {
        return monsters_defeated;
    }

    public void setMonsters_defeated(float monsters_defeated) {
        this.monsters_defeated = monsters_defeated;
    }


    public void print(){
        System.out.println(" HP - " + HP + " XP - " + XP);

    }

    /////////Abstract Methods///////////

    abstract void attack(Monster monster);
    abstract void attack_special(Monster monster);
    abstract void defence(Monster monster);
    abstract void defence_special(Monster monster);
    abstract void special_power(Monster monster);
    abstract void setDefault(Monster monster);




}
