package com.rick.model;
//data from http://doc.akka.io/docs/akka/2.0.1/intro/getting-started-first-java.html
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class Pi extends AbstractActor{
    private static Logger logger = Logger.getLogger(Pi.class);

    public Pi(){

    }
    public static Props props(){
        return Props.create(Pi.class);
    }

    public static class Greeting{
        public final String message;
        public Greeting(String message){
            this.message = message;
        }
    }

    @Override
    public Receive createReceive(){
        return receiveBuilder().match(Greeting.class,m->{
            logger.info(m.message);
        }).build();
    }


}
