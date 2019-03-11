
package ru.churkin.tm.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setCurrentUser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setCurrentUser"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userDto" type="{http://endpoint.tm.churkin.ru/}user" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setCurrentUser", propOrder = {
    "userDto"
})
public class SetCurrentUser {

    protected User userDto;

    /**
     * Gets the value of the userDto property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUserDto() {
        return userDto;
    }

    /**
     * Sets the value of the userDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUserDto(User value) {
        this.userDto = value;
    }

}
