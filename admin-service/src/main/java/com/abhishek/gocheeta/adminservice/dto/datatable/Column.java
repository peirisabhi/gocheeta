package com.abhishek.gocheeta.adminservice.dto.datatable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-30
 * Time: 09:20
 */
@Setter
@Getter
@NoArgsConstructor
public class Column {
    private String data;
    private String name;
    private Boolean searchable;
    private Boolean orderable;
    private Search search;

    public Column(String data) {
        this.data = data;
    }
}
