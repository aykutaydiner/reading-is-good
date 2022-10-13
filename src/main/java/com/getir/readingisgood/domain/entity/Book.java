package com.getir.readingisgood.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.getir.readingisgood.domain.entity.base.EntityBase;
import com.getir.readingisgood.domain.enums.BookCategory;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends EntityBase {

	@NotNull
	private String name;
	@NotNull
	private String author;
	@Enumerated(EnumType.STRING)
	private BookCategory bookCategory;
	private String additionalInfo;
	@Min(0)
	private int stockCount;
	@NotNull
	private String imageUrl;
	@NotNull
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "book_id")
	private List<BookAmount> bookAmountList;

	public Book() {
		super();
	}

	public Book(Long id, @NotNull String name, @NotNull String author, BookCategory bookCategory, String additionalInfo,
			int stockCount, @NotNull String imageUrl, @NotNull List<BookAmount> bookAmountList) {
		setId(id);
		this.name = name;
		this.author = author;
		this.bookCategory = bookCategory;
		this.additionalInfo = additionalInfo;
		this.stockCount = stockCount;
		this.imageUrl = imageUrl;
		this.bookAmountList = bookAmountList;
	}


}
