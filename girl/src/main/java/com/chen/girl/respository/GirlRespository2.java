package com.chen.girl.respository;

import com.chen.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface GirlRespository2 extends PagingAndSortingRepository<Girl,Integer>,JpaSpecificationExecutor {

    public Girl findById(Integer id);

    public Girl findGirlByAge(Integer age);



}
