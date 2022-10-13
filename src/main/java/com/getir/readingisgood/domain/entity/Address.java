package com.getir.readingisgood.domain.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.getir.readingisgood.domain.entity.base.EntityBase;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Address extends EntityBase {

	@NotNull
	private String country;
	@NotNull
	private String city;
	private String district;
	private String freeTextAddress;
	@NotNull
	private String postalCode;
	@NotNull
	private String name;
	private float latitude;
	private float longitude;
	
	public Address(Long id, @NotNull String country, @NotNull String city, String district, String freeTextAddress,
			@NotNull String postalCode, @NotNull String name, float latitude, float longitude) {
		setId(id);
		this.country = country;
		this.city = city;
		this.district = district;
		this.freeTextAddress = freeTextAddress;
		this.postalCode = postalCode;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Address() {
		super();
	}
	
	
	
}
