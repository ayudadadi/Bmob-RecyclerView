package com.example.yls.demoa;

import java.util.List;



public class Weather {

    /**
     * time : 2019-03-25 09:00:00
     * cityInfo : {"city":"广州市","cityId":"101280101","parent":"广东","updateTime":"08:39"}
     * date : 20190325
     * message : Success !
     * status : 200
     * data : {"shidu":"99%","pm25":5,"pm10":6,"quality":"优","wendu":"13","ganmao":"各类人群可自由活动","yesterday":{"date":"24","sunrise":"06:29","high":"高温 17.0℃","low":"低温 12.0℃","sunset":"18:39","aqi":15,"ymd":"2019-03-24","week":"星期日","fx":"无持续风向","fl":"<3级","type":"中雨","notice":"记得随身携带雨伞哦"},"forecast":[{"date":"25","sunrise":"06:28","high":"高温 19.0℃","low":"低温 14.0℃","sunset":"18:40","aqi":18,"ymd":"2019-03-25","week":"星期一","fx":"无持续风向","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"26","sunrise":"06:27","high":"高温 24.0℃","low":"低温 16.0℃","sunset":"18:40","aqi":69,"ymd":"2019-03-26","week":"星期二","fx":"无持续风向","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"27","sunrise":"06:26","high":"高温 26.0℃","low":"低温 20.0℃","sunset":"18:41","aqi":52,"ymd":"2019-03-27","week":"星期三","fx":"无持续风向","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"28","sunrise":"06:25","high":"高温 27.0℃","low":"低温 20.0℃","sunset":"18:41","aqi":55,"ymd":"2019-03-28","week":"星期四","fx":"无持续风向","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"29","sunrise":"06:24","high":"高温 25.0℃","low":"低温 18.0℃","sunset":"18:41","aqi":52,"ymd":"2019-03-29","week":"星期五","fx":"无持续风向","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"30","sunrise":"06:23","high":"高温 25.0℃","low":"低温 19.0℃","sunset":"18:42","aqi":57,"ymd":"2019-03-30","week":"星期六","fx":"无持续风向","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"31","sunrise":"06:22","high":"高温 24.0℃","low":"低温 18.0℃","sunset":"18:42","ymd":"2019-03-31","week":"星期日","fx":"无持续风向","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"01","sunrise":"06:21","high":"高温 26.0℃","low":"低温 18.0℃","sunset":"18:42","ymd":"2019-04-01","week":"星期一","fx":"东北风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"02","sunrise":"06:20","high":"高温 26.0℃","low":"低温 18.0℃","sunset":"18:43","ymd":"2019-04-02","week":"星期二","fx":"东南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"03","sunrise":"06:19","high":"高温 27.0℃","low":"低温 20.0℃","sunset":"18:43","ymd":"2019-04-03","week":"星期三","fx":"南风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"04","sunrise":"06:18","high":"高温 30.0℃","low":"低温 22.0℃","sunset":"18:43","ymd":"2019-04-04","week":"星期四","fx":"南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"05","sunrise":"06:18","high":"高温 31.0℃","low":"低温 22.0℃","sunset":"18:44","ymd":"2019-04-05","week":"星期五","fx":"南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"06","sunrise":"06:17","high":"高温 30.0℃","low":"低温 22.0℃","sunset":"18:44","ymd":"2019-04-06","week":"星期六","fx":"南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"07","sunrise":"06:16","high":"高温 29.0℃","low":"低温 23.0℃","sunset":"18:45","ymd":"2019-04-07","week":"星期日","fx":"东南风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"08","sunrise":"06:15","high":"高温 29.0℃","low":"低温 23.0℃","sunset":"18:45","ymd":"2019-04-08","week":"星期一","fx":"东南风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"}]}
     */

    private String time;
    private CityInfoBean cityInfo;
    private String date;
    private String message;
    private int status;
    private DataBean data;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CityInfoBean getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfoBean cityInfo) {
        this.cityInfo = cityInfo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class CityInfoBean {
        /**
         * city : 广州市
         * cityId : 101280101
         * parent : 广东
         * updateTime : 08:39
         */

        private String city;
        private String cityId;
        private String parent;
        private String updateTime;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }

    public static class DataBean {
        /**
         * shidu : 99%
         * pm25 : 5
         * pm10 : 6
         * quality : 优
         * wendu : 13
         * ganmao : 各类人群可自由活动
         * yesterday : {"date":"24","sunrise":"06:29","high":"高温 17.0℃","low":"低温 12.0℃","sunset":"18:39","aqi":15,"ymd":"2019-03-24","week":"星期日","fx":"无持续风向","fl":"<3级","type":"中雨","notice":"记得随身携带雨伞哦"}
         * forecast : [{"date":"25","sunrise":"06:28","high":"高温 19.0℃","low":"低温 14.0℃","sunset":"18:40","aqi":18,"ymd":"2019-03-25","week":"星期一","fx":"无持续风向","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"26","sunrise":"06:27","high":"高温 24.0℃","low":"低温 16.0℃","sunset":"18:40","aqi":69,"ymd":"2019-03-26","week":"星期二","fx":"无持续风向","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"27","sunrise":"06:26","high":"高温 26.0℃","low":"低温 20.0℃","sunset":"18:41","aqi":52,"ymd":"2019-03-27","week":"星期三","fx":"无持续风向","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"28","sunrise":"06:25","high":"高温 27.0℃","low":"低温 20.0℃","sunset":"18:41","aqi":55,"ymd":"2019-03-28","week":"星期四","fx":"无持续风向","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"29","sunrise":"06:24","high":"高温 25.0℃","low":"低温 18.0℃","sunset":"18:41","aqi":52,"ymd":"2019-03-29","week":"星期五","fx":"无持续风向","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"30","sunrise":"06:23","high":"高温 25.0℃","low":"低温 19.0℃","sunset":"18:42","aqi":57,"ymd":"2019-03-30","week":"星期六","fx":"无持续风向","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"31","sunrise":"06:22","high":"高温 24.0℃","low":"低温 18.0℃","sunset":"18:42","ymd":"2019-03-31","week":"星期日","fx":"无持续风向","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"01","sunrise":"06:21","high":"高温 26.0℃","low":"低温 18.0℃","sunset":"18:42","ymd":"2019-04-01","week":"星期一","fx":"东北风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"02","sunrise":"06:20","high":"高温 26.0℃","low":"低温 18.0℃","sunset":"18:43","ymd":"2019-04-02","week":"星期二","fx":"东南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"03","sunrise":"06:19","high":"高温 27.0℃","low":"低温 20.0℃","sunset":"18:43","ymd":"2019-04-03","week":"星期三","fx":"南风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"04","sunrise":"06:18","high":"高温 30.0℃","low":"低温 22.0℃","sunset":"18:43","ymd":"2019-04-04","week":"星期四","fx":"南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"05","sunrise":"06:18","high":"高温 31.0℃","low":"低温 22.0℃","sunset":"18:44","ymd":"2019-04-05","week":"星期五","fx":"南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"06","sunrise":"06:17","high":"高温 30.0℃","low":"低温 22.0℃","sunset":"18:44","ymd":"2019-04-06","week":"星期六","fx":"南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"07","sunrise":"06:16","high":"高温 29.0℃","low":"低温 23.0℃","sunset":"18:45","ymd":"2019-04-07","week":"星期日","fx":"东南风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"08","sunrise":"06:15","high":"高温 29.0℃","low":"低温 23.0℃","sunset":"18:45","ymd":"2019-04-08","week":"星期一","fx":"东南风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"}]
         */

        private String shidu;
        private int pm25;
        private int pm10;
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

        public int getPm25() {
            return pm25;
        }

        public void setPm25(int pm25) {
            this.pm25 = pm25;
        }

        public int getPm10() {
            return pm10;
        }

        public void setPm10(int pm10) {
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
             * date : 24
             * sunrise : 06:29
             * high : 高温 17.0℃
             * low : 低温 12.0℃
             * sunset : 18:39
             * aqi : 15
             * ymd : 2019-03-24
             * week : 星期日
             * fx : 无持续风向
             * fl : <3级
             * type : 中雨
             * notice : 记得随身携带雨伞哦
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private int aqi;
            private String ymd;
            private String week;
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

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
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
             * date : 25
             * sunrise : 06:28
             * high : 高温 19.0℃
             * low : 低温 14.0℃
             * sunset : 18:40
             * aqi : 18
             * ymd : 2019-03-25
             * week : 星期一
             * fx : 无持续风向
             * fl : <3级
             * type : 小雨
             * notice : 雨虽小，注意保暖别感冒
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private int aqi;
            private String ymd;
            private String week;
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

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
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
}
