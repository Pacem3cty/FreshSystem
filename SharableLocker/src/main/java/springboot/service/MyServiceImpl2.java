package springboot.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import springboot.enitiy.Goods;

import java.util.List;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-19 11:38
 */
@Service
public class MyServiceImpl2 implements MyService{
    @Override
    public List<Goods> printInfo() {
        System.out.println("it has invoke the method in MyServiceImpl 2");
        return null;
    }
}
