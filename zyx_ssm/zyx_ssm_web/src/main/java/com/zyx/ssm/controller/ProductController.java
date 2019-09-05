package com.zyx.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.zyx.ssm.domain.Product;
import com.zyx.ssm.service.IProductService;
import com.zyx.ssm.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ModelAndView mv;

    @RequestMapping(value = "/save.do",method = RequestMethod.POST)
    @PreAuthorize("authentication.principal.username=='zyx' or hasRole('ROLE_BOSS')")
    public String save(Product product) throws Exception{
        product.setDepartureTime(DateUtils.StringToDate(product.getDepartureTimeStr(),"yyyy/MM/dd hh:mm"));
        productService.save(product);
        return "redirect:findAll.do?page=1&size=4";
    }

//    @RolesAllowed("USER")   //JSR-250注解
//    @Secured("ROLE_USER")   //secured注解
    @PreAuthorize("hasRole('ROLE_USER')") //支持表达式的注解
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "4") Integer size) throws Exception {
        List<Product> ps = productService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(ps);
        mv.addObject("pageInfo",pageInfo);

        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String id) throws Exception{
        Product product = productService.findById(id);
        mv.addObject("product",product);
        mv.setViewName("");
        return mv;
    }
}
