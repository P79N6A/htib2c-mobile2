var portal = {};
portal.coupon = {
    returnRightCoupons: function (ids, coupsJson) {
        //结果
        var resultJson = [];
        if (coupsJson.length == 0) {
            return resultJson;
        }
        if (ids.length == 0) {
            return coupsJson;
        }
        if (ids.length == coupsJson.length) {
            return coupsJson;
        }
        //自身coupon数据
        var myCouponJson = [];
        for (var num = 0; num < ids.length; num++) {
            for (var i = 0; i < coupsJson.length; i++) {
                console.log("1:-----------------" + coupsJson[i].id);
                if (coupsJson[i].id == ids[num]) {
                    // resultJson.push(coupsJson[i]);
                    myCouponJson.push(coupsJson[i]);
                }
            }
        }
        ;
        //遍历找出同类
        for (var j = 0; j < coupsJson.length; j++) {
            if (portal.coupon.validataCoupon(myCouponJson, coupsJson[j])) {
                resultJson.push(coupsJson[j]);
            }
        }
        for (var k = 0; k < myCouponJson.length; k++) {
            resultJson.push(myCouponJson[k]);
        }
        if (resultJson.length == 0) {
            return myCouponJson;
        }
        return resultJson;
    },
    validataCoupon: function (myCouponJson, domCouponJson) {
        var domKind = domCouponJson.couponAttribute + "" + domCouponJson.couponIsaddMC + "" + domCouponJson.couponIsaddAC;
        var domType = portal.coupon.checkCouponType(domKind);
        var result = [];
        for (var i = 0; i < myCouponJson.length; i++) {
            var myKind = myCouponJson[i].couponAttribute + "" + myCouponJson[i].couponIsaddMC + "" + myCouponJson[i].couponIsaddAC;
            var myType = portal.coupon.checkCouponType(myKind);
            var array = portal.coupon.getCouponTypes(myType);
            result = result.concat(array).distinct();
        }
        ;
        if (myCouponJson.length == 1) {
            result = result.distinct();
        } else {
            result = result.undistinct().distinct();
        }
        return result.contains(domType);
    },
    checkCouponType: function (kind) {
        var kindJson = {"1": "111", "2": "112", "3": "122", "4": "121", "5": "211", "6": "212", "7": "222", "8": "221"};
        for (var key in kindJson) {
            if (kindJson[key] == kind) {
                return key;
            }
        }

    },
    getCouponTypes: function (type) {
        var kindJson = {
            "1": ["1", "2", "5", "6"],
            "2": ["1", "2"],
            "3": [],
            "4": ["5", "6"],
            "5": ["1", "4", "5", "6"],
            "6": ["1","4"],
            "7": [],
            "8": ["5"]
        };
        for (var key in kindJson) {
            if (key == type) {
                return kindJson[key];
            }
        }

    },
    wechatMessage: function (ids, coupsJson, message, type, sourceMoney) {

        var resultJson = [];
        if (coupsJson.length == 0) {
            return message;
        }
        if (ids.length == 0) {
            return message;
        }

        var sourceMessage = '';
        var packageName = '';

        var money = sourceMoney;
        if (type == "1") {//已使用过优惠券
            var arr = message.split(' 套餐价格：');


            sourceMessage = arr[0] + " 套餐价格：" + sourceMoney + "\n";

        } else {//未使用过优惠券
            var arr = message.split('- <应付金额>：');
            var arr1 = message.split(' <套餐名称>：');
            sourceMessage = arr[0];

            packageName = arr1[1];
            sourceMessage = sourceMessage + "套餐名称：" + packageName + "\n";
            sourceMessage = sourceMessage + "套餐价格：￥" + sourceMoney;


        }


        var cMessage = '';
        //计算金额 拼接短信
        for (var num = 0; num < ids.length; num++) {
            for (var i = 0; i < coupsJson.length; i++) {

                if (coupsJson[i].id == ids[num] && coupsJson[i].couponType == "3") {
                    cMessage = cMessage + "\t";
                    cMessage = cMessage + coupsJson[i].couponName + "：";
                    cMessage = cMessage + "-" + coupsJson[i].couponContent + "元\n";
                    money = money - coupsJson[i].couponContent;
                } else if (coupsJson[i].id == ids[num] && coupsJson[i].couponType == "1") {
                    console.log();
                    cMessage = cMessage + "\t";
                    cMessage = cMessage + coupsJson[i].couponName + "：";
                    cMessage = cMessage + coupsJson[i].couponContent + "折\n";
                }
                else if (coupsJson[i].id == ids[num] && coupsJson[i].couponType == "2") {
                    cMessage = cMessage + "\t";
                    cMessage = cMessage + coupsJson[i].couponName + "：";
                    cMessage = cMessage + coupsJson[i].couponContent + "\n";
                }
            }
        }
        for (var num = 0; num < ids.length; num++) {
            for (var i = 0; i < coupsJson.length; i++) {
                if (coupsJson[i].id == ids[num] && coupsJson[i].couponType == "1") {
                    money = money * coupsJson[i].couponContent / 10;
                }
            }
        }
        ;

        money = money.toFixed(2) + "\n";
        sourceMessage = sourceMessage.replace(sourceMoney, money);
        sourceMessage = sourceMessage + cMessage + "合计金额：￥" + money;

        return sourceMessage;


    },
}
// 数组去重
Array.prototype.distinct = function () {
    var arr = this,
        i,
        j,
        len = arr.length;
    for (i = 0; i < len; i++) {
        for (j = i + 1; j < len; j++) {
            if (arr[i] == arr[j]) {
                arr.splice(j, 1);
                len--;
                j--;
            }
        }
    }
    return arr;
};
Array.prototype.undistinct = function () {
    var arr = this;
    var result = [];
    for (var s = 0; s < arr.length; s++) {
        for (var x = s + 1; x < arr.length; x++) {
            if (arr[s] == arr[x]) {
                result.push(arr[s]);
                break;
            }
        }
    }
    return result;
};
Array.prototype.contains = function (needle) {
    for (i in this) {
        if (this[i] == needle) return true;
    }
    return false;
}

