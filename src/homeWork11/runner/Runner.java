package homeWork11.runner;

import homeWork11.order.Order;
import homeWork11.product.Product;
import homeWork11.utils.Constants;
import homeWork11.utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    public static void run() {
        //Product.createStartProductList();
        System.out.println(Constants.SALUT);
        Order order = null;
        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                Utils.showSteps();

                String step = bufReader.readLine();
                switch (step) {
                    case "1": // Просмотреть список товаров
                        try (FileReader readProduct = new FileReader(Constants.PROD_FILE)) {
                            Utils.showProductList(readProduct);
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "2": // Добавить новый товар в список доступных товаров
                        Product.addNewProduct(bufReader);
                        break;
                    case "3": // Удалить товар из списка доступных товаров
                        try (FileReader readProduct = new FileReader(Constants.PROD_FILE)) {
                            Product.deleteProduct(bufReader, readProduct);
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "4": // Добавить товар в заказ
                        try (FileReader readProduct = new FileReader(Constants.PROD_FILE)) {
                            order = Order.addProductToOrder(bufReader, readProduct, order);
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "5" : // 5 - Удалить товар из заказа
                        System.out.println(Constants.IN_WORK);
                        break;
                    case "6" :
                        order = Order.saveOrder(order);
                        break;
                    case "7":
                        return;
                    default:
                        System.out.println(Constants.WRONG);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
