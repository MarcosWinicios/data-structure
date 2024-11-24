package com.studies.dataStructures.tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Element<Type> {

    private Type value;
    private Element<Type> left;
    private Element<Type> right;

    public Element(Type value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

}
