package com.chen.girl.controller;

import com.chen.girl.domain.Result;
import com.chen.girl.properties.GirlProperties;
import com.chen.girl.respository.GirlRespository;
import com.chen.girl.domain.Girl;
import com.chen.girl.service.GirlService;
import com.chen.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GirlController {

    @Autowired
    private GirlProperties girlProperties;
    @Autowired
    private GirlRespository girlRespository;

    @Autowired
    private GirlService girlService;
   @GetMapping(value = "/girls")
    public List<Girl> girlList(){
       return  girlRespository.findAll();
   }
   @PostMapping(value = "/girls")
   public Result<Girl> insetGirl(@Validated Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return  null;
            //return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
    girl.setAge(girl.getAge());
    girl.setCupSize(girl.getCupSize());
    return ResultUtil.success(girl);



    }
    @GetMapping(value = "/girls/{id}")
    public Girl getGile(@PathVariable("id") Integer id){
       return girlRespository.findOne(id);
    }

   @GetMapping(value = "/girls2")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age){
        Girl girl = new Girl();
       girl.setAge(age);
       girl.setCupSize(cupSize);
       return girlRespository.save(girl);

   }

  @PutMapping(value = "/girl/{id}")
  public Girl girlsUpdate(@PathVariable("id") Integer id,@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setId(id);
        return girlRespository.save(girl);
  }
@DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id){
        girlRespository.delete(id);

}

@GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByage(@PathVariable("age") Integer age){
        return girlRespository.findGirlByAge(age);
}
@PostMapping("/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
}
@GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
       girlService.getAge(id);
}

   }





