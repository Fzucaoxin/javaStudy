package goods;

public class Test
{
    public static void main(String[] args)
    {
        TeaShop xier=new TeaShop();
//        初始配料均为过期配料，第一次出售后发现无该配料，自动进货。 批量进货，一次进5个；
        xier.saleMilkTea("珍珠奶茶","Bubble");
//       初始配料均为过期配料，第一次出售后发现无该配料，自动进货。批量进货，一次进5个；
        for (int i=0;i<5;i++)
        {
            xier.saleMilkTea("椰果奶茶","Coconut");
            xier.saleMilkTea("珍珠奶茶","Bubble");
        }
    }
}
