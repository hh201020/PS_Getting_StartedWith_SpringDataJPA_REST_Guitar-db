package com.guitar.db.model.projections;

import java.math.BigDecimal;

import org.springframework.data.rest.core.config.Projection;

import com.guitar.db.model.Manufacturer;
import com.guitar.db.model.Model;
import com.guitar.db.model.ModelType;

@Projection(name="modelDetail", types={Model.class})
public interface ModelDetail {
	String getName();
	BigDecimal getPrice();
	Manufacturer getManufacturer();
	ModelType getModelType();
	int getFrets();
	String getWoodType();
}
