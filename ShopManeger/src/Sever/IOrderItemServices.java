package Sever;




import Form.OrderItem;

import java.util.List;

public interface IOrderItemServices {
    List<OrderItem> getOrderItems();

    void add (OrderItem newOrderItem);

    void update();

    OrderItem getOrderItemById(long id);
}
