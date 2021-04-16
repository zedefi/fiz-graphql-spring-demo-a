package com.fiz.demo.a.resolves;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.fiz.demo.a.pojo.Hello;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class Subscription implements GraphQLSubscriptionResolver {


    public Publisher<Hello> data() {
//        Observable<Hello> observable = Observable.create( e -> {
//            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
//            executorService.scheduleAtFixedRate(() -> {
//                Hello h = new Hello();
//                h.setMessage("hello " + new Date().toString());
//                e.onNext(h);
//            }, 0, 2, TimeUnit.SECONDS);
//        });
//
//        ConnectableObservable connectableObservable = observable.share().publish();
//        connectableObservable.connect();
//        return connectableObservable.toFlowable(BackpressureStrategy.BUFFER);

        Publisher<Hello> publisher = s -> {
            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
            executorService.scheduleAtFixedRate(() -> {
                Hello h = new Hello();
                h.setMessage("hello " + new Date().toString());
                s.onNext(h);
            }, 0, 2, TimeUnit.SECONDS);
        };

        return publisher;
    }

}
