
package com.itroi.itroi.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Cart complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Cart"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UserID" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ProductIDs"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ProductID" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TotalAmount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cart", propOrder = {
    "userID",
    "productIDs",
    "totalAmount",
    "status"
})
public class Cart {

    @XmlElement(name = "UserID")
    protected int userID;
    @XmlElement(name = "ProductIDs", required = true)
    protected Cart.ProductIDs productIDs;
    @XmlElement(name = "TotalAmount")
    protected double totalAmount;
    @XmlElement(required = true)
    protected String status;

    /**
     * Gets the value of the userID property.
     * 
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     */
    public void setUserID(int value) {
        this.userID = value;
    }

    /**
     * Gets the value of the productIDs property.
     * 
     * @return
     *     possible object is
     *     {@link Cart.ProductIDs }
     *     
     */
    public Cart.ProductIDs getProductIDs() {
        return productIDs;
    }

    /**
     * Sets the value of the productIDs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cart.ProductIDs }
     *     
     */
    public void setProductIDs(Cart.ProductIDs value) {
        this.productIDs = value;
    }

    /**
     * Gets the value of the totalAmount property.
     * 
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the totalAmount property.
     * 
     */
    public void setTotalAmount(double value) {
        this.totalAmount = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ProductID" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "productID"
    })
    public static class ProductIDs {

        @XmlElement(name = "ProductID", type = Integer.class)
        protected List<Integer> productID;

        /**
         * Gets the value of the productID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the productID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProductID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Integer }
         * 
         * 
         */
        public List<Integer> getProductID() {
            if (productID == null) {
                productID = new ArrayList<Integer>();
            }
            return this.productID;
        }
        public void setProductID(List<Integer> productID) {
            if (this.productID == null) {
                this.productID = new ArrayList<>();
            }
            this.productID.clear();
            if (productID != null) {
                this.productID.addAll(productID);
            }
        }

    }

}
