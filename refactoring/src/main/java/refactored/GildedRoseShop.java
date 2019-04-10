package refactored;

public final class GildedRoseShop {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    private static final String AGED_BRIE = "Aged Brie";

    private static final String CONJURED = "Conjured";

    private static final int MIN_QUALITY = 0;

    private static final int MAX_QUALITY = 50;

    private final Item[] items;

    public GildedRoseShop(final Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            final String itemName = item.name;

            if (itemName.equals(SULFURAS)) {
                continue;
            }

            decreaseSellDate(item);

            if (itemName.equals(BACKSTAGE_PASSES)) {
                updateBackstagePasses(item);
            } else {
                final int qualityChange = getQualityChange(item);
                if (itemName.equals(AGED_BRIE)) {
                    increaseQualityIfNotMax(item, qualityChange);
                } else {
                    decreaseQualityIfNotMin(item, qualityChange);
                }
            }
        }
    }

    private static void decreaseSellDate(final Item item) {
        item.sellIn--;
    }

    private static boolean isSellDatePassed(final Item item) {
        return item.sellIn < 0;
    }

    private static void updateBackstagePasses(final Item item) {
        if (isSellDatePassed(item)) {
            item.quality = MIN_QUALITY;
        } else {
            final int qualityChange;
            if (item.sellIn <= 5) {
                qualityChange = 3;
            } else if (item.sellIn <= 10) {
                qualityChange = 2;
            } else {
                qualityChange = 1;
            }
            increaseQualityIfNotMax(item, qualityChange);
        }
    }

    private static int getQualityChange(final Item item) {
        int qualityChange = 1;

        if (isSellDatePassed(item)) {
            qualityChange *= 2;
        }

        if (isConjuredItem(item)) {
            qualityChange *= 2;
        }

        return qualityChange;
    }

    private static boolean isConjuredItem(final Item item) {
        return item.name.contains(CONJURED);
    }

    private static void increaseQualityIfNotMax(final Item item, final int qualityChange) {
        item.quality = Math.min(item.quality + qualityChange, MAX_QUALITY);
    }

    private static void decreaseQualityIfNotMin(final Item item, final int qualityChange) {
        item.quality = Math.max(item.quality - qualityChange, MIN_QUALITY);
    }

}
