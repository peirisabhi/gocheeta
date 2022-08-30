package com.abhishek.gocheeta.adminservice.dto.datatable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-30
 * Time: 09:21
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class DataTableRequest {
    private int start;
    private int length;
    private int draw;
    private List<Order> order;
    private List<Column> columns;
    private Search search;
}
