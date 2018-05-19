package com.aep.walmart.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author aliemrahpekesen
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
	private String id;
	private String name;
	private String path;
	private Category[] children;
}
