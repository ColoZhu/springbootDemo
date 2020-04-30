package czs.web;


import czs.bean.JSONResult;
import czs.bean.UserEntity;
import czs.bean.ValidationDemo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ValidationController {


    /**
     * @param demo          待校验实体
     * @param bindingResult 保存对参数的校验结果
     * @return
     * @Valid 表示对该实体进行校验
     */
    @RequestMapping(value = "validation", method = RequestMethod.POST)
    public JSONResult validate(@Valid @RequestBody ValidationDemo demo, BindingResult bindingResult) {
        JSONResult jsonResult = new JSONResult();
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e -> {
                jsonResult.setState("0001");
                jsonResult.setData("校验失败");
                jsonResult.setMsg(e.getDefaultMessage());
            });
        } else {
            jsonResult.setState("11111");
            jsonResult.setData("校验成功");
            jsonResult.setMsg("校验成功");
        }
        return jsonResult;
    }


    @RequestMapping(value = "create", method = RequestMethod.POST)
    public JSONResult save(@Validated({UserEntity.AddGroup.class}) @RequestBody UserEntity userEntity, BindingResult bindingResult) {
        //doSomething
        JSONResult jsonResult = new JSONResult();
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e -> {
                jsonResult.setState("0001");
                jsonResult.setData("校验失败");
                jsonResult.setMsg(e.getDefaultMessage());
            });
        } else {
            jsonResult.setState("11111");
            jsonResult.setData("校验成功");
            jsonResult.setMsg("校验成功");
        }

        return jsonResult;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public JSONResult update(@Validated({UserEntity.UpdateGroup.class}) @RequestBody UserEntity userEntity, BindingResult bindingResult) {
        //doSomething
        JSONResult jsonResult = new JSONResult();
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e -> {
                jsonResult.setState("0001");
                jsonResult.setData("校验失败");
                jsonResult.setMsg(e.getDefaultMessage());
            });
        } else {
            jsonResult.setState("11111");
            jsonResult.setData("校验成功");
            jsonResult.setMsg("校验成功");
        }
        return jsonResult;
    }


}