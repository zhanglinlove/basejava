package com.model;
/**
 * 建造者
 * @author zhanglin
 *
 * @date 2018年7月11日
 */
public class Director {

	public Product constructProduct(ConcreteBuilder concreteBuilder){
        concreteBuilder.buildBasic();
        concreteBuilder.buildWalls();
        concreteBuilder.roofed();
        return concreteBuilder.buildProduct();
    }
}
