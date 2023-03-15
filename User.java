
/**
 * A player owning both a name and his own points
 * Used to be displayed in the leaderboard
 * 
 * @author T
 * @version 1.0
 */
public class User
{
    private String name;
    private String points;

    
    
    /**
     * Creates a new User with the given name and points
     *
     * @param name Name of the user
     * @param points Points the user was able to achieve until now
     */
    public User(String name, String points)
    {
        this.name=name;
        this.points=points;
    }
    
    /**
     * Creates a new User with the given name no value for points
     *
     * @param name Name of the user
     */
    public User(String name)
    {
        this.name=name;
    }
    
    /**
     * Returns the value of the variable name
     *
     * @return Username
     */
    public String getName(){
        return name;
    }
    /**
     * Returns the value of the variable points
     *
     * @return Points of the user
     */
    public String getPoints(){
        return points;
    }
    
}
