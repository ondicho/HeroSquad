public class Hero {
    private String name;
    private int age;
    private String superPower;
    private String weakness;

    public Hero(String name,int age,String superPower,String weakness){
        name=name;
        age=age;
        superPower=superPower;
        weakness=weakness;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSuperPower() {
        return superPower;
    }

    public String getWeakness() {
        return weakness;
    }
}
