package com.htichina.web.util.coupon;

import com.htichina.common.web.Constant;
import com.htichina.wsclient.payment.Coupon;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by 刘宁 on 2018/8/13.
 */
public class couponUtil {

    private final static JSONObject kindJson;
    private final static JSONObject typeJson;

    static {
        String kind = Constant.KINDJSONSTRING;
        String type = Constant.TYPEJSONSTRING;
        kindJson = JSONObject.fromObject(kind);
        typeJson = JSONObject.fromObject(type);
    }

    /**
     * 判断用户选的优惠券是否合法
     * @param ids 已选优惠券ID
     * @param coupons 当前所有可用优惠券
     * @return
     */
    public static boolean validataCoupon(String[] ids, List<Coupon> coupons) {
        boolean flag = false;
        try {
            if(ids.length==0){
                return true;
            }
            List<Coupon> myCouponList = new ArrayList<Coupon>();
            if (coupons != null && coupons.size() > 0) {
                for (Coupon coupon : coupons) {
                    for (int i = 0; i < ids.length; i++) {
                        if (coupon.getId().equals(ids[i])) {
                            myCouponList.add(coupon);
                        }
                    }
                }
            }
            if (myCouponList.size() > 0) {
                String key = checkKind(myCouponList.get(0));
                List<String> keys = new ArrayList<String>();
                for (Coupon myCoupon : myCouponList.subList(1, myCouponList.size())) {
                    String myKey = checkKind(myCoupon);
                    keys.add(myKey);
                }
                flag = CheckType(key, keys);
            }
        }catch (Exception e){
            flag=false;
        }
        return flag;
    }

    /**
     * 判断优惠券种类
     *
     * @param coupon
     * @return
     */
    private static String checkKind(Coupon coupon) {
        Iterator<String> iterator = kindJson.keys();
        String myKey = coupon.getCouponAttribute() + coupon.getCouponIsaddMC() + coupon.getCouponIsaddAC();
        String key = "";
        while (iterator.hasNext()) {
            String kindkey = iterator.next();
            String value = kindJson.getString(kindkey);
            if (value.equals(myKey)) {
                key = kindkey;
            }

        }
        return key;
    }

    /**
     * 判断是否是合格类型
     *
     * @param key
     * @param keys
     * @return
     */
    private static boolean CheckType(String key, List<String> keys) {
        boolean flag = false;
        JSONArray value = typeJson.getJSONArray(key);
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < value.size(); i++) {
            String typeValue = (String) value.get(i);
            result.add(typeValue);
        }
        if (result.size() > keys.size()) {
            if (!(("1".equals(key) && keys.contains("2") && keys.contains("5")) || ("5".equals(key) && keys.contains("4") && keys.contains("6")))) {
                int num=0;
                for(String type:keys){
                    if (result.contains(type)){
                        num++;
                    }
                }
                if(num==keys.size()){
                    flag=true;
                }
            }
        }

        return flag;
    }

//test
    public static void main(String[] args) {
        String[] ids = {"1", "2","3"};
        List<Coupon> coupons = new ArrayList<>();
        Coupon coupon1 = new Coupon();
        coupon1.setId("1");
        coupon1.setCouponAttribute("2");
        coupon1.setCouponIsaddMC("0");
        coupon1.setCouponIsaddAC("1");
        Coupon coupon2 = new Coupon();
        coupon2.setId("2");
        coupon2.setCouponAttribute("1");
        coupon2.setCouponIsaddMC("1");
        coupon2.setCouponIsaddAC("1");
        Coupon coupon3 = new Coupon();
        coupon3.setId("3");
        coupon3.setCouponAttribute("1");
        coupon3.setCouponIsaddMC("1");
        coupon3.setCouponIsaddAC("1");
        coupons.add(coupon1);
        coupons.add(coupon2);
        coupons.add(coupon3);
        couponUtil.validataCoupon(ids, coupons);
    }
}
