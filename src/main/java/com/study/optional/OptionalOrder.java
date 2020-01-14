package com.study.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Optional 测试用的 Order 实体类
 *
 * @author Administrator
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionalOrder {
    private Long userId;
    private Long orderId;
}
