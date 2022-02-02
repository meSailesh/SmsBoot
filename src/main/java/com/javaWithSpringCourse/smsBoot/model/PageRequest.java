package com.javaWithSpringCourse.smsBoot.model;

import org.springframework.hateoas.RepresentationModel;

import java.util.List;

/**
 * Created by sailesh on 2/2/22.
 */
public class PageRequest extends RepresentationModel<PageRequest>{
    private List contents;
    private Integer pageNumber;
    private Integer pageSize;
    private Integer numberOfElements;
    private String sortBy;
    private Boolean isSorted;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(Integer numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Boolean getSorted() {
        return isSorted;
    }

    public void setSorted(Boolean sorted) {
        isSorted = sorted;
    }

    public List getContents() {
        return contents;
    }

    public void setContents(List contents) {
        this.contents = contents;
    }
}
