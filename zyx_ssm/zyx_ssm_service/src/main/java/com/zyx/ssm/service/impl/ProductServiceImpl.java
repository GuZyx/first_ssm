package com.zyx.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.zyx.ssm.service.IProductService;
import com.zyx.ssm.dao.IProductDao;
import com.zyx.ssm.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public Product findById(String id) throws Exception {
        return productDao.findById(id);
    }

    @Override
    public List<Product> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page, size);
        return productDao.findAll();
    }
}

