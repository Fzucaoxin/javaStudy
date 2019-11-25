package Thread;

class HelloWorld {
    private int n;
    private boolean flag=true;
    public HelloWorld( int n){
        this.n = n;
    }
    public synchronized void hello() throws InterruptedException{
        for (int i=0;i<n;i++)
        {
            if (!flag)
                this.wait();
            System.out.print("Hello");
            this.notifyAll();
            flag=!flag;
        }
    }

    public synchronized void  world() throws InterruptedException{
        for (int i = 0; i < n; i++) {
//            t2=Thread.currentThread();
                if (flag)
                    this.wait();
                System.out.println("World!");
                this.notifyAll();
                flag=!flag;
            }
        }
    }
