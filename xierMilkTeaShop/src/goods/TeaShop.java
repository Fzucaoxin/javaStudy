package goods;

import java.text.SimpleDateFormat;
import java.util.*;

public class TeaShop implements Shop
{
//    //根据实际情况是先进货的生产日期越早，故需要先卖掉或处理，队列这种FIFO的集合比较适合。
//    Queue<Bubble> bubHouse;
//    Queue<Coconut> cocHouse;
    List<Bubble> bubHouse;//保存珍珠。
    List<Coconut> cocHouse;//保存椰果
    MilkTea milkTea;

    //无参构造函数，主要初始化几个久远的配料，便于测试；
    TeaShop()
    {
        bubHouse=new ArrayList<Bubble>();
        cocHouse=new ArrayList<Coconut>();
        //奶茶店原本存在2000年9月1号生产的奶茶。
        Calendar c=Calendar.getInstance();
        c.clear();
        c.set(Calendar.YEAR,2000);
        c.set(Calendar.MONTH,9);
        c.set(Calendar.DATE,1);
        Coconut tem1=new Coconut(c);
        Bubble  tem2=new Bubble(c);
        for (int i=0;i<2;i++)
        {
            cocHouse.add(tem1);
            bubHouse.add(tem2);
        }
    }

    @Override
    //进货——添加配料（参数：配料类）
    public void addObject(Ingredient ingrd)
    {
//        批量进货，一次进5个；
        for (int i=0;i<5;i++)
        {
            if (ingrd instanceof Bubble)
            {
                ingredientAdd((Bubble)ingrd);
            }
            else if (ingrd instanceof Coconut)
            {
                ingredientAdd((Coconut)ingrd);
            }
        }
    }

    @Override
    //出售奶茶（参数：奶茶名字，配料名字（ “Bubble”或“Coconut”）
    public void saleMilkTea(String name,String ingrd)
    {
        String ingrdTem=ingrd;
        Ingredient ingr=null;
        boolean flag=true;
        try
        {
            if (ingrd.equals("Bubble"))
            {
                ingrdTem="珍珠";
                ingr=new Bubble(Calendar.getInstance());
                saleBuble();
            }
            else if (ingrd.equals("Coconut"))
            {
                ingrdTem="椰果";
                ingr=new Coconut(Calendar.getInstance());
                saleCoconut();
            }
        }catch(SoldOutException s)
        {
            System.out.println(ingrdTem+"已经没有了,我们马上去进货您待会再来吧");
            addObject(ingr);
            flag=false;
        }
        if (flag)
        {
            System.out.println("您的"+ingrdTem+"奶茶好了,欢迎下次再来。");
            System.out.println(milkTea.toString());
        }

    }

//   Bubble 配料的私有添加方法；
    private  void ingredientAdd(Bubble bub)
    {
        Bubble tem=new Bubble(Calendar.getInstance());
        bubHouse.add(tem);
    }
//       Coconut 配料的私有添加方法；
    private void ingredientAdd(Coconut coc)
    {
        Coconut tem=new Coconut(Calendar.getInstance());
        cocHouse.add(tem);
    }

//    出售珍珠奶茶时找到未过期的配料，删除过期的配料。若不存在未过期的配料，抛出异常
    private void saleBuble()
    {
        Bubble temp=bubHouse.get(0);
        //获得两时间的毫秒数之差再进行日期天数差的计算
        long dateDis=8;
        for (int i=0,len=bubHouse.size();i<len&&dateDis>temp.exp;i++)
        {
            temp=bubHouse.remove(0);
            dateDis=(Calendar.getInstance().getTime().getTime()-temp.getproductDate())/(1000*60*60*24);
        }
        milkTea=new MilkTea("珍珠奶茶",temp);
        if (dateDis>temp.exp)
            throw new SoldOutException();
    }

//        出售珍珠奶茶时找到未过期的配料，删除过期的配料。若不存在未过期的配料，抛出异常
    private void saleCoconut()
    {
        Coconut temp=cocHouse.get(0);
        //获得两时间的毫秒数之差再进行日期天数差的计算
        Calendar date=Calendar.getInstance();
        long dateDis=8;
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date.getTime()));
        for (int i=0,len=cocHouse.size();i<len&&dateDis>temp.exp;i++)
        {
            temp=cocHouse.remove(0);
            dateDis=(Calendar.getInstance().getTime().getTime()-temp.getproductDate())/(1000*60*60*24);
        }
        milkTea=new MilkTea("椰果奶茶",temp);
        if (dateDis>temp.exp)
            throw new SoldOutException();
    }
}

//接口Shop，有进货添加配料，和出售奶茶两个方法。
interface Shop
{
    void addObject(Ingredient ingrd);
    void saleMilkTea(String name,String ingrd);
}