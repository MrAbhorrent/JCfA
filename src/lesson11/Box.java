package lesson11;

public class Box<T extends Fruit> {

    private int count;
    private final T typeFruit;

    public Box(T typeFruit, int count) {
        this.typeFruit = typeFruit;
        this.count = count;
    }

    public Box(T typeFruit) {
        this(typeFruit, 0);
    }

    /**
     * Return weight one the box with fruit
     * @return - float
     */
    public float getWeight() {
        return typeFruit.getWeight() * count;
    }

    public void add(T fruit, int count) {
        if (fruit.getClass().equals(typeFruit.getClass())) {
            this.count += count;
            return;
        }
        System.out.printf("\u001B[31m Фрукты %s нельзя добавить в эту коробку\n\u001B[0m", fruit.getClass().getSimpleName());
    }

    public boolean compare(Box<T> anotherBox) {
        return this.getWeight() == anotherBox.getWeight();
    }

    public void putTo(Box<T> anotherBox) {
        if (anotherBox.typeFruit.equals(this.typeFruit)) {
            anotherBox.add(this.typeFruit, this.count);
            this.count = 0;
        } else {
            System.out.printf("\u001B[31m Фрукты %s нельзя пересыпать в целевую коробку\n\u001B[0m", this.typeFruit);
        }
    }

    @Override
    public String toString() {
        return String.format("В коробке лежат фрукты: %s\nКоличество - %d",
                this.typeFruit.getClass().getSimpleName(),
                this.count
        );
    }
}
