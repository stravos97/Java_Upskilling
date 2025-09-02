package generics;

public class GenericRectangle<T extends Number> {

    private T width;
    private T height;

    public GenericRectangle(T width, T height) {
        this.width = width;
        this.height = height;
    }

    public T getWidth() {
        return width;
    }

    public void setWidth(T width) {
        this.width = width;
    }

    public T getHeight() {
        return height;
    }

    public void setHeight(T height) {
        this.height = height;
    }

    static <V> void outputToConsole(V value) {
        System.out.println("Rectangle has an area of " + value);
    }
}
