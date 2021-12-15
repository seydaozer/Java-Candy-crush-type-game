/**
 * The EntityCreator class is a Creator Class.
 * It contains the abstract factory method. It is used for create an entity.
 */
public abstract class EntityCreator {

    /**
     * This method creates an entity of the type taken as a parameter.
     * The abstract factory method is what all Creator subclasses must implement.
     * @param type the type of the entity to create
     * @param x the initial x-coordinate of the entity
     * @param y the initial y-coordinate of the entity
     * @return the created entity
     */
    public abstract Entity createEntity(int type, int x , int y);

}
