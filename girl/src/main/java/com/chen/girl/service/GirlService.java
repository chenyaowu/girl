package com.chen.girl.service;

import com.chen.girl.domain.Girl;
import com.chen.girl.enums.ResultEnum;
import com.chen.girl.exception.GirlException;
import com.chen.girl.respository.GirlRespository;
import com.chen.girl.respository.GirlRespository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRespository girlRespository;
    @Transactional
    public void insertTwo(){
        Girl girl = new Girl();
        girl.setCupSize("A");
        girl.setAge(10);
        girlRespository.save(girl);

        Girl girl1 = new Girl();
        girl1.setAge(21);
        girl1.setCupSize("Bbbbbb");
        girlRespository.save(girl1);
    }
    public void getAge(Integer id) throws Exception {
        Girl girl = girlRespository.findOne(id);
        Integer age = girl.getAge();
        if(age<10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10 && age<16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    public Girl findOne(Integer id){
        return girlRespository.findOne(id);
    }
}
