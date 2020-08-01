package bankAccountApp;

/**
 * @author Ana on 7/24/2020
 */
public interface IntBaseRate {

    default double getBaseRate(){
        return 1.3;
    }
}
