package com.teksystem.capstone.validation;

import com.teksystem.capstone.database.dao.ProductDAO;
import com.teksystem.capstone.database.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class NameUniqueImpl implements ConstraintValidator<NameUnique, String>{
    public static final Logger LOG = LoggerFactory.getLogger(NameUniqueImpl.class);

    @Autowired
    ProductDAO productDao;

    @Override
    public void initialize(NameUnique constraintAnnotation){

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(StringUtils.isEmpty(value)){
            return true;
        }
        // Searches the database for the name
        // If nothing is found, product = null
        // So returns true, that it is indeed unique
        Product product = productDao.findProductByName(value);
        return (product == null);
    }
}
