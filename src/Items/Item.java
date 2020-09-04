package Items;

import java.util.Objects;

public abstract class Item {
    private String item;

    public String getText() {
        return item;
    }

    public void setText(String item) {
        this.item = item;
    }

   public Item (String item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(item, item.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }

    @Override
    public String toString() {
        return "ItemV2{" +
                "text='" + item + '\'' +
                '}';
    }
}