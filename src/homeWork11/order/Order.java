package homeWork11.order;

import homeWork11.product.Product;
import homeWork11.utils.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Order {

    private UUID ID;
    private List<Product> products;
    private LocalDate orderDate;

    public static void addToFile(Order order) {
        try (FileWriter writer = new FileWriter(Constants.ORDER_FILE, true)) {
            String text = order.toString();
            writer.write(text);
            writer.append('\n');

            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Order addProductToOrder(BufferedReader reader, FileReader readProductFile, Order order) {
        String prodName = null;
        boolean notFound = true;
        try {
            System.out.println(Constants.INPUT_PROD_NAME);
            prodName = reader.readLine();
        } catch (Exception e) {
            System.out.println(Constants.WRONG_DATA);
        }
        // Проверим, есть ли выбранный товар в списке товаров
        try (BufferedReader textReader = new BufferedReader(readProductFile)) {
            String line = textReader.readLine();
            while (line != null) {
                if (line.contains(prodName)) {
                    // нашли, можно добавлять в заказ
                    if (order == null) {
                        order = new Order();
                    }
                    Product product = new Product(line);
                    order.products.add(product);
                    notFound = false;
                    break;
                }
                line = textReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (notFound) {
            System.out.println(Constants.NOT_FOUND);
        }
        return order;
    }

    public static Order saveOrder(Order order){
        addToFile(order);
        order.products.removeAll(order.products);
        return null;
    }

    public Order() {
        this.ID = UUID.randomUUID();
        this.orderDate = LocalDate.now();
        products = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return ID.equals(order.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "ID=" + ID +
                ", products=" + products +
                ", orderDate=" + orderDate;
    }
}
