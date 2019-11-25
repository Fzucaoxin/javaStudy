package goods;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public  class Bubble extends Ingredient
{
    //配料Bubble的构造方法
    Bubble(Calendar productDate)
    {
        super("Bubble",productDate,7);
    }

    @Override
    public String toString ()
    {
        return "配料名："+this.name+"  生产日期："+new SimpleDateFormat("yyyy-MM-dd").format(this.productDate.getTime())+"  保质期："+this.exp+"天";
    }

    public long  getproductDate()
    {
//        获取当前时间:
//        Calendar date = Calendar.getInstance();
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(productDate.getTime()));
        return productDate.getTime().getTime();
    }
}
