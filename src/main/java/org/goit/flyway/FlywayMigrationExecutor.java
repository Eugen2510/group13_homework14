package org.goit.flyway;

import org.flywaydb.core.Flyway;

public class FlywayMigrationExecutor {

    private FlywayMigrationExecutor (){
    }

    public static void executeMigration(){
        Flyway
                .configure()
                .dataSource("jdbc:h2:./SpaceTravelDB", "", "")
                .load().migrate();
    }

}
