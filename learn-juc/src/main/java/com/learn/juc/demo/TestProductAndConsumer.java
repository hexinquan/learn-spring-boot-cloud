package com.learn.juc.demo;

/**
 * Created by hexinquan on 2019/03/25.
 * 生产者消费者案例
 * wait notifyAll
 */
public class TestProductAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(productor,"生产者A").start();
        new Thread(productor,"生产者B").start();
        new Thread(consumer,"消费者A").start();
        new Thread(consumer,"消费者B").start();
    }
}
//店员
class Clerk{
    private int product = 0;
     //进货
    public synchronized void get(){
        //if(product >= 1){ //会产生虚假唤醒
        while (product >= 1){
            System.out.println("产品已满!");
            try{
                this.wait();
            }catch (Exception e){
            }
        }
            System.out.println(Thread.currentThread().getName()+":"+ ++product);
            this.notifyAll();
    }
    public synchronized void sale(){
        //if(product <=0){  //会产生虚假唤醒
        while (product <=0){
            System.out.println("缺货!");
            try{
                this.wait();
            }catch (Exception e){
            }
        }
        System.out.println(Thread.currentThread().getName()+" : "+ --product);
        this.notifyAll();
    }
}
class Productor implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i<20;i++){
            clerk.get();
            try {
                Thread.sleep(200);
            }catch (Exception e){

            }
        }
    }
    private Clerk clerk;
    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }
}
class Consumer implements Runnable{

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i =0;i<20;i++){
            clerk.sale();
        }
    }
}
