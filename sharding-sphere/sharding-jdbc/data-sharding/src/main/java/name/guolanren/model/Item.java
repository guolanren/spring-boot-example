package name.guolanren.model;

/**
 * @author guolanren
 */
public class Item {

    private String name;

    private Long orderId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
