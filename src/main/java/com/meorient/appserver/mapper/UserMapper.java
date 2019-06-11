package com.meorient.appserver.mapper;

import com.meorient.appserver.pojo.Contact;
import com.meorient.appserver.pojo.Customer;
import com.meorient.appserver.pojo.User;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author sunwanghe
 * @date 2019/6/10 12:01
 */

@Mapper
public interface UserMapper {

    @Select("select customer_id,companyname\n" +
            "from customers\n" +
            "where customers.sales_rep_id=56484 and customers.__deprecated = 0")
    @Results({
            @Result(property="customerId",column="customer_id"),
            @Result(property="customerName",column="companyname"),
    })
    List<Customer> selectCompanyWithEmployee();

    @Select("select companyname,contacts.name,contacts.phone,contacts.homephone,contacts.mobilephone\n" +
            "from customers,contacts\n" +
            "where customers.customer_id=contacts.company_id  and contacts.__deprecated = 0  and customer_id in (select customer_id\n" +
            "from customers\n" +
            "where customers.sales_rep_id=56484  and customers.__deprecated = 0);")
    @Results({
            @Result(property="companyname",column="companyname"),
            @Result(property="contactname",column="name"),
            @Result(property="phone",column="phone"),
            @Result(property="homephone",column="homephone"),
            @Result(property="mobile",column="mobilephone"),
    })
    List<Contact> selectAllContacts();

    /**
     * 得到所有用户
     * @return
     */
    @Select("select email from employees")
    List<User> selectUsers();
}
