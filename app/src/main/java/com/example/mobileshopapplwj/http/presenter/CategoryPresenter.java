package com.example.mobileshopapplwj.http.persenter;

import com.example.mobileshopapplwj.http.HttpMethods;
import com.example.mobileshopapplwj.http.entity.CategoryEntity;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class CategoryPresenter extends HttpMethods {
    /**
     * 获取一级分类列表
     *
     * @param subscriber
     */
    public static void getTopList(Subscriber<List<CategoryEntity>> subscriber) {
        Observable<List<CategoryEntity>> observable = categoryService.getTopList()
                .map(new HttpResultFunc<List<CategoryEntity>>());
        toSubscribe(observable, subscriber);
    }

    /**
     * 获取二级分类列表
     *
     * @param parentId
     */
    public static void getSecondList(Subscriber<List<CategoryEntity>> subscriber, int parentId) {
        Observable<List<CategoryEntity>> observable = categoryService.getSecondList(parentId)
                .map(new HttpResultFunc<List<CategoryEntity>>());
        toSubscribe(observable, subscriber);
    }

}
