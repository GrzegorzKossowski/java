package application.device;

/**
 * PointOfSale
 * Created by Grzegorz Kossowski on 18.03.17.
 * LCD messages
 */
public enum LcdMessage {

    ERROR("Invalid bar-code"),
    NO_PRODUCT("Product not found");

    private final String text;

    private LcdMessage(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
