package com.example.portalback.base.model;

import lombok.Data;

import java.util.List;

/**
 * @author LIN
 */
@Data
public class PageModel {

    protected Integer pageNo;

    protected Integer pageSize;

    protected List<FilterModel> filters;

    protected List<FilterModel> sorts;

}
