package com.rick.akka;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import akka.actor.UntypedActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class raspberry extends UntypedActor{
    private static Logger logger = Logger.getLogger(raspberry.class);
    @Override
    public void onReceive(Object message) throws Exception{
        logger.info(message.toString());
    }

}
