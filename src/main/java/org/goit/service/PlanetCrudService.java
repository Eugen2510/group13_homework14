package org.goit.service;

import org.goit.CRUD.PlanetCrud;
import org.goit.entities.Planet;

public class PlanetCrudService {
    private final PlanetCrud planetCrud = new PlanetCrud();

    public void save(Planet entity) {
        planetCrud.save(entity);
    }


    public Planet findById(long id) {
        return planetCrud.findById(id);
    }


    public void update(Planet entity) {
        planetCrud.update(entity);
    }


    public void delete(Planet entity) {
        planetCrud.delete(entity);
    }
}
