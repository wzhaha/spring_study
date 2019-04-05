package com.example.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 使用Lombok最终在底层依然会生成对应的代码，代码简洁化（底层使用字节码技术实现）
 */
@Getter
@Setter
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

}
