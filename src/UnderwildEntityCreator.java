/**
 * The UnderwildEntityCreator class is a Concrete Creator Class.
 */
public class UnderwildEntityCreator extends EntityCreator {

    /**
     * This method creates an underwild entity of the type taken as a parameter.
     * @param type the type of the underwild entity to create
     * @param x the initial x-coordinate of the underwild entity
     * @param y the initial y-coordinate of the underwild entity
     * @return the created underwild entity
     */
    @Override
    public Entity createEntity(int type, int x, int y) {
        Entity entity;
        EntityPropertyFactory propertyFactory = new UnderwildPropertyFactory();

        if(type == 0){ // BLUE
            entity = new BlueIceEntity(propertyFactory, x, y);
            entity.setName("Underwild-Ice");
            entity.setStyle(2);
        } else if(type == 1){ // RED
            entity = new RedFireEntity(propertyFactory, x, y);
            entity.setName("Underwild-Fire");
            entity.setStyle(2);
        } else if(type == 2){ // GREEN
            entity = new GreenNatureEntity(propertyFactory, x, y);
            entity.setName("Underwild-Nature");
            entity.setStyle(2);
        } else{
            System.out.println("Error: invalid type of entity.");
            return null;
        }

        entity.initialize();
        return entity;
    }
}