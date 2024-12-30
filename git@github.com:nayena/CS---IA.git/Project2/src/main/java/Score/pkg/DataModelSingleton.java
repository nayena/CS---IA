package Score.pkg;

public class DataModelSingleton {
    private static DataModel instance = new DataModel();

    private DataModelSingleton() {
        // Private constructor to prevent external instantiation
    }

    public static DataModel getInstance() {
        return instance;
    }
}


