package com.abhishek.gocheeta.adminservice.dto.datatable;

import lombok.*;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-30
 * Time: 09:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataTableResponse<T> {
    private List<T> data;
    private int recordsFiltered;
    private int recordsTotal;
    private int draw;
}
