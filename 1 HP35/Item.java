public class Item {
    private ItemType type;
    private int value;

    public ItemType type() {
        return type;
    }

    public int value() {
        return value;
    }

    public static Item Value(int val) {
        Item temp = new Item();
        temp.type = ItemType.VALUE;
        temp.value = val;
        return temp;
    }
    

    public static Item Add() {
        Item temp = new Item();
        temp.type = ItemType.ADD;
        return temp;
    }

    public static Item Sub() {
        Item temp = new Item();
        temp.type = ItemType.SUB;
        return temp;
    }

    public static Item Mul() {
        Item temp = new Item();
        temp.type = ItemType.MUL;
        return temp;
    }

    public static Item Div() {
        Item temp = new Item();
        temp.type = ItemType.DIV;
        return temp;
    }
}