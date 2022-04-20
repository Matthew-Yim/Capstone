package com.teksystem.capstone.validation;

import com.teksystem.capstone.database.dao.ProductDAO;
import com.teksystem.capstone.database.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CatNotUniqueImpl implements ConstraintValidator<CatNotUnique, String> {
    public static final Logger LOG = LoggerFactory.getLogger(CatNotUniqueImpl.class);

    @Autowired
    ProductDAO productDao;

    @Override
    public void initialize(CatNotUnique constraintAnnotation){

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(StringUtils.isEmpty(value)){
            return true;
        }
        // Searches for the 4 products in the database
        // If the given "Category" doesn't bring up 1/4 products or if it doesn't == null
        // Returns true, otherwise the inputted category doesn't match the listed category
        // So return false
        // hard code mixer blender etc instead of pulling available drinks already in db
        Product product = productDao.findProductByCategory(value);
        return (product != null);
    }
}
