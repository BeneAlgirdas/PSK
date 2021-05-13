package restaurants.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import restaurants.mybatis.model.Customer;
import restaurants.mybatis.model.Restaurant;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Mapper
public interface RestaurantMapper {
    /**
     * This method was written by Algirdas Benetis.
     * This method corresponds to the database table PUBLIC.CUSTOMER
     *
     * @Algirdas_Benetis
     */
    List<Customer> getCustomers(Integer restaurantId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.RESTAURANT
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.RESTAURANT
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    int insert(Restaurant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.RESTAURANT
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    Restaurant selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.RESTAURANT
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    List<Restaurant> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.RESTAURANT
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    int updateByPrimaryKey(Restaurant record);
}