package com.gunu.todolist.controller;

import com.gunu.todolist.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    /*
    * @RequestMapping으로 value, method를 지정하는 방식
    * @GetMapping으로 value를 지정하는방식 (method는 GetMapping,PostMapping,PutMapping,DeleteMapping으로 구분)
    * @PathVariable을 사용해서 매개변수와 일치시켜 사용하는 방법
    * @requestParam을 사용해서 값 전달하는 방법
    * DTO객체 이용하는 방법
    * */

    //http://localhost:8080/api/requestmapping
    @RequestMapping(value = "/requestmapping", method = RequestMethod.GET)
    public String requestMapping(){
        return "requestMapping!!";
    }

    //http://localhost:8080/api/getmapping
    @GetMapping("/getmapping")
    public String getMapping(){
        return "getMapping!!";
    }

    //http://localhost:8080/api/pathvariable/{String 값}
    @GetMapping("/pathvariable/{name}")
    public String pathvariable(@PathVariable String name){
        //매개변수와 이름이 동일하게 사용 해야 함
        return name;
    }

    //http://localhost:8080/api/pathvariable2/{String 값}
    @GetMapping("/pathvariable2/{name}")
    public String pathvariable2(@PathVariable("name") String value){
        //매개변수와 이름이 동일하지 않을 때 사용 함
        return value;
    }

    //http://localhost:8080/api/requestParam?name=gunu&email=gunu@gmail.com
    @GetMapping("/requestParam")
    public String requestParam(@RequestParam String name, @RequestParam String email){
        return name + " " + email;
    }

    //http://localhost:8080/api/requestParam2?name=gunu&email=gunu@gmail.com
    @GetMapping("/requestParam2")
    public String requestParam2(@RequestParam Map<String, String> param){
        //어떤 URI에 어떤 값이 넘어올지 모를때 사용(정해진 값이 없을 때)
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + ":" + map.getValue() + "\n");
        });

        //param.forEach((key,value) -> sb.append(key).append(":").append(value).append("\n"));

        return sb.toString();
    }

    //http://localhost:8080/api/requestParam3?name=gunu&email=gunu@gmail.com
    @GetMapping("/requestParam3")
    public String requestParam3(MemberDTO memberDTO){
        //memberDTO객체를 생성해야 함
        //어떤 URI에 어떤 값이 넘어올지 모를때 사용(정해진 값이 없을 때)
        return memberDTO.toString();
    }
}
