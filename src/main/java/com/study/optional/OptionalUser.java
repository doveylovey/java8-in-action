package com.study.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Optional 测试用的 User 实体类
 *
 * @author Administrator
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionalUser {
    private Long userId;
    private String userName;
    private List<OptionalOrder> orderList;
}
