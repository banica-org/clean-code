package refactored;

public class Application {

    private static final int DAYS = 10;

    public static void main(final String[] args) {
        final Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6)};

        final GildedRoseShop application = new GildedRoseShop(items);

        for (int index = 0; index < DAYS; index++) {
            System.out.println("-------- day " + index + " --------");
            System.out.println("name, sellIn, quality");

            for (final Item item : items) {
                System.out.println(item);
            }

            System.out.println();

            application.updateQuality();
        }
    }

}
