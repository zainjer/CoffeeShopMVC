package com.company.controllers;

import com.company.models.Server;
import com.company.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ServerController {

    static List<Server> serverList = new ArrayList<>();

    public static void generateServers(String[] names){
        Log.add("Generating Servers");
        for (String name : names) {
            serverList.add(new Server(name));
        }

    }

    public static void startServing(){
        Log.add("Started Servering");
        serverList.forEach(Server::StartServing);
    }

    public static void printStatus(){

        if(serverList.size()<1)
            return;

        for (Server server : serverList) {
            System.out.println(server.getLastServed());
        }
    }
}
