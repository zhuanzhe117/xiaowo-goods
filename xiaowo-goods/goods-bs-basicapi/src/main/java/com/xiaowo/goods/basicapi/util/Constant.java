package com.xiaowo.goods.basicapi.util;

/* =======================================================
 * 小窝
 * 日 期：9/19/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：常量
 * ========================================================
 */
public interface Constant {
    /**
     * Mongodb表名
     */
    enum MongoTable {

        ELEMENT("element"),

        GOODS("goods"),

        GOODS_SKU("goods_sku"),

        GOODS_GROUP("goods_group"),

        STANDARD_GOODS("standard_goods"),

        STANDARD_GOODS_GROUP("standard_goods_group"),

        GOODS_SKU_HISTORY("goods_sku_history"),

        NEW_HOUSE("new_house"),

        NEW_HOUSE_SKU("new_house_sku"),

        NEW_HOUSE_GROUP("new_house_group"),

        SECOND_HOUSE("second_house"),

        SECOND_HOUSE_SKU("second_house_sku"),

        SECOND_HOUSE_GROUP("second_house_group"),

        NEW_HOUSE_SKU_HISTORY("new_house_sku_history"),

        RENT_HOUSE("rent_house"),

        RENT_HOUSE_SKU("rent_house_sku"),

        RENT_HOUSE_GROUP("rent_house_group"),

        SECOND_CAR_GOODS("second_car_goods"),
        SECOND_CAR("second_car"),

        SECOND_CAR_GROUPS("second_car_groups"),
        SECOND_CAR_GROUP("second_car_group"),

        SECOND_CAR_SKUS("second_car_skus"),

        NEW_CAR("new_car"),

        NEW_CAR_GROUP("new_car_group"),

        NEW_CAR_SKU("new_car_sku"),
        /**
         * 健康体检
         */
        HEALTH_CHECK("health_check"),
        HEALTH_CHECK_SKU("health_check_sku"),
        HEALTH_CHECK_GROUP("health_check_group"),

        /**
         * 海外体检
         **/
        OVERSEA_CHECK("oversea_check"),

        OVERSEA_CHECK_SKU("oversea_check_sku"),

        OVERSEA_CHECK_GROUP("oversea_check_group"),

        /**
         * 海外远程会诊
         **/
        OVERSEA_CONSULATION("oversea_consulation"),

        OVERSEA_CONSULATION_SKU("oversea_consulation_sku"),

        OVERSEA_CONSULATION_GROUP("oversea_consulation_group"),

        /**
         * 旅游地产
         */
        TOURIST_ESTATE("tourist_estate"),

        TOURIST_ESTATE_SKU("tourist_estate_sku"),

        TOURIST_ESTATE_GROUP("tourist_estate_group"),

        SECOND_CAR_SKU("second_car_sku"),

        /**
         * 定时任务
         */
        CRON_JOB("cron_job");

        private final String key;

        private MongoTable(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return this.key;
        }
    }

    /**
     * Mongodb主键前缀
     */
    enum MongoKey {

        ELEMENT("element"),

        GOODS("goodsId"),

        GOODS_SKU("skuId"),

        GOODS_GROUP("groupId"),
        /**
         *
         */
        STANDARD_GOOD("standardGoodsId"),

        STANDARD_GOOD_SKU("standardGoodsSkuId"),

        STANDARD_GOOD_GROUP("standardGroupId"),

        NEW_HOUSE("newHouseId"),

        NEW_HOUSE_SKU("newHouseSkuId"),

        NEW_HOUSE_GROUP("newHouseGroupId"),

        SECOND_HOUSE("secondHouseId"),

        SECOND_HOUSE_SKU("secondHouseSkuId"),

        SECOND_HOUSE_GROUP("secondHouseGroupId"),

        RENT_HOUSE("rentHouseId"),

        RENT_HOUSE_SKU("rentHouseSkuId"),

        RENT_HOUSE_GROUP("rentHouseGroupId"),

        NEW_HOUSE_SKU_HISTORY("newHouseSkuHistoryId"),

        NEW_CAR("newCarId"),

        NEW_CAR_SKU("newCarSkuId"),

        NEW_CAR_GROUP("newCarGroupId"),

        HEALTH_CHECK("healthCheckId"),
        HEALTH_CHECK_SKU("healthCheckSkuId"),
        HEALTH_CHECK_GROUP("healthCheckGroupId"),

        /**
         * 海外体检
         **/
        OVERSEA_CHECK("overseaCheckId"),

        OVERSEA_CHECK_SKU("overseaCheckSkuId"),

        OVERSEA_CHECK_GROUP("overseaCheckGroupId"),

        /**
         * 海外远程会诊
         **/
        OVERSEA_CONSULATION("overseaConsulationId"),

        OVERSEA_CONSULATION_SKU("overseaConsulationSkuId"),

        OVERSEA_CONSULATION_GROUP("overseaConsulationGroupId"),

        /**
         * 旅游地产
         */
        TOURIST_ESTATE("touristEstateId"),

        TOURIST_ESTATE_SKU("touristEstateSkuId"),

        TOURIST_ESTATE_GROUP("touristEstateGroupId"),

        SECOND_CAR("secondCarId"),
        SECOND_CAR_SKU("secondCarSkuId"),
        SECOND_CAR_GROUP("secondCarGroupId"),
        /**
         *  定时任务
         */
        CRON_JOB("cronJobId");

        private final String key;

        private MongoKey(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return this.key;
        }
    }

}
