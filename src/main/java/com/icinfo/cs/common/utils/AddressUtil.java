package com.icinfo.cs.common.utils;
import com.icinfo.cs.base.service.ICodeAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：联动地址
 *
 * @author: wangjin
 * @date：2017-06-30
 */

@Component
@Lazy(false)
public class AddressUtil {
    @Autowired
    private ICodeAddressService codeAddressService;
    //声明
    private static HashMap addMap = new HashMap();

    private static AddressUtil addressUtil; // 关键点1 静态初使化 一个工具类

    public static void setAddressUtil(AddressUtil addressUtil) {
        AddressUtil.addressUtil = addressUtil;
    }

    // 关键二 通过@PostConstruct 和 @PreDestroy 方法 实现初始化和销毁bean之前进行的操作
    @PostConstruct
    public void init() {
        addressUtil = this;
        addressUtil.codeAddressService = this.codeAddressService;
        addMap.put("address",codeAddressService.selectBycodeAddress());
    }

    /**
     * 描述：清空map中的值
     */
    public static void clearAddress() {
        addMap.clear();
    }

    /**
     * 描述：重新给地址赋予新的地址值
     */
    public static void changAddresMap() {
        clearAddress();
        addMap.put("address",  addressUtil.codeAddressService.selectBycodeAddress());
    }


    public static Map getAddressMapValue(){
        return addMap;
    }


    /*
        调用方法：

         //获取对象中的值
        selectCodeAddress = (SelectCodeAddress) AddressUtil.getAddressMapValue().get("address");


          @RequestMapping(value = "/refresh", method = RequestMethod.POST)
            @ResponseBody
            public AjaxResult  Refresh(){
                try {
                    AddressUtil.changAddresMap();
                    return AjaxResult.success("刷新成功");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                    return AjaxResult.error("执行失败");
            }




     */


}
