package com.itcast.proxy;

public class HouZi implements QuJingRen{
    @Override
    public void hit() {
        System.out.println("不怎么听话的打妖怪");
    }

    @Override
    public String eat(String food) {
        System.out.println("eat方法");
        return "吃"+food;
    }
}
