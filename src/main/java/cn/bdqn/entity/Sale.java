package cn.bdqn.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Sale)实体类
 *
 * @author makejava
 * @since 2021-04-06 09:18:51
 */
public class Sale implements Serializable {
    private static final long serialVersionUID = 937642933951646946L;
    /**
     * 记录id
     */
    private Integer id;
    /**
     * 销售单价
     */
    private Double price;
    /**
     * 数量
     */
    private Integer quantity;
    /**
     * 总价
     */
    private Double totalPrice;
    /**
     * 销售日期
     */
    private Date saleDate;
    /**
     * 销售员id
     */
    private Integer userId;
    /**
     * 商品id
     */
    private Integer productId;

    private String realName;
    private String productName;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", saleDate=" + saleDate +
                ", userId=" + userId +
                ", productId=" + productId +
                ", realName='" + realName + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
