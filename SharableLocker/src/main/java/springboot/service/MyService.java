package springboot.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import springboot.enitiy.Goods;

import java.util.List;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-19 11:37
 */


public interface MyService {
    List<Goods> printInfo();
}
