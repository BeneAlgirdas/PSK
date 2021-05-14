package restaurants.mybatis.dao;

import java.util.List;
import restaurants.mybatis.model.Customer;
import restaurants.mybatis.model.Restaurant;

public interface CustomerMapper {

    /**
     * This method was written by Algirdas Benetis.(sukcius)
     * This method corresponds to the database table PUBLIC.CUSTOMER
     *
     * @Algirdas_Benetis
     */
    List<Restaurant> getRestaurants();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CUSTOMER
     *
     * @mbg.generated Tue Apr 20 18:53:15 EEST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CUSTOMER
     *
     * @mbg.generated Tue Apr 20 18:53:15 EEST 2021
     */
    int insert(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CUSTOMER
     *
     * @mbg.generated Tue Apr 20 18:53:15 EEST 2021
     */
    Customer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CUSTOMER
     *
     * @mbg.generated Tue Apr 20 18:53:15 EEST 2021
     */
    List<Customer> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CUSTOMER
     *
     * @mbg.generated Tue Apr 20 18:53:15 EEST 2021
     */
    int updateByPrimaryKey(Customer record);
}