package entity;

public class messmge {
    private int id;
    private String name;
    private String ri;
    private int money;

    public messmge() {
    }

    public messmge(int id, String name, String ri, int money) {
        this.id = id;
        this.name = name;
        this.ri = ri;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRi() {
        return ri;
    }

    public void setRi(String ri) {
        this.ri = ri;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "messmge{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ri='" + ri + '\'' +
                ", money=" + money +
                '}';
    }
}
