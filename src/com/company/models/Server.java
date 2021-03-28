package com.company.models;

import com.company.controllers.OrdersController;
import com.company.util.Log;

public class Server {

    String name;
    Thread T;
    Order lastServedOrder;
    public Server(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Thread getT() {
        return T;
    }

    public void StartServing(){
        T = new Thread(this::serve);
        T.start();
    }

    private void serve() {
        Log.add(name+" Started Serving");
        while(OrdersController.getOrderList().size()>0){
            var currentOrder = OrdersController.getOrderList().stream().filter(o-> !o.isStatus()).findFirst().orElse(null);

            if(currentOrder == null){
                Log.add(name+ " Couldn't find any orders");
                break;
            }


            currentOrder.setStatus(true);
            lastServedOrder = currentOrder;
            Log.add(name+ " Served "+ currentOrder.getCustomer()+" their order of "+currentOrder.getMenuItem());
            try{
                Thread.sleep(15000);
            }catch (InterruptedException e){
                e.printStackTrace();
                Log.add(e.getLocalizedMessage());
            }
        }
        Log.add(name+" Finished Serving");
    }
    public String getLastServed(){
        if(lastServedOrder == null)
            return name + " Hasn't served anyone yet!";
        return name + " just served "+ lastServedOrder.toString();
    }
}
