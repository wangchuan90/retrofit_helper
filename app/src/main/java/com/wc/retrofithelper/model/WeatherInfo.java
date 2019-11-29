package com.wc.retrofithelper.model;

import java.util.List;

public class WeatherInfo {

    /**
     * shidu : 49%
     * pm25 : 50.0
     * pm10 : 82.0
     * quality : 良
     * wendu : 2
     * ganmao : 极少数敏感人群应减少户外活动
     * forecast : [{"date":"29","high":"高温 5℃","low":"低温 -1℃","ymd":"2019-11-29","week":"星期五","sunrise":"07:07","sunset":"16:50","aqi":110,"fx":"西南风","fl":"<3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"30","high":"高温 4℃","low":"低温 -2℃","ymd":"2019-11-30","week":"星期六","sunrise":"07:08","sunset":"16:50","aqi":140,"fx":"西风","fl":"<3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"01","high":"高温 5℃","low":"低温 -3℃","ymd":"2019-12-01","week":"星期日","sunrise":"07:09","sunset":"16:49","aqi":61,"fx":"西风","fl":"4-5级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"02","high":"高温 4℃","low":"低温 -3℃","ymd":"2019-12-02","week":"星期一","sunrise":"07:10","sunset":"16:49","aqi":59,"fx":"西南风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"03","high":"高温 7℃","low":"低温 -1℃","ymd":"2019-12-03","week":"星期二","sunrise":"07:11","sunset":"16:49","aqi":72,"fx":"西风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"04","high":"高温 6℃","low":"低温 -1℃","ymd":"2019-12-04","week":"星期三","sunrise":"07:12","sunset":"16:49","aqi":82,"fx":"北风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"05","high":"高温 7℃","low":"低温 0℃","ymd":"2019-12-05","week":"星期四","sunrise":"07:13","sunset":"16:49","fx":"东风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"06","high":"高温 3℃","low":"低温 -4℃","ymd":"2019-12-06","week":"星期五","sunrise":"07:14","sunset":"16:49","fx":"东北风","fl":"4-5级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"07","high":"高温 3℃","low":"低温 -4℃","ymd":"2019-12-07","week":"星期六","sunrise":"07:15","sunset":"16:48","fx":"东北风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"08","high":"高温 3℃","low":"低温 -3℃","ymd":"2019-12-08","week":"星期日","sunrise":"07:16","sunset":"16:48","fx":"西北风","fl":"<3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"09","high":"高温 5℃","low":"低温 -2℃","ymd":"2019-12-09","week":"星期一","sunrise":"07:17","sunset":"16:48","fx":"西风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"10","high":"高温 7℃","low":"低温 -1℃","ymd":"2019-12-10","week":"星期二","sunrise":"07:18","sunset":"16:48","fx":"西南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"11","high":"高温 7℃","low":"低温 -2℃","ymd":"2019-12-11","week":"星期三","sunrise":"07:19","sunset":"16:49","fx":"北风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"12","high":"高温 5℃","low":"低温 -2℃","ymd":"2019-12-12","week":"星期四","sunrise":"07:20","sunset":"16:49","fx":"西风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"13","high":"高温 7℃","low":"低温 0℃","ymd":"2019-12-13","week":"星期五","sunrise":"07:20","sunset":"16:49","fx":"西南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"}]
     * yesterday : {"date":"28","high":"高温 5℃","low":"低温 -1℃","ymd":"2019-11-28","week":"星期四","sunrise":"07:06","sunset":"16:50","aqi":75,"fx":"西南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"}
     */

    private String shidu;
    private double pm25;
    private double pm10;
    private String quality;
    private String wendu;
    private String ganmao;
    private YesterdayBean yesterday;
    private List<ForecastBean> forecast;

    public String getShidu() {
        return shidu;
    }

    public void setShidu(String shidu) {
        this.shidu = shidu;
    }

    public double getPm25() {
        return pm25;
    }

    public void setPm25(double pm25) {
        this.pm25 = pm25;
    }

    public double getPm10() {
        return pm10;
    }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public YesterdayBean getYesterday() {
        return yesterday;
    }

    public void setYesterday(YesterdayBean yesterday) {
        this.yesterday = yesterday;
    }

    public List<ForecastBean> getForecast() {
        return forecast;
    }

    public void setForecast(List<ForecastBean> forecast) {
        this.forecast = forecast;
    }

    public static class YesterdayBean {
        /**
         * date : 28
         * high : 高温 5℃
         * low : 低温 -1℃
         * ymd : 2019-11-28
         * week : 星期四
         * sunrise : 07:06
         * sunset : 16:50
         * aqi : 75
         * fx : 西南风
         * fl : <3级
         * type : 晴
         * notice : 愿你拥有比阳光明媚的心情
         */

        private String date;
        private String high;
        private String low;
        private String ymd;
        private String week;
        private String sunrise;
        private String sunset;
        private int aqi;
        private String fx;
        private String fl;
        private String type;
        private String notice;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getYmd() {
            return ymd;
        }

        public void setYmd(String ymd) {
            this.ymd = ymd;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public int getAqi() {
            return aqi;
        }

        public void setAqi(int aqi) {
            this.aqi = aqi;
        }

        public String getFx() {
            return fx;
        }

        public void setFx(String fx) {
            this.fx = fx;
        }

        public String getFl() {
            return fl;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }
    }

    public static class ForecastBean {
        /**
         * date : 29
         * high : 高温 5℃
         * low : 低温 -1℃
         * ymd : 2019-11-29
         * week : 星期五
         * sunrise : 07:07
         * sunset : 16:50
         * aqi : 110
         * fx : 西南风
         * fl : <3级
         * type : 阴
         * notice : 不要被阴云遮挡住好心情
         */

        private String date;
        private String high;
        private String low;
        private String ymd;
        private String week;
        private String sunrise;
        private String sunset;
        private int aqi;
        private String fx;
        private String fl;
        private String type;
        private String notice;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getYmd() {
            return ymd;
        }

        public void setYmd(String ymd) {
            this.ymd = ymd;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public int getAqi() {
            return aqi;
        }

        public void setAqi(int aqi) {
            this.aqi = aqi;
        }

        public String getFx() {
            return fx;
        }

        public void setFx(String fx) {
            this.fx = fx;
        }

        public String getFl() {
            return fl;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }
    }
}
