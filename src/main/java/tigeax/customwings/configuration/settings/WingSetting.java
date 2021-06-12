package tigeax.customwings.configuration.settings;

import tigeax.customwings.CustomWings;
import tigeax.customwings.configuration.WingConfig;

public enum WingSetting implements SettingInterface {

    SHOW_WHEN_MOVING("showWhenMoving", SettingType.BOOLEAN),
    WHITELISTED_WORLDS("whitelistedWorlds", SettingType.WHITELISTEDWORLDS),

    ECONOMY_PRICE_TYPE("economy.priceType", SettingType.STRING), 
    ECONOMY_PRICE("economy.price", SettingType.INT),

    MENU_ITEM_HIDE_IN_MENU("menuItem.hideInMenu", SettingType.BOOLEAN),

    MENU_ITEM_NAME("menuItem.name", SettingType.STRING),
    MENU_ITEM_MATERIAL("menuItem.material", SettingType.MATERIAL),
    MENU_ITEM_SLOT("menuItem.slot", SettingType.GUISLOT),

    MENU_ITEM_LORE_WHEN_EQUIPPED("menuItem.loreWhenEquipped", SettingType.LORE),
    MENU_ITEM_LORE_WHEN_UNEQUIPPED("menuItem.loreWhenUnequipped", SettingType.LORE),
    MENU_ITEM_LORE_WHEN_NO_PERMISSION("menuItem.loreWhenNoPermission", SettingType.LORE),
    MENU_ITEM_LORE_WHEN_CAN_BUY("menuItem.loreWhenCanBuy", SettingType.LORE),

    WING_START_VERTICAL("wing.startVertical", SettingType.DOUBLE),
    WING_START_HORIZONTAL("wing.startHorizontal", SettingType.DOUBLE),
    WING_DISTANCE_BETWEEN_PARTICLES("wing.distanceBetweenParticles", SettingType.DOUBLE),
    WING_TIMER("wing.wingTimer", SettingType.INT),

    WING_FLAP_ANIMATION("wing.flapAnimation", SettingType.BOOLEAN),
    WING_WINGFLAPSPEED("wing.flapSpeed", SettingType.INT), 
    WING_STARTOFFSET("wing.startOffset", SettingType.INT),
    WING_STOPOFFSET("wing.stopOffset", SettingType.INT);

    public String path;
    private SettingType settingType;

    WingSetting(final String path, final SettingType settingType) {
        this.path = path;
        this.settingType = settingType;
    }

    public SettingType getSettingType() {
        return settingType;
    }

    public void setValue(WingConfig wingConfig, Object value) {
        wingConfig.set(this.path, value);
        wingConfig.save();
        CustomWings.getInstance().reload();
    }

    public Object getCurrentValue(WingConfig wingConfig) {

        switch (this) {
            case SHOW_WHEN_MOVING:
                return wingConfig.getShowWhenMoving();
            case WHITELISTED_WORLDS:
                return wingConfig.getWhitelistedWorlds();
            case ECONOMY_PRICE_TYPE:
                return wingConfig.getPriceType();
            case ECONOMY_PRICE:
                return wingConfig.getPrice();
            case MENU_ITEM_HIDE_IN_MENU:
                return wingConfig.isHiddenInGUI();
            case MENU_ITEM_NAME:
                return wingConfig.getGuiItemName();
            case MENU_ITEM_MATERIAL:
                return wingConfig.getGuiItemMaterial();
            case MENU_ITEM_SLOT:
                return wingConfig.getGuiSlot();
            case MENU_ITEM_LORE_WHEN_EQUIPPED:
                return wingConfig.getLoreWhenEquipped();
            case MENU_ITEM_LORE_WHEN_UNEQUIPPED:
                return wingConfig.getLoreWhenUnequipped();
            case MENU_ITEM_LORE_WHEN_NO_PERMISSION:
                return wingConfig.getLoreWhenNoPermission();
            case MENU_ITEM_LORE_WHEN_CAN_BUY:
                return wingConfig.getloreWhenCanBuy();
            case WING_START_VERTICAL:
                return wingConfig.getStartVertical();
            case WING_START_HORIZONTAL:
                return wingConfig.getStartHorizontal();
            case WING_DISTANCE_BETWEEN_PARTICLES:
                return wingConfig.getDistanceBetweenParticles();
            case WING_TIMER:
                return wingConfig.getWingTimer();
            case WING_FLAP_ANIMATION:
                return wingConfig.getWingAnimation();
            case WING_WINGFLAPSPEED:
                return wingConfig.getWingFlapSpeed();
            case WING_STARTOFFSET:
                return wingConfig.getStartOffset();
            case WING_STOPOFFSET:
                return wingConfig.getStopOffset();
        }
        return null;
    }

}
