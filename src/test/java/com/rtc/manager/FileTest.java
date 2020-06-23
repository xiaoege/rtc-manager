package com.rtc.manager;

import java.io.File;

/**
 * @author ChenHang
 */
public class FileTest {
    public static void main(String[] args) {
        String dirPath = "/Users/chenhang/work/ali_qcc_1";
        File fileDir = new File(dirPath);
        if (fileDir.exists()) {
            File[] files = fileDir.listFiles();
            for (File file :
                    files) {
                if (file.isDirectory()) {
                    break;
                } else {

                }

            }
        }
        String str = "其他文化娱乐用品批发;雨水的收集、处理、利用;策划创意服务;黄金制品零售;铂金制品零售;百货零售（食品零售除外）;日用杂品综合零售;纺织品及针织品零售;服装零售;服装辅料零售;鞋零售;水果批发;干果、坚果批发;蔬菜批发;食用菌批发;冷冻肉批发;海味干货批发;蛋类批发;鞋批发;帽批发;水果零售;蔬菜零售;冷冻肉零售;海味干货零售;蛋类零售;化妆品零售;礼品鲜花零售;文化艺术咨询服务;互联网商品销售（许可审批类商品除外）;园艺作物、花卉的收购;佣金代理;服装批发;服装辅料批发;化妆品批发;日用器皿及日用杂货批发;办公设备耗材批发;陶瓷、玻璃器皿零售;灯具、装饰物品批发;非许可类医疗器械经营;文具用品批发;文具用品零售;钻石饰品批发;商品批发贸易（许可审批类商品除外）;商品零售贸易（许可审批类商品除外）;木制、塑料、皮革日用品零售;箱、包零售;钟表零售;帽零售;家居饰品批发;编制、缝纫日用品批发;建材、装饰材料批发;消防设备、器材的批发;钢材批发;时装设计服务;花卉作物批发;贸易代理;纺织品、针织品及原料批发;箱、包批发;货物进出口（专营专控商品除外）;充值卡销售;房屋租赁;陶瓷、玻璃器皿批发;花盆栽培植物零售;钢结构销售;场地租赁（不含仓储）;钻石销售;钻石首饰零售;宝石饰品批发;宝石饰品零售;玉石饰品批发;互联网商品零售（许可审批类商品除外）;白银制品批发;白银制品零售;医疗用品及器材零售（不含药品及医疗器械）;玉石饰品零售;水晶首饰批发;工艺美术品零售(象牙及其制品除外);水晶饰品零售;工艺品批发(象牙及其制品除外);珍珠饰品批发;珍珠饰品零售;其他人造首饰、饰品批发;其他人造首饰、饰品零售;广告业;污水处理及其再生利用;体育组织;竞技体育科技服务;体育运动咨询服务;运动场馆服务（游泳馆除外）;教育咨询服务;玩具零售;摄影服务;网络信息技术推广服务;绘画艺术创作服务;动漫及衍生产品设计服务;清扫、清洗日用品零售;体育用品及器材零售;日用家电设备零售;电子产品零售;糕点、糖果及糖批发;烟草制品批发;预包装食品零售;粮油零售;糕点、面包零售;乳制品零售;肉制品零售;保健食品零售(具体经营项目以《食品经营许可证》为准);熟食零售;预包装食品批发;许可类医疗器械经营;小型综合商店、小卖部;中药饮片零售;肉制品批发（鲜肉、冷却肉除外）;米、面制品及食用油批发;保健食品批发(具体经营项目以《食品经营许可证》为准);非酒精饮料、茶叶批发;散装" +
                "食品批发;药品零售;非酒精饮料及茶叶零售;烟草制品零售;酒类零售;散装食品零售;调味品零售;酒类批发;中药材批发;拍卖;儿童室内游艺厅（室）;冷热饮品制售;美容服务";
        System.out.println(str.length());

    }
}
