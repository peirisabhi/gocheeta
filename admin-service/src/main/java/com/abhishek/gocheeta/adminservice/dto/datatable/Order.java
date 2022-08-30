package com.abhishek.gocheeta.adminservice.dto.datatable;

import lombok.*;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-30
 * Time: 09:21
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Order {
    private Integer column;
    private Direction dir;
}

