/**
 * The ValhallaEntityCreator class is a Concrete Creator Class.
 */
public class ValhallaEntityCreator extends EntityCreator {

    /**
     * This method creates a valhalla entity of the type taken as a parameter.
     * @param type the type of the valhalla entity to create
     * @param x the initial x-coordinate of the valhalla entity
     * @param y the initial y-coordinate of the valhalla entity
     * @return the created valhalla entity
     */
    @Override
    public Entity createEntity(int type, int x, int y) {
        Entity entity;
        EntityPropertyFactory propertyFactory = new ValhallaPropertyFactory();

        if(type == 0){ // BLUE
            entity = new BlueIceEntity(propertyFactory, x, y);
            entity.setName("Valhalla-Ice");
            entity.setStyle(1);
        } else if(type == 1){ // RED
            entity = new RedFireEntity(propertyFactory, x, y);
            entity.setName("Valhalla-Fire");
            entity.setStyle(1);
        } else if(type == 2){ // GREEN
            entity = new GreenNatureEntity(propertyFactory, x, y);
            entity.setName("Valhalla-Nature");
            entity.setStyle(1);
        } else{
            System.out.println("Error: invalid type of entity.");
            return null;
        }

        entity.initialize();
        return entity;
    }
}
