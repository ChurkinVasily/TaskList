
package ru.churkin.tm.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for task complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="task"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="project" type="{http://endpoint.tm.churkin.ru/}project" minOccurs="0"/&gt;
 *         &lt;element name="timeFinish" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="timeStart" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="user" type="{http://endpoint.tm.churkin.ru/}user" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "task", propOrder = {
        "description",
        "id",
        "name",
        "project",
        "timeFinish",
        "timeStart",
        "user"
})
public class Task {

    protected String description;
    protected String id;
    protected String name;
    protected Project project;
    protected String timeFinish;
    protected String timeStart;
    protected User user;

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the project property.
     *
     * @return possible object is
     * {@link Project }
     */
    public Project getProject() {
        return project;
    }

    /**
     * Sets the value of the project property.
     *
     * @param value allowed object is
     *              {@link Project }
     */
    public void setProject(Project value) {
        this.project = value;
    }

    /**
     * Gets the value of the timeFinish property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTimeFinish() {
        return timeFinish;
    }

    /**
     * Sets the value of the timeFinish property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTimeFinish(String value) {
        this.timeFinish = value;
    }

    /**
     * Gets the value of the timeStart property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTimeStart() {
        return timeStart;
    }

    /**
     * Sets the value of the timeStart property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTimeStart(String value) {
        this.timeStart = value;
    }

    /**
     * Gets the value of the user property.
     *
     * @return possible object is
     * {@link User }
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     *
     * @param value allowed object is
     *              {@link User }
     */
    public void setUser(User value) {
        this.user = value;
    }

}
