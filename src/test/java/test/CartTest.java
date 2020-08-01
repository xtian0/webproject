package test;

import com.fruit.pojo.Cart;
import com.fruit.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author : Xin Tian
 * @date : 12:39 pm 22/7/20
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "Kiwi", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.addItem(new CartItem(1, "Kiwi", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.addItem(new CartItem(2, "Passion", 1, new BigDecimal(10), new BigDecimal(10)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "Kiwi", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.addItem(new CartItem(1, "Kiwi", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.addItem(new CartItem(2, "Passion", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clean() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "Kiwi", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.addItem(new CartItem(1, "Kiwi", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.addItem(new CartItem(2, "Passion", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.clean();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "Kiwi", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.addItem(new CartItem(1, "Kiwi", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.addItem(new CartItem(2, "Passion", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.updateCount(1, 5);
        System.out.println(cart);
    }
}