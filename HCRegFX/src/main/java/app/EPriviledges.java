package app;

/**
 *
 * @author grze
 */
public enum EPriviledges {
    
    ADMIN("admin"),
    DOCTOR("doctor"),
    USER("user");
    
    private final String value;

    public String getValue() {
        return value;
    }

    private EPriviledges(String value) {
        this.value = value;
    }
    
}
