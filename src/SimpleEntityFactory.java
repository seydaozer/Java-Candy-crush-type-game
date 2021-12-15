import java.util.Random;

/**
 * This is the simple entity factory class.
 * It creates entity.
 */
public class SimpleEntityFactory {

    /**
     * This method create an entity using EntityCreator object.
     * The type of the entity is randomly determined and the corresponding entity creator is generated.
     * Finally, the entity is created according to the type taken as a parameter using the entity creator.
     * @param x the initial x-coordinate of the entity
     * @param y the initial y-coordinate of the entity
     * @return created entity
     */
    public static Entity createEntity(int x, int y){
        EntityCreator entityCreator;

        Random rand = new Random();
        int style = rand.nextInt(3);
        // atlantis = 0, valhalla = 1, underwild = 2
        int type = rand.nextInt(3);
        // blue/ice = 0, red/fire = 1, green/nature = 2

        if(style == 0){ // ATLANTIS
            entityCreator = new AtlantisEntityCreator();
        }
        else if(style == 1){ // VALHALLA
            entityCreator = new ValhallaEntityCreator();
        }
        else if(style == 2){ // UNDERWILD
            entityCreator = new UnderwildEntityCreator();
        }
        else {
            System.out.println("Error: invalid style of entity.");
            return null;
        }

        return entityCreator.createEntity(type, x, y);
    }
}
