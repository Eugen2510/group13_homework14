package org.goit.service;

import org.goit.CRUD.TicketCrud;
import org.goit.entities.Ticket;

public class TicketCrudService {
    private final TicketCrud ticketCrud = new TicketCrud();

    public void save(Ticket entity) {
        ticketCrud.save(entity);
    }


    public Ticket findById(long id) {
        return ticketCrud.findById(id);
    }


    public void update(Ticket entity) {
        ticketCrud.update(entity);
    }


    public void delete(Ticket entity) {
        ticketCrud.delete(entity);
    }
}
