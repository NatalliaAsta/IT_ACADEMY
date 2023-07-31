package homeWork11.product;

import homeWork11.utils.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Product {

    private UUID ID;
    private LocalDate producedDate;
    private String name;
    private double price;

    public static void addToFile(Product product) {
        try (FileWriter writer = new FileWriter(Constants.PROD_FILE, true)) {
            String text = product.toString();
            writer.write(text);
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addNewProduct(BufferedReader reader) {
        LocalDate prodDate = null;
        String prodName = null;
        double price = 0;
        try {
            System.out.println(Constants.INPUT_PROD_NAME);
            prodName = reader.readLine();
            System.out.println(Constants.INPUT_PROD_PRICE);
            String prodPriceStr = reader.readLine();
            price = Double.parseDouble(prodPriceStr);
            System.out.println(Constants.INPUT_PROD_DATE);
            String prodDateStr = reader.readLine();
            prodDate = LocalDate.parse(prodDateStr);
        } catch (Exception e) {
            System.out.println(Constants.WRONG_DATA);
        }
        Product newProd = new Product(prodDate, prodName, price);
        Product.addToFile(newProd);
    }

    public static void deleteProduct(BufferedReader reader, FileReader readProductFile) {
        String prodName = null;
        boolean wasFound = false;
        try {
            System.out.println(Constants.INPUT_PROD_NAME);
            prodName = reader.readLine();
        } catch (Exception e) {
            System.out.println(Constants.WRONG_DATA);
        }
        // Читаем файл построчно, и если в строке найдено указанное наименование, удаляем строку
        try (BufferedReader textReader = new BufferedReader(readProductFile)) {
            ArrayList<String> data = new ArrayList<>();
            String line = textReader.readLine();
            while (line != null) {
                if (!line.contains(prodName)) {
                    data.add(line);
                } else {
                    wasFound = true;
                }
                line = textReader.readLine();
            }
            PrintWriter out = new PrintWriter(new FileWriter(Constants.PROD_FILE, false));
            for (String s : data) {
                out.println(s);
            }
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if (!wasFound) {
            System.out.println(Constants.NOT_FOUND);
        }
    }

    public static void createStartProductList() {
        //Utils.clearFile(Constants.PROD_FILE);

        Product product1 = new Product(LocalDate.parse(Constants.PROD_DATE_1), Constants.PROD_NAME_1, Constants.PROD_PRICE_1);
        Product.addToFile(product1);

        Product product2 = new Product(LocalDate.parse(Constants.PROD_DATE_2), Constants.PROD_NAME_2, Constants.PROD_PRICE_2);
        Product.addToFile(product2);

        Product product3 = new Product(LocalDate.parse(Constants.PROD_DATE_3), Constants.PROD_NAME_3, Constants.PROD_PRICE_3);
        Product.addToFile(product3);
    }

    public Product(LocalDate producedDate, String name, double price) {
        this.ID = UUID.randomUUID();
        this.producedDate = producedDate;
        this.name = name;
        this.price = price;
    }

    public Product (String line) {
        // TODO распарсить переданную строку и по полученным данным построить Продукт;
        producedDate = LocalDate.parse(Constants.PROD_DATE_1);
        name = Constants.PROD_NAME_1;
        price = Constants.PROD_PRICE_1;
        ID = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return ID.equals(product.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Идентификатор: " + ID +
                ", дата выпуска: " + producedDate +
                ", наименование: " + name +
                ", цена: " + price;
    }
}
