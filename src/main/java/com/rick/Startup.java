package com.rick;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.ActorRef;
import com.typesafe.config.ConfigFactory;
import com.rick.model.Pi;
import com.rick.akka.raspberry;

public class Startup{

    private static Logger logger = Logger.getLogger(Startup.class);

    public Startup(){
        ActorSystem system = ActorSystem.create("Rick");

        ActorRef rasp = system.actorOf(Props.create(raspberry.class), "raspberry");
        ActorRef pi = system.actorOf(Pi.props(), "pi");
        rasp.tell("abc",ActorRef.noSender());

        Pi.Greeting g = new Pi.Greeting("test");
        pi.tell(g,ActorRef.noSender());



        system = ActorSystem.create("ClientSys", ConfigFactory.load()
				.getConfig("ClientSys"));

    }
}
