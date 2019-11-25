package goods;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Coconut extends Ingredient
{
    //配料Coconut的构造方法
    Coconut(Calendar productDate)
    {
        super("Coconut",productDate,5);
    }

    @Override
    public String toString ()
    {
        return "配料名："+this.name+"  生产日期："+new SimpleDateFormat("yyyy-MM-dd").format(this.productDate.getTime())+"  保质期："+this.exp+"天";
    }

    public long  getproductDate()
    {
        return productDate.getTime().getTime();
    }
}