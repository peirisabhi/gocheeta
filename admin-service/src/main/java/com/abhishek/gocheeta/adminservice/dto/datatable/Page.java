package com.abhishek.gocheeta.adminservice.dto.datatable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-30
 * Time: 09:22
 */
@Getter
@Setter
@NoArgsConstructor
public class Page<T> {

    public Page(List<T> data) {
        this.data = data;
    }

    private List<T> data;
    private int recordsFiltered;
    private int recordsTotal;
    private int draw;
}
