package cn.bdqn.entity;

import java.io.Serializable;

/**
 * (Product)实体类
 *
 * @author makejava
 * @since 2021-04-06 09:18:44
 */
public class Product implements Serializable {
    private static final long serialVersionUID = -79347041416360836L;
    /**
     * 商品 id
     */
    private Integer id;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 库存量
     */
    private Integer quantity;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
