class VanillaFlavor implements Flavor {
    private static final double PRICE = 2.5;
    private static final int ID = 1;
    private static final String FLAVOR_NAME = "Vanilla";

    @Override
    public String getFlavorDescription() {
        return FLAVOR_NAME;
    }

    @Override
    public double getPrice() {
        return PRICE;
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public String getName() {
        return FLAVOR_NAME;
    }
}
