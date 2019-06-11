package com.meorient.appserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.meorient.appserver.mapper.UserMapper;
import com.meorient.appserver.pojo.CallLog;
import com.meorient.appserver.pojo.Contact;
import com.meorient.appserver.pojo.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sunwanghe
 * @date 2019/6/10 12:00
 */

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;
    

    @RequestMapping("/customers")
    public String getCustomers(){
        int code = -1;
        List<Customer> customerList = userMapper.selectCompanyWithEmployee();
        if(customerList==null||customerList.size()==0){
            code = -1;
        }else{
            code = 0;
        }

        JSONObject jsonObject = new JSONObject();

        JSONObject data = new JSONObject();
        JSONArray customers = new JSONArray();
        for(Customer customer:customerList){
            JSONObject object = new JSONObject();
            object.put("id",customer.getCustomerId());
            object.put("name",customer.getCustomerName());
            customers.add(object);
        }

        data.put("customers",customers);
        jsonObject.put("code",code);
        jsonObject.put("data",data);
        return jsonObject.toString();
    }

    @RequestMapping("/contacts")
    public String getContacts(@RequestParam("companyid") String companyid){
        int code = -1;
        List<Contact> contactList = userMapper.selectAllContacts(companyid);
        if(contactList==null||contactList.size()==0){
            code = -1;
        }else{
            code = 0;
        }

        JSONObject jsonObject = new JSONObject();

        JSONObject data = new JSONObject();
        JSONArray contacts = new JSONArray();
        for(Contact contact:contactList){
            JSONObject object = new JSONObject();
            object.put("companyname",contact.getCompanyname());
            object.put("contactname",contact.getContactname());
            object.put("phone",contact.getPhone());
            object.put("homephone", contact.getHomephone());
            object.put("mobile",contact.getMobile());
            contacts.add(object);
        }

        data.put("contacts",contacts);
        jsonObject.put("code",code);
        jsonObject.put("data",data);
        return jsonObject.toString();
    }
}
