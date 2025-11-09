import java.util.*;

/**
 * Клас Clothing описує об'єкт одягу з основними характеристиками.
 */
class Clothing implements Comparable<Clothing> {
    private String type;
    private String size;
    private String color;
    private double price;
    private String brand;

    /**
     * Конструктор для створення об'єкта Clothing.
     */
    public Clothing(String type, String size, String color, double price, String brand) {
        this.type = type;
        this.size = size;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    public String getType() { return type; }
    public String getSize() { return size; }
    public String getColor() { return color; }
    public double getPrice() { return price; }
    public String getBrand() { return brand; }

    /**
     * Порівняння двох об'єктів Clothing.
     * Сортування: спочатку за ціною (зростання),
     * а якщо ціни однакові — за брендом (спадання).
     */
    @Override
    public int compareTo(Clothing other) {
        int priceCompare = Double.compare(this.price, other.price);
        if (priceCompare == 0) {
            return other.brand.compareTo(this.brand);
        }
        return priceCompare;
    }

    /**
     * Перевіряє рівність двох об'єктів за всіма полями.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Clothing)) return false;
        Clothing other = (Clothing) obj;
        return type.equals(other.type)
                && size.equals(other.size)
                && color.equals(other.color)
                && Double.compare(price, other.price) == 0
                && brand.equals(other.brand);
    }


    @Override
    public String toString() {
        return String.format("Clothing{type='%s', size='%s', color='%s', price=%.2f, brand='%s'}",
                type, size, color, price, brand);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Створення масиву об'єктів Clothing
        Clothing[] clothes = {
                new Clothing("Jacket", "M", "Black", 1500, "Nike"),
                new Clothing("T-Shirt", "L", "White", 500, "Adidas"),
                new Clothing("Pants", "S", "Blue", 1200, "Zara"),
                new Clothing("Dress", "M", "Red", 1200, "Gucci")
        };

        System.out.println("Початковий список одягу:");
        for (Clothing c : clothes) {
            System.out.println(c);
        }

        Arrays.sort(clothes);

        System.out.println("\nПісля сортування:");
        for (Clothing c : clothes) {
            System.out.println(c);
        }


        System.out.println("\nВведіть дані об’єкта для пошуку:");
        System.out.print("Тип одягу: ");
        String type = sc.nextLine();
        System.out.print("Розмір: ");
        String size = sc.nextLine();
        System.out.print("Колір: ");
        String color = sc.nextLine();
        System.out.print("Ціна: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Бренд: ");
        String brand = sc.nextLine();

        Clothing target = new Clothing(type, size, color, price, brand);

        // Перевірка наявності об'єкта в масиві
        boolean found = Arrays.asList(clothes).contains(target);

        System.out.println("\nРезультат пошуку:");
        if (found) {
            System.out.println("Об’єкт знайдено в масиві: " + target);
        } else {
            System.out.println("Такого об’єкта немає в масиві.");
        }

        sc.close();
    }
}

