package com.aep.walmart.domain.dto;

import com.aep.walmart.util.DisplayUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author aliemrahpekesen
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
	private int itemId;
	private String name;
	private double salePrice;
	private String categoryPath;
	private String shortDescription;
	private String longDescription;
	private String thumbnailImage;
	private String mediumImage;
	private String largeImage;
	private String stock;

	public String shDispWeb() {
		return DisplayUtil.clearAndResize(this.shortDescription, 30);
	}

	public String nameDispWeb() {
		return DisplayUtil.clearAndResize(this.name, 10);
	}
}
