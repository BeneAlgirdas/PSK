package restaurants.mybatis.model;

public class Employee {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.EMPLOYEE.ID
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.EMPLOYEE.NAME
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.EMPLOYEE.RESTAURANT_ID
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    private Integer restaurantId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.EMPLOYEE.ID
     *
     * @return the value of PUBLIC.EMPLOYEE.ID
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.EMPLOYEE.ID
     *
     * @param id the value for PUBLIC.EMPLOYEE.ID
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.EMPLOYEE.NAME
     *
     * @return the value of PUBLIC.EMPLOYEE.NAME
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.EMPLOYEE.NAME
     *
     * @param name the value for PUBLIC.EMPLOYEE.NAME
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.EMPLOYEE.RESTAURANT_ID
     *
     * @return the value of PUBLIC.EMPLOYEE.RESTAURANT_ID
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    public Integer getRestaurantId() {
        return restaurantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.EMPLOYEE.RESTAURANT_ID
     *
     * @param restaurantId the value for PUBLIC.EMPLOYEE.RESTAURANT_ID
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

}