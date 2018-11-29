package pattern.builder;

import lombok.Data;

/**
 * 短信套餐
 *
 * @author 0xZzzz
 */
@Data
public class MobilePackage {

    /**
     * 短信条数
     */
    private int shortInfo;
    /**
     * 套餐价格
     */
    private double money;
    /**
     * 套餐彩铃
     */
    private String music;

}
