package com.aep.walmart.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author aliemrahpekesen
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchAPIResponseEntity {
	private String query;
	private String categoryId;
	private int totalResults;
	private int start;
	private int numItems;
	private Book items[];
}
