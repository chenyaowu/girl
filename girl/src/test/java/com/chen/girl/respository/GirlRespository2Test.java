package com.chen.girl.respository;

import com.chen.girl.domain.Girl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.*;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlRespository2Test {
    @Autowired
    private GirlRespository2 girlRespository2;
    @Test
    public void test(){
        Girl girl = girlRespository2.findGirlByAge(10);
        System.out.println(girl);
    }
    @Test
    public void test2(){
        /*
        org.springframework.data.domain.Pageable;
        页数从0开始
         */
        Pageable pageable = new PageRequest(0,5);
        Page<Girl> page = girlRespository2.findAll(pageable);

        /*
        查询总页数
        page.getTotalPages();
        查询总记录数
        page.getTotalElements();
        当前页（从第0页开始）
        page.getNumber();
        查询到的内容List<User>
        page.getContent();
        当前页面的记录数
        page.getNumberOfElements();
         */
    }
    public void testSort(){
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(0,5,sort);
        Page<Girl> page = girlRespository2.findAll(pageable);
    }

    public void testJpaSpecificationExecutor(){
        Specification<Girl> specification = new Specification<Girl>() {
            @Override
            public Predicate toPredicate(Root<Girl> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path path = root.get("age");
                Path path1 = root.get("name");
                Path path2 = root.get("id");
                Predicate predicate = criteriaBuilder.and(criteriaBuilder.gt(path,20),criteriaBuilder.like(path1,"%zhang%)"));
                return  criteriaBuilder.and(predicate,criteriaBuilder.gt(path2,3));

            }
        };
        girlRespository2.findAll(specification);
    }
}