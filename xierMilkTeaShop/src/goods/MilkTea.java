package goods;

public class MilkTea
{
    private String name;//奶茶的名字
    private Ingredient ingred;//奶茶的配料
    // 奶茶的构造函数；
    MilkTea (String name,Ingredient ingred)
    {
        this.name=name;
        this.ingred=ingred;
    }
    @Override
    public String toString()
    {
        return  "奶茶名:"+name+", 配料："+ingred.toString();
    }
}
