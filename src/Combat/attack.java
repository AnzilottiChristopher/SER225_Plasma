package Combat;



public class attack {

    private String name;
    private atkType type;
    private int atkPower;

    public attack()
    {
        this.name = "null";
        this.type = atkType.SPORTS;
        this.atkPower = 0;
    }

    public attack(String name, atkType type, int atkPower)
    {
        this.name = name;
        this.type = type;
        this.atkPower = atkPower;
    }

    public atkType getAtkType()
    {
        return this.type;
    }

    public String getAtkName()
    {
        return this.name;
    }

    public int getAtkPower()
    {
        return this.atkPower;
    }

    public void upgradeAtkPower()
    {
        this.atkPower += 3;
    }

    
}


