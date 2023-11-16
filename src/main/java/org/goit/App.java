package org.goit;

import org.goit.entities.Client;
import org.goit.entities.Planet;
import org.goit.entities.Ticket;
import org.goit.flyway.FlywayMigrationExecutor;
import org.goit.hibernate.HibernateUtil;
import org.goit.service.ClientCrudService;
import org.goit.service.PlanetCrudService;
import org.goit.service.TicketCrudService;

import java.util.Date;
import java.util.TimeZone;


public class App {
    public static void main(String[] args) {
       FlywayMigrationExecutor.executeMigration();

       try(HibernateUtil util = HibernateUtil.getInstance()){
           TicketCrudService tcl = new TicketCrudService();
           ClientCrudService ccl = new ClientCrudService();
           PlanetCrudService pcl = new PlanetCrudService();

           Client client = ccl.findById(3);
           Planet fromPlanet = pcl.findById(2);
           Planet toPlanet = pcl.findById(3);

           //create
                //not valid entity
           Ticket newTicket1 = new Ticket();
           newTicket1.setClient(null);
           newTicket1.setFromPlanet(null);
           newTicket1.setToPlanet(null);
           newTicket1.setCreatedAt(new Date());
           tcl.save(newTicket1);

                //valid entity
           Ticket newTicket = new Ticket();
           newTicket.setToPlanet(toPlanet);
           newTicket.setFromPlanet(fromPlanet);
           newTicket.setCreatedAt(new Date());
           newTicket.setClient(client);
           tcl.save(newTicket);

           //read
           Ticket ticket = tcl.findById(3);
           System.out.println(ticket);

           //update
           ticket.setClient(ccl.findById(1));
           tcl.update(ticket);
           System.out.println(tcl.findById(3));

           //delete
           tcl.delete(ticket);
       }

    }
}
