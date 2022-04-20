package com.teksystem.capstone.formbean;

import com.teksystem.capstone.validation.CatNotUnique;
import com.teksystem.capstone.validation.NameUnique;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class ProductFormBean {

    private Integer id;

    @NameUnique(message = "Name already exists in the database")
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @Min(value = 0, message = "The Price can not be lower than $0.00")
    @Range(min=2, message = "Price is required")
    @NotNull(message = "Price is Required")
    private Double price;

    @NotBlank(message = "Image URL is required")
    private String imageUrl;

    //@CatNotUnique(message = "Category does not match available categories")
    @NotBlank(message = "Category is required")
    private String category;
}
