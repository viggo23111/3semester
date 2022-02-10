package entities;

import javax.persistence.Persistence;

public class EntityTested {
    public static void main(String[] args) {

        Persistence.generateSchema("pu", null);
    }
}
