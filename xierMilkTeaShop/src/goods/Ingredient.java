package goods;

import java.util.Calendar;

public abstract class Ingredient
{
    protected String name;//配料名字
    protected Calendar productDate;//生产日期使用Calendar 类
    protected int exp;//保质期（单位：天）

    //抽象类配料的构造方法
    Ingredient(String name,Calendar productDate,int exp)
    {
        this.name=name;
        this.productDate=productDate;
        this.exp=exp;
    }

    @Override
    public abstract String toString();
}
