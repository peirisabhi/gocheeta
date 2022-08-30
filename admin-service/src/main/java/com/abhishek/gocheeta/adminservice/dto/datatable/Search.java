package com.abhishek.gocheeta.adminservice.dto.datatable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-30
 * Time: 09:23
 */
@Setter
@Getter
@NoArgsConstructor
public class Search {
    private String value;
    private String regexp;
}

