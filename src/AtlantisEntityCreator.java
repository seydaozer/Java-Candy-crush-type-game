/**
 * The AtlantisEntityCreator class is a Concrete Creator Class.
 */
public class AtlantisEntityCreator extends EntityCreator {

    /**
     * This method creates an atlantis entity of the type taken as a parameter.
     * @param type the type of the atlantis entity to create
     * @param x the initial x-coordinate of the atlantis entity
     * @param y the initial y-coordinate of the atlantis entity
     * @return the created atlantis entity
     */
    @Override
    public Entity createEntity(int type, int x, int y) {
        Entity entity;
        EntityPropertyFactory propertyFactory = new AtlantisPropertyFactory();

        if(type == 0){ // BLUE
            entity = new BlueIceEntity(propertyFactory, x, y);
            entity.setName("Atlantis-Ice");
            entity.setStyle(0);
        } else if(type == 1){ // RED
            entity = new RedFireEntity(propertyFactory, x, y);
            entity.setName("Atlantis-Fire");
            entity.setStyle(0);
        } else if(type == 2){ // GREEN
            entity = new GreenNatureEntity(propertyFactory, x, y);
            entity.setName("Atlantis-Nature");
            entity.setStyle(0);
        } else{
            System.out.println("Error: invalid type of entity.");
            return null;
        }

        entity.initialize();
        return entity;
    }
}
