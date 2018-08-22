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
        if(ids.length==coupsJson.length){
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
        };
        //遍历找出同类
        for (var j = 0; j < coupsJson.length; j++) {
            if (portal.coupon.validataCoupon(myCouponJson, coupsJson[j])) {
                resultJson.push(coupsJson[j]);
            }
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
            result = result.concat(array);
        }
        ;
        result = result.distinct();
        return result.contains(domType);
    },
    checkCouponType: function (kind) {
        var kindJson = {"1": "111", "2": "110", "3": "100", "4": "101", "5": "211", "6": "210", "7": "200", "8": "201"};
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
            "6": ["1"],
            "7": [],
            "8": ["5"]
        };
        for (var key in kindJson) {
            if (key == type) {
                return kindJson[key];
            }
        }

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
Array.prototype.contains = function (needle) {
    for (i in this) {
        if (this[i] == needle) return true;
    }
    return false;
}

