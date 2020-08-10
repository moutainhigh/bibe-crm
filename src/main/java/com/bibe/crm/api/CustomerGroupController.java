package com.bibe.crm.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bibe.crm.entity.dto.CustomerGroupDTO;
import com.bibe.crm.entity.dto.CustomerMoveDTO;
import com.bibe.crm.entity.dto.FindCustomerGroupDTO;
import com.bibe.crm.entity.po.User;
import com.bibe.crm.entity.vo.RespVO;
import com.bibe.crm.service.CustomerGroupService;
import com.bibe.crm.service.CustomerService;
import com.bibe.crm.utils.ShiroUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customerGroup")
public class CustomerGroupController {


    @Resource
    private CustomerService customerService;

    @Resource
    private CustomerGroupService customerGroupService;

    
    /**
     * 修改
     * @param dto
     * @return
     */
    @PutMapping("/update")
    public RespVO update(@RequestBody CustomerGroupDTO dto){
        return customerGroupService.update(dto);
    }

    /**
     * 添加
     * @param dto
     * @return
     */
    @PostMapping("/add")
    public RespVO add(@RequestBody CustomerGroupDTO dto){
        return customerGroupService.add(dto);
    }


    /**
     * 编辑
     * @param id
     * @return
     */
    @GetMapping("/show")
    public RespVO show(Integer id){
        return customerGroupService.show(id);
    }


    /**
     * 分页列表
     * @param dto
     * @return
     */
    @PostMapping("/pageList")
    public RespVO pageList(@RequestBody FindCustomerGroupDTO dto){
        Page page = dto.getPage();
        return customerService.customerGroupPageList(dto,page);
    }


    /**
     * 设置公客分组列表
     * @return
     */
    @GetMapping("/list")
    public RespVO list(){
        return customerGroupService.list();
    }



    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public RespVO delete(Integer id){
       return customerGroupService.delete(id);
    }


    /**
     * 领取公客
     * @param ids
     * @return
     */
    @PutMapping("/getCustomer")
    public RespVO getCustomer(@RequestBody List<Integer> ids){
        User userInfo = ShiroUtils.getUserInfo();
        return customerService.move(userInfo.getId(),null,ids);
    }
}
