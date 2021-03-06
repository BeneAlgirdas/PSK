package restaurants.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import restaurants.mybatis.model.Employee;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Mapper
public interface EmployeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    int insert(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    Employee selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    List<Employee> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE
     *
     * @mbg.generated Sun Apr 18 13:41:58 EEST 2021
     */
    int updateByPrimaryKey(Employee record);
}